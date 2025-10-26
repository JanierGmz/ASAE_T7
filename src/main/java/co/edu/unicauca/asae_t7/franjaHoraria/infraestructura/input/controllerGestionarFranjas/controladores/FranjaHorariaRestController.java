package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.DeleteMapping;

import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.mappers.FranjaHorariaMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaConDetalleDTORespuesta;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/franjas-horarias")
@RequiredArgsConstructor
public class FranjaHorariaRestController {
    
    private final GestionarFranjaHorariaCUIntPort objGestionarFranjaHorariaCUInt;
    private final FranjaHorariaMapperInfraestructuraDominio objMapeador;

    @PostMapping
    public ResponseEntity<FranjaHorariaDTORespuesta> create (@RequestBody @Valid FranjaHorariaDTOPeticion objPeticion){
        FranjaHoraria objFranjaCrear = objMapeador.mappearDePeticionAFranjaHoraria(objPeticion);
        FranjaHoraria objFranjaCreada = objGestionarFranjaHorariaCUInt.crear(objFranjaCrear);
        ResponseEntity<FranjaHorariaDTORespuesta> objRespuesta = new ResponseEntity<FranjaHorariaDTORespuesta>(
            objMapeador.mappearDeFranjaHorariaARespuesta(objFranjaCreada),
            HttpStatus.CREATED
        );
        return objRespuesta;
    }

    @GetMapping("/curso/{idCurso}")
    public ResponseEntity<List<FranjaHorariaConDetalleDTORespuesta>> buscarFranjasHorariasPorCursoId(@PathVariable Integer idCurso) {
        ResponseEntity<List<FranjaHorariaConDetalleDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaHorariaConDetalleDTORespuesta>>(
            objMapeador.mappearDeFranjasHorariasConDetalleARespuesta(this.objGestionarFranjaHorariaCUInt.buscarFranjasHorariasPorCursoId(idCurso)),
            HttpStatus.OK
        );
        return objRespuesta;
    }

    @DeleteMapping("/curso/{idCurso}")
    public ResponseEntity<Boolean> eliminarFranjasHorariasPorCursoId(@PathVariable Integer idCurso) {
        boolean eliminado = this.objGestionarFranjaHorariaCUInt.eliminarFranjasHorariasPorCursoId(idCurso);
        ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(eliminado, HttpStatus.NO_CONTENT);
        return response;
    }
}

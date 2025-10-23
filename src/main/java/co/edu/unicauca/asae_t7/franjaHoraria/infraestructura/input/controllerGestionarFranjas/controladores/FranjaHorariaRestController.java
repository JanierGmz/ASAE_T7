package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.mappers.FranjaHorariaMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

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
}

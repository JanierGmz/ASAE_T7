package co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.controladores;

import co.edu.unicauca.asae_t7.docente.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae_t7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/docentes")
@RequiredArgsConstructor
public class DocenteRestController {

    private final GestionarDocenteCUIntPort objGestionarDocentesCUInt;
    private final DocenteMapperInfraestructuraDominio objMapeador;


    @PostMapping()
    public ResponseEntity<DocenteDTORespuesta> create(@RequestBody @Valid DocenteDTOPeticion objDocente){
        Docente objDocenteCrear = objMapeador.docentePeticionToDocente(objDocente);
        Docente objDocenteCreado = objGestionarDocentesCUInt.crear(objDocenteCrear);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(objMapeador.docenteToDocenteRespuesta(objDocenteCreado), HttpStatus.CREATED);
        return objRespuesta;
    }
}

package co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import co.edu.unicauca.asae_t7.curso.aplicacion.input.GestionarCursoCUIntPort;
import co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.mappers.CursoMapperInfraestructuraDominio;
import co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.DTORespuesta.CursoDTORespuesta;


@RestController
@RequestMapping("/api") 
@RequiredArgsConstructor
public class CursoRestController {
    private final GestionarCursoCUIntPort objGestionarCursoCUInt;
    private final CursoMapperInfraestructuraDominio objMapeador;

    @GetMapping("/cursos")
    public ResponseEntity<List<CursoDTORespuesta>> listar() {
        ResponseEntity<List<CursoDTORespuesta>> objRespuesta = new ResponseEntity<List<CursoDTORespuesta>>(
            objMapeador.mappearDeCursosARespuesta(objGestionarCursoCUInt.listar()), 
            HttpStatus.OK);
        return objRespuesta;
    }
}

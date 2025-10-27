package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaDeCursoDTORespuesta;
import org.springframework.web.bind.annotation.DeleteMapping;

import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.mappers.FranjaHorariaMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaDeDocenteDTORespuesta;

@RestController
@RequestMapping("/api/franjas-horarias")
@RequiredArgsConstructor
public class FranjaHorariaRestController {

        private final GestionarFranjaHorariaCUIntPort objGestionarFranjaHorariaCUInt;
        private final FranjaHorariaMapperInfraestructuraDominio objMapeador;

        /**
         * Endpoint para crear una nueva franja horaria
         * 
         * @param objPeticion
         * @return
         */
        @PostMapping
        public ResponseEntity<FranjaHorariaDTORespuesta> create(
                        @RequestBody @Valid FranjaHorariaDTOPeticion objPeticion) {
                FranjaHoraria objFranjaCrear = objMapeador.mappearDePeticionAFranjaHoraria(objPeticion);
                FranjaHoraria objFranjaCreada = objGestionarFranjaHorariaCUInt.crear(objFranjaCrear);
                ResponseEntity<FranjaHorariaDTORespuesta> objRespuesta = new ResponseEntity<FranjaHorariaDTORespuesta>(
                                objMapeador.mappearDeFranjaHorariaARespuesta(objFranjaCreada),
                                HttpStatus.CREATED);
                return objRespuesta;
        }

        /**
         * Endpoint para obtener franjas horarias por ID de curso
         * 
         * @param idCurso
         * @return
         */
        @Valid
        @GetMapping("/{idCurso}")
        public ResponseEntity<List<FranjaHorariaDTORespuesta>> obtenerPorCursoId(
                        @PathVariable @Min(value = 1, message = "{franjaHoraria.curso.id.min}") Integer idCurso) {
                ResponseEntity<List<FranjaHorariaDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaHorariaDTORespuesta>>(
                                objMapeador
                                                .mappearDeProductosARespuesta(this.objGestionarFranjaHorariaCUInt
                                                                .obtenerPorCursoId(idCurso)),
                                HttpStatus.OK);
                return objRespuesta;
        }

        /**
         * Endpoint para buscar franjas horarias por ID de curso
         * 
         * @param idCurso
         * @return
         */
        @Valid
        @GetMapping("/curso/{idCurso}")
        public ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>> buscarFranjasHorariasPorCursoId(
                        @PathVariable @Min(value = 1, message = "{franjaHoraria.curso.id.min}") Integer idCurso) {
                ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>>(
                                objMapeador.mappearDeFranjasHorariasDeDocenteARespuesta(
                                                this.objGestionarFranjaHorariaCUInt
                                                                .buscarFranjasHorariasPorCursoId(idCurso)),
                                HttpStatus.OK);
                return objRespuesta;
        }

        /**
         * Endpoint para eliminar franjas horarias por ID de curso
         * 
         * @param idCurso
         * @return
         */
        @Valid
        @DeleteMapping("/curso/{idCurso}")
        public ResponseEntity<Boolean> eliminarFranjasHorariasPorCursoId(
                        @PathVariable @Min(value = 1, message = "{franjaHoraria.curso.id.min}") Integer idCurso) {
                boolean eliminado = this.objGestionarFranjaHorariaCUInt.eliminarFranjasHorariasPorCursoId(idCurso);
                ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(eliminado, HttpStatus.NO_CONTENT);
                return response;
        }

        /**
         * Endpoint para buscar franjas sin curso por ID de curso
         * 
         * @param idCurso
         * @return
         */
        @Valid
        @GetMapping("/curso-sin-detalle/{idCurso}")
        public ResponseEntity<List<FranjaHorariaDeCursoDTORespuesta>> buscarFranjasSinCursoPorCursoId(
                        @PathVariable @Min(value = 1, message = "{franjaHoraria.curso.id.min}") Integer idCurso) {
                ResponseEntity<List<FranjaHorariaDeCursoDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaHorariaDeCursoDTORespuesta>>(
                                objMapeador.mappearDeFranjasHorariasDeCursoARespuesta(
                                                this.objGestionarFranjaHorariaCUInt
                                                                .buscarFranjasSinCursoPorCursoId(idCurso)),
                                HttpStatus.OK);
                return objRespuesta;
        }

        /***
         * Endpoint para buscar franjas horarias por ID de docente
         * 
         * @param idDocente
         * @return
         */
        @Valid
        @GetMapping("/docente/{idDocente}")
        public ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>> buscarFranjasHorariasPorDocenteId(
                        @PathVariable @Min(value = 1, message = "{franjaHoraria.docente.id.min}") Integer idDocente) {
                ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>>(
                                objMapeador.mappearDeFranjasHorariasPorDocenteARespuesta(
                                                this.objGestionarFranjaHorariaCUInt
                                                                .buscarFranjasHorariasPorDocenteId(idDocente)),
                                HttpStatus.OK);

                return objRespuesta;
        }
}

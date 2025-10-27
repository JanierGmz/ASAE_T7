package co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae_t7.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.DTORespuesta.EspacioFisicoDTORespuesta;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.mappers.EspacioFisicoMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/espaciosFisicos")
@RequiredArgsConstructor
public class EspacioFisicoRestController {
    private final GestionarEspacioFisicoCUIntPort objGestionarEspacioFisicoCUInt;
    private final EspacioFisicoMapperInfraestructuraDominio objMapeador;

    /**
     * Endpoint para listar espacios físicos según nombre y capacidad
     *
     * @param nombre    Patrón de búsqueda para el nombre
     * @param capacidad Capacidad mínima
     * @return Lista de espacios físicos que cumplen con los criterios
     */
    @Valid
    @GetMapping()
    public ResponseEntity<List<EspacioFisicoDTORespuesta>> listarPorNombreYCapacidadEspaciosFisicos(
            @RequestParam String nombre,
            @RequestParam @Min(value = 1, message = "{espacioFisico.capacidad.min}") Integer capacidad) {

        ResponseEntity<List<EspacioFisicoDTORespuesta>> objRespuesta = new ResponseEntity<List<EspacioFisicoDTORespuesta>>(
                objMapeador.mappearDeEspaciosFisicosARespuesta(
                        this.objGestionarEspacioFisicoCUInt.listarPorNombreYCapacidadEspaciosFisicos(nombre,
                                capacidad)),
                HttpStatus.OK);
        return objRespuesta;
    }

    /**
     * Endpoint para actualizar el estado de un espacio físico por su ID
     *
     * @param id     ID del espacio físico a actualizar
     * @param estado Nuevo estado del espacio físico
     * @return Respuesta indicando si la actualización fue exitosa
     */
    @Valid
    @PatchMapping("/actualizarEstado")
    public ResponseEntity<Boolean> actualizarEstadoPorId(@RequestParam @Min(value = 1, message = "{espacioFisico.capacidad.min}") Integer id, @RequestParam Boolean estado) {

        boolean resultado = objGestionarEspacioFisicoCUInt.actualizarEstadoPorId(id, estado);
        return new ResponseEntity<>(resultado, HttpStatus.OK);

    }
}

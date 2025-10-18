package co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
public class OficinaDTOPeticion {

    @NotEmpty(message = "{oficina.nombre.notEmpty}")
    @NotNull(message = "{oficina.nombre.notNull}")
    @Size(min = 3, max = 50, message = "{oficina.nombre.length}")
    private String nombre;

    @NotEmpty(message = "{oficina.ubicacion.notEmpty}")
    @NotNull(message = "{oficina.ubicacion.notNull}")
    @Size(min = 3, max = 100, message = "{oficina.ubicacion.length}")
    private String ubicacion;
}

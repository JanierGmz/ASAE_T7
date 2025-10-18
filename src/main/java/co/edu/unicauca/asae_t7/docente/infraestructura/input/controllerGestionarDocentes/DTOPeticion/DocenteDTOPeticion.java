package co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
public class DocenteDTOPeticion {

    @NotEmpty(message = "{docente.nombres.notEmpty}")
    @NotNull(message = "{docente.nombres.notNull}")
    @Size(min = 3, max = 50, message = "{docente.nombres.length}")
    private String nombres;

    @NotEmpty(message = "{docente.apellidos.notEmpty}")
    @NotNull(message = "{docente.apellidos.notNull}")
    @Size(min = 3, max = 50, message = "{docente.apellidos.length}")
    private String apellidos;

    @NotEmpty(message = "{docente.email.notEmpty}")
    @NotNull(message = "{docente.email.notNull}")
    @Email(message = "{docente.email.mask}")
    private String correo;

    private OficinaDTOPeticion objOficina;
}

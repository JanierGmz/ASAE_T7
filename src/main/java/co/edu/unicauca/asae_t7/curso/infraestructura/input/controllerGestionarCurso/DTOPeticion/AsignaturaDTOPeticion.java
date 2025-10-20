package co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.DTOPeticion;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaDTOPeticion {
    @NotEmpty(message = "{asignatura.nombre.notEmpty}")
    @NotNull(message = "{asignatura.nombre.notNull}")
    @Size(min = 3, max = 50, message = "{asignatura.nombre.length}")
    private String nombre;

    @NotEmpty(message = "{asignatura.codigo.notEmpty}")
    @NotNull(message = "{asignatura.codigo.notNull}")
    @Size(min = 3, max = 50, message = "{asignatura.codigo.length}")
    private String codigo;

    @NotEmpty(message = "{asignatura.cursos.notEmpty}")
    @NotNull(message = "{asignatura.cursos.notNull}")
    @Size(min = 1, message = "{asignatura.cursos.length}")
    private List<CursoDTOPeticion> cursos = new ArrayList<>();
}

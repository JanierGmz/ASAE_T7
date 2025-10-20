package co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.DTORespuesta;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaDTORespuesta {
    private Integer id;
    private String nombre;
    private String codigo;
    private List<CursoDTORespuesta> cursos = new ArrayList<>();
}

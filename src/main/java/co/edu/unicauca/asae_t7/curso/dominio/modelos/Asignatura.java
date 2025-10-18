package co.edu.unicauca.asae_t7.curso.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {
    private Integer id;
    private String nombre;
    private String codigo;
    private List<Curso> cursos = new ArrayList<>();
}
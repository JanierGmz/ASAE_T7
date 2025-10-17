package co.edu.unicauca.asae_t7.docente.dominio.modelos;

import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Docente extends Persona{
    private Oficina objOficina;

    private List<Curso> cursos = new ArrayList<>();
}

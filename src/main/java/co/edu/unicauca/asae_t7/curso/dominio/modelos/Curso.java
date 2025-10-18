package co.edu.unicauca.asae_t7.curso.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {
    private Integer id;
    private String nombre;

    private Asignatura objAsignatura;

    /*@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "objCurso")
    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CursoDocente", joinColumns = @JoinColumn(name = "idCurso"), inverseJoinColumns = @JoinColumn(name = "idDocente"))
    private List<Docente> docentes = new ArrayList<>();*/

}
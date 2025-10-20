package co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTORespuesta {
    private Integer id;
    private String nombre;

    private AsignaturaDTORespuesta objAsignatura;

    /*@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "objCurso")
    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CursoDocente", joinColumns = @JoinColumn(name = "idCurso"), inverseJoinColumns = @JoinColumn(name = "idDocente"))
    private List<Docente> docentes = new ArrayList<>();*/
}

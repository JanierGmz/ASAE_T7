package co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.DTORespuesta;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTORespuesta {
    private Integer id;
    private String nombre;

    private Integer cantidadEstudiantesMatriculados;

    //private AsignaturaDTORespuesta objAsignatura;

    /*@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "objCurso")
    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CursoDocente", joinColumns = @JoinColumn(name = "idCurso"), inverseJoinColumns = @JoinColumn(name = "idDocente"))*/
    private List<DocenteDTORespuesta> docentes = new ArrayList<>();
}

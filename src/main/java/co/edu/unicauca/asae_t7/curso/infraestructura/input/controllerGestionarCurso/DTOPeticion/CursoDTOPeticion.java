package co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTOPeticion {
    @NotEmpty(message = "{curso.nombre.notEmpty}")
    @NotNull(message = "{curso.nombre.notNull}")
    @Size(min = 3, max = 50, message = "{curso.nombre.length}")
    private String nombre;

    @NotNull(message = "{curso.asignatura.notNull}")
    private AsignaturaDTOPeticion objAsignatura;

    /*@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "objCurso")
    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CursoDocente", joinColumns = @JoinColumn(name = "idCurso"), inverseJoinColumns = @JoinColumn(name = "idDocente"))*/
    private List<DocenteDTOPeticion> docentes = new ArrayList<>();
}

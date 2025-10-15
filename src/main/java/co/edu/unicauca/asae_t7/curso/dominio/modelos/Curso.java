package co.edu.unicauca.asae_t7.curso.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAsignatura", nullable = false)
    private Asignatura objAsignatura;

    /*@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "objCurso")
    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CursoDocente", joinColumns = @JoinColumn(name = "idCurso"), inverseJoinColumns = @JoinColumn(name = "idDocente"))
    private List<Docente> docentes = new ArrayList<>();*/

}
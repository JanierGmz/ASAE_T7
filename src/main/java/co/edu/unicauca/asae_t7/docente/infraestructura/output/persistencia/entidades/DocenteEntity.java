package co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.entidades.CursoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "idDocente")
@Table(name = "Docentes")
public class DocenteEntity extends PersonaEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "idOficina", nullable = true)
    private OficinaEntity objOficina;

    @ManyToMany(mappedBy = "docentes", fetch = FetchType.EAGER)
    private List<CursoEntity> cursos = new ArrayList<>();
}

package co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;
import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.entidades.CursoEntity;

public interface CursoRepositoryInt extends JpaRepository<CursoEntity, Integer> {
    // @Query("SELECT COUNT(c) FROM CursoEntity c WHERE c.codigo = ?1")
    // Integer existeCursoPorId(String codigoCurso);

    /**
     * Buscar cursos por nombre de asignatura
     * 
     * @param nombreAsignatura
     * @return
     */
    List<Curso> findByObjAsignaturaNombre(String nombreAsignatura);
}

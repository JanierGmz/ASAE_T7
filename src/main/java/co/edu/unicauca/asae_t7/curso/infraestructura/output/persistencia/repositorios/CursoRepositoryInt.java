package co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.entidades.CursoEntity;

public interface CursoRepositoryInt extends JpaRepository<CursoEntity, Integer> {
    @Query("SELECT COUNT(c) FROM CursoEntity c WHERE c.codigo = ?1")
    Integer existeCursoPorCodigo(String codigoCurso);
}

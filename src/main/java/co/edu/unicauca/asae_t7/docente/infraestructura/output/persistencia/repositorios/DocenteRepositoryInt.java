package co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepositoryInt extends JpaRepository<DocenteEntity, Integer> {

}

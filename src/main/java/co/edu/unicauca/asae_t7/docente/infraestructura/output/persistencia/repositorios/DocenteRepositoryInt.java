package co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocenteRepositoryInt extends JpaRepository<DocenteEntity, Integer> {

    @Query("SELECT COUNT(d) FROM DocenteEntity d WHERE d.correo = ?1")
    Integer existeDocentePorCorreo(String correoDocente);

}

package co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;

public interface EspacioFisicoRepositoryInt extends JpaRepository<EspacioFisicoEntity, Integer> {
    
    /**
     * Buscar espacios físicos por nombre (inicia con, case insensitive) y capacidad
     * (mayor o igual), ordenados por nombre ascendente
     * 
     * @param nombre
     * @param capacidad
     * @return
     */
    List<EspacioFisicoEntity> findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(String nombre,
            Integer capacidad);

    /**
     * Actualizar el estado de un espacio físico por su ID
     * 
     * @param id
     * @param estado
     * @return
     */
    @Modifying
    @Query("UPDATE EspacioFisicoEntity e SET e.estado = :estado WHERE e.id = :id")
    int actualizarEstadoPorId(Integer id, Boolean estado);

    /**
     * Verificar la existencia de un espacio físico por su ID
     * 
     * @param id
     * @return
     */
    boolean existsById(Integer id);

}

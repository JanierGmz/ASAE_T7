package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.output.persistencia.repositorios;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

public interface FranjaHorariaRepositoryInt extends JpaRepository<FranjaHorariaEntity, Integer> {

	/**
	 * Buscar franjas horarias por ID de curso
	 * 
	 * @param idCurso
	 * @return
	 */
	List<FranjaHorariaEntity> findByObjCursoId(Integer idCurso);

	/**
	 * Verificar si existe ocupación en un espacio físico para un día y rango
	 * horario específico
	 * 
	 * @param dia
	 * @param horaInicio
	 * @param horaFin
	 * @param idEspacioFisico
	 * @return
	 */
	@Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM FranjaHorariaEntity f JOIN f.objEspacioFisico e WHERE e.id = :idEspacioFisico AND f.dia = :dia AND ((:horaInicio < f.horaFin AND :horaFin > f.horaInicio))")
	boolean existeOcupacionEnHorario(
			@Param("dia") String dia,
			@Param("horaInicio") LocalTime horaInicio,
			@Param("horaFin") LocalTime horaFin,
			@Param("idEspacioFisico") Integer idEspacioFisico);

	/**
	 * Verificar si un docente está ocupado en un horario específico
	 * 
	 * @param dia
	 * @param horaInicio
	 * @param horaFin
	 * @param idDocente
	 * @return
	 */
	@Query(value = "SELECT CASE WHEN COUNT(fh.id) > 0 THEN 1 ELSE 0 END FROM FranjasHorarias fh " +
			"JOIN Cursos c ON fh.idCurso = c.id " +
			"JOIN CursoDocente cd ON c.id = cd.idCurso " +
			"WHERE cd.idDocente = :idDocente AND fh.dia = :dia " +
			"AND (:horaInicio < fh.horaFin AND :horaFin > fh.horaInicio)", nativeQuery = true)
	Integer docenteOcupadoEnHorario(
			@Param("dia") String dia,
			@Param("horaInicio") LocalTime horaInicio,
			@Param("horaFin") LocalTime horaFin,
			@Param("idDocente") Integer idDocente);

	/**
	 * Buscar franjas horarias junto con su espacio físico y curso por ID de curso
	 * 
	 * @param idCurso
	 * @return
	 */
	@Query("SELECT f FROM FranjaHorariaEntity f JOIN FETCH f.objCurso c JOIN FETCH f.objEspacioFisico e WHERE c.id = :idCurso")
	List<FranjaHorariaEntity> findFranjasYEspacioPorCursoId(@Param("idCurso") Integer idCurso);

	/**
	 * Eliminar franjas horarias por ID de curso
	 * 
	 * @param idCurso
	 * @return
	 */
	@Modifying
	@Query(value = "DELETE FROM FranjaHorariaEntity f WHERE f.objCurso.id = :idCurso")
	Integer deleteFranjasByCursoId(@Param("idCurso") Integer idCurso);

	/**
	 * Buscar franjas horarias por ID de curso con espacios físicos y datos de docentes
	 * 
	 * @param idCurso
	 * @return
	 */
	@Query("SELECT f FROM FranjaHorariaEntity f " +
			"JOIN FETCH f.objEspacioFisico e " +
			"JOIN f.objCurso c " +
			"JOIN c.docentes d " +
			"WHERE c.id = :idCurso")
	List<FranjaHorariaEntity> findFranjasHorariasConDetallesPorCursoId(@Param("idCurso") Integer idCurso);
}

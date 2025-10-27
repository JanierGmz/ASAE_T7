package co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output;

import java.time.LocalTime;
import java.util.List;

import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaHorariaGatewayIntPort {

    public FranjaHoraria guardar(FranjaHoraria objFranjaHoraria);

    public boolean espacioOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Integer idEspacioFisico);

    public Integer docenteOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Integer idDocente);

    public boolean existeEspacioFisico(Integer idEspacioFisico);

    public boolean existeDocente(Integer idDocente);

    public boolean existeCurso(Integer idCurso);

    public List<Integer> obtenerDocenteIdsPorCurso(Integer idCurso);

    public List<FranjaHoraria> findByObjCursoId(Integer idCurso);

    public List<FranjaHoraria> buscarFranjasHorariasPorCursoId(Integer idCurso);

    public boolean eliminarFranjasHorariasPorCursoId(Integer idCurso);

    public List<FranjaHoraria> buscarFranjasSinCursoPorCursoId(Integer idCurso);


    public List<FranjaHoraria> buscarFranjasHorariasPorDocenteId(Integer idDocente);

}

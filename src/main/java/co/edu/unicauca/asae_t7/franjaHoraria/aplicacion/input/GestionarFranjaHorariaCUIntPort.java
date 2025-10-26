package co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaHorariaCUIntPort {

    public FranjaHoraria crear(FranjaHoraria objFranjaHoraria);
    
    public List<FranjaHoraria> buscarFranjasHorariasPorCursoId(Integer idCurso);

    public boolean eliminarFranjasHorariasPorCursoId(Integer idCurso);

    public List<FranjaHoraria> buscarFranjasHorariasPorDocenteId(Integer idDocente);
}

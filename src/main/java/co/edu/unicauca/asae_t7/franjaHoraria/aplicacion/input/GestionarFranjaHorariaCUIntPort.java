package co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.input;

import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;
import java.util.List;

public interface GestionarFranjaHorariaCUIntPort {

    public FranjaHoraria crear(FranjaHoraria objFranjaHoraria);
    List<FranjaHoraria> obtenerPorCursoId(Integer idCurso);
    
}

package co.edu.unicauca.asae_t7.espacioFisico.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae_t7.espacioFisico.dominio.modelos.EspacioFisico;

public interface GestionarEspacioFisicoCUIntPort {

     public List<EspacioFisico> listarPorNombreYCapacidadEspaciosFisicos(String nombre, Integer capacidad);
     public boolean actualizarEstadoPorId(Integer id, Boolean estado);
}

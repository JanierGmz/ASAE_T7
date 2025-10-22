package co.edu.unicauca.asae_t7.espacioFisico.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae_t7.espacioFisico.dominio.modelos.EspacioFisico;

public interface GestionarEspacioFisicoGatewayIntPort {
    public List<EspacioFisico> listarPorNombreYCapacidadEspaciosFisicos( String nombre,
            Integer capacidad);

}

package co.edu.unicauca.asae_t7.espacioFisico.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;
import co.edu.unicauca.asae_t7.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae_t7.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae_t7.espacioFisico.dominio.modelos.EspacioFisico;

public class GestionarEspacioFisicoCUAdapter implements GestionarEspacioFisicoCUIntPort {

    private final GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway;
    private final FormateadorResultadosIntPort objEspacioFisicoFormateadorResultados;

    public GestionarEspacioFisicoCUAdapter(GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway,
            FormateadorResultadosIntPort objEspacioFisicoFormateadorResultados) {
        this.objGestionarEspacioFisicoGateway = objGestionarEspacioFisicoGateway;
        this.objEspacioFisicoFormateadorResultados = objEspacioFisicoFormateadorResultados;
    }
    @Override
    public List<EspacioFisico> listarPorNombreYCapacidadEspaciosFisicos(String nombre, Integer capacidad){ 
        List<EspacioFisico> listaEspacios = objGestionarEspacioFisicoGateway.listarPorNombreYCapacidadEspaciosFisicos(nombre, capacidad);
        return listaEspacios;
    }
}

 
    



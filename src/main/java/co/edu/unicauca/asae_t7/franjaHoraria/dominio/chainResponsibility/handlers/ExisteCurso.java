package co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.handlers;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.chain.SolicitudFranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;

public class ExisteCurso extends SolicitudFranjaHoraria {

    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;

    private final FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados;

    public ExisteCurso(GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        this.objGestionarFranjaHorariaGateway = objGestionarFranjaHorariaGateway;
        this.objFranjaHorariaFormateadorResultados = objFranjaHorariaFormateadorResultados;
    }

    @Override
    public boolean procesarSolicitud(FranjaHoraria solicitudFranjaHoraria) {
        if (solicitudFranjaHoraria.getIdCurso() == null) {
            System.out.println("El ID del curso es nulo.");
            this.objFranjaHorariaFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "Error: El ID del curso es requerido.");
            return false;
        }
        
        boolean existe = objGestionarFranjaHorariaGateway.existeCurso(solicitudFranjaHoraria.getIdCurso());
        if (!existe) {
            System.out.println("El curso no existe.");
            this.objFranjaHorariaFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "Error: El curso no existe.");
            return false;
        }
        if (this.getSiguiente() != null) {
            return this.getSiguiente().procesarSolicitud(solicitudFranjaHoraria);
        }
        return true;
    }

}

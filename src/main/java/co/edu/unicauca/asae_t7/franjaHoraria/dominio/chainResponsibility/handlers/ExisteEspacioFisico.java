package co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.handlers;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.chain.SolicitudFranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;

public class ExisteEspacioFisico extends SolicitudFranjaHoraria {

    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;

    private final FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados;

    public ExisteEspacioFisico(GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        this.objGestionarFranjaHorariaGateway = objGestionarFranjaHorariaGateway;
        this.objFranjaHorariaFormateadorResultados = objFranjaHorariaFormateadorResultados;
    }

    @Override
    public boolean procesarSolicitud(FranjaHoraria solicitudFranjaHoraria) {
        if (solicitudFranjaHoraria.getIdEspacioFisico() == null) {
            this.objFranjaHorariaFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "El ID del espacio físico es requerido.");
            return false;
        }

        boolean existe = objGestionarFranjaHorariaGateway
                .existeEspacioFisico(solicitudFranjaHoraria.getIdEspacioFisico());
        if (!existe) {
            this.objFranjaHorariaFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "El espacio físico no existe.");
            return false;
        }
        if (this.getSiguiente() != null) {
            return this.getSiguiente().procesarSolicitud(solicitudFranjaHoraria);
        }
        return true;
    }

}

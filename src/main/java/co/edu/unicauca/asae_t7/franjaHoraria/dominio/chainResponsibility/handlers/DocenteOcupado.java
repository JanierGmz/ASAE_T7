package co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.handlers;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.chain.SolicitudFranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;

public class DocenteOcupado extends SolicitudFranjaHoraria {

    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;

    private final FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados;

    public DocenteOcupado(GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        this.objGestionarFranjaHorariaGateway = objGestionarFranjaHorariaGateway;
        this.objFranjaHorariaFormateadorResultados = objFranjaHorariaFormateadorResultados;
    }

    @Override
    public boolean procesarSolicitud(FranjaHoraria solicitudFranjaHoraria) {

        var docenteIds = objGestionarFranjaHorariaGateway
                .obtenerDocenteIdsPorCurso(solicitudFranjaHoraria.getIdCurso());
        if (docenteIds == null || docenteIds.isEmpty()) {
            this.objFranjaHorariaFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "El curso no tiene docentes asociados.");
            return false;
        }

        for (Integer idDocente : docenteIds) {
            Integer ocupado = objGestionarFranjaHorariaGateway.docenteOcupado(
                    solicitudFranjaHoraria.getDia(),
                    solicitudFranjaHoraria.getHoraInicio(),
                    solicitudFranjaHoraria.getHoraFin(),
                    idDocente);

            if (ocupado == 1) {
                this.objFranjaHorariaFormateadorResultados
                        .retornarRespuestaErrorReglaDeNegocio(
                                "Algún docente del curso está ocupado en el horario solicitado.");
                return false;
            }
        }

        if (this.getSiguiente() != null) {
            return this.getSiguiente().procesarSolicitud(solicitudFranjaHoraria);
        }

        return true;
    }

}

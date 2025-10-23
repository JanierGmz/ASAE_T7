package co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.handlers;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.chain.SolicitudFranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;

public class ExisteDocente extends SolicitudFranjaHoraria {

    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;

    private final FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados;

    public ExisteDocente(GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        this.objGestionarFranjaHorariaGateway = objGestionarFranjaHorariaGateway;
        this.objFranjaHorariaFormateadorResultados = objFranjaHorariaFormateadorResultados;
    }

    @Override
    public boolean procesarSolicitud(FranjaHoraria solicitudFranjaHoraria) {

        var docenteIds = objGestionarFranjaHorariaGateway
                .obtenerDocenteIdsPorCurso(solicitudFranjaHoraria.getIdCurso());
        if (docenteIds == null || docenteIds.isEmpty()) {
            System.out.println("El curso no tiene docentes asociados.");
            this.objFranjaHorariaFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "Error: El curso no tiene docentes asociados.");
            return false;
        }

        for (Integer idDocente : docenteIds) {
            boolean existe = objGestionarFranjaHorariaGateway.existeDocente(idDocente);
            if (!existe) {
                System.out.println("Algún docente asociado al curso no existe. ID=" + idDocente);
                this.objFranjaHorariaFormateadorResultados
                        .retornarRespuestaErrorReglaDeNegocio(
                                "Error: Docente asociado al curso no existe.");
                return false;
            }
        }

        if (this.getSiguiente() != null) {
            return this.getSiguiente().procesarSolicitud(solicitudFranjaHoraria);
        }
        return true;
    }

}

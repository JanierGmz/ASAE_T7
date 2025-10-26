package co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.handlers;

import java.util.List;

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

        List<Integer> docenteIds = objGestionarFranjaHorariaGateway
                .obtenerDocenteIdsPorCurso(solicitudFranjaHoraria.getIdCurso());
        if (docenteIds == null || docenteIds.isEmpty()) {
            this.objFranjaHorariaFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "El curso no tiene docentes asociados.");
            return false;
        }

        for (Integer idDocente : docenteIds) {
            boolean existe = objGestionarFranjaHorariaGateway.existeDocente(idDocente);
            //Caso no posible, pero por si acaso
            if (!existe) {
                this.objFranjaHorariaFormateadorResultados
                        .retornarRespuestaErrorEntidadNoExiste(
                                "Docente asociado al curso no existe.");
                return false;
            }
        }

        if (this.getSiguiente() != null) {
            return this.getSiguiente().procesarSolicitud(solicitudFranjaHoraria);
        }
        return true;
    }

}

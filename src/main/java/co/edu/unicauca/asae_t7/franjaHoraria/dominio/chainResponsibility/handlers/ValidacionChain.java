package co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.handlers;

import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;
import jakarta.annotation.PostConstruct;

public class ValidacionChain {

    private final ExisteDocente existeDocenteHandler;
    private final ExisteCurso existeCursoHandler;
    private final ExisteEspacioFisico existeEspacioFisicoHandler;
    private final DocenteOcupado docenteOcupadoHandler;
    private final EspacioFisicoOcupado espacioFisicoOcupadoHandler;

    public ValidacionChain(
            ExisteDocente existeDocenteHandler,
            ExisteCurso existeCursoHandler,
            ExisteEspacioFisico existeEspacioFisicoHandler,
            DocenteOcupado docenteOcupadoHandler,
            EspacioFisicoOcupado espacioFisicoOcupadoHandler) {
        this.existeDocenteHandler = existeDocenteHandler;
        this.existeCursoHandler = existeCursoHandler;
        this.existeEspacioFisicoHandler = existeEspacioFisicoHandler;
        this.docenteOcupadoHandler = docenteOcupadoHandler;
        this.espacioFisicoOcupadoHandler = espacioFisicoOcupadoHandler;
    }

    @PostConstruct
    public void configurarCadena() {
        // Primero validar existencia de curso y espacio físico
        existeCursoHandler.setSiguiente(existeEspacioFisicoHandler);
        // Luego validar docentes del curso (existencia y ocupación)
        existeEspacioFisicoHandler.setSiguiente(existeDocenteHandler);
        existeDocenteHandler.setSiguiente(docenteOcupadoHandler);
        // Finalmente validar ocupación del espacio físico
        docenteOcupadoHandler.setSiguiente(espacioFisicoOcupadoHandler);
    }

    public boolean validar(FranjaHoraria objFranjaHoraria) {
        return existeDocenteHandler.procesarSolicitud(objFranjaHoraria);
    }

}

package co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.chain;

import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;

public abstract class SolicitudFranjaHoraria {
    
    private SolicitudFranjaHoraria siguiente;

    public abstract boolean procesarSolicitud(FranjaHoraria solicitudFranjaHoraria);


    public void setSiguiente(SolicitudFranjaHoraria siguiente) {
        this.siguiente = siguiente;
    }

    public SolicitudFranjaHoraria getSiguiente() {
        return this.siguiente;
    }
}

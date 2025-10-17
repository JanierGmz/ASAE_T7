package co.edu.unicauca.asae_t7.docente.aplicacion.output;

import co.edu.unicauca.asae_t7.docente.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {

    public boolean existeDocentePorId(Integer idDocente);

    public boolean existeDocentePorCorreo(String correoDocente);

    public Docente guardar(Docente objDocente);
}

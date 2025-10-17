package co.edu.unicauca.asae_t7.docente.infraestructura.output.formateador;

import co.edu.unicauca.asae_t7.docente.aplicacion.output.DocenteFormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.docente.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae_t7.docente.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import org.springframework.stereotype.Service;

@Service
public class DocenteFormateadorResultadosImplAdapter implements DocenteFormateadorResultadosIntPort{
    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }
}

package co.edu.unicauca.asae_t7.common.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos.EntidadYaExisteException;
import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos.ReglaNegocioExcepcion;
import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos.EntidadNoExisteException;

@Service
public class FormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {

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

    @Override
    public void retornarRespuestaErrorEntidadNoExiste(String mensaje) {
        EntidadNoExisteException objException = new EntidadNoExisteException(mensaje);
        throw objException;
    }

}

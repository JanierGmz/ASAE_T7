package co.edu.unicauca.asae_t7.curso.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos.EntidadYaExisteException;
import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos.ReglaNegocioExcepcion;
import co.edu.unicauca.asae_t7.curso.aplicacion.output.CursoFormateadorResultadosIntPort;

@Service
public class CursoFormateadorResultadosImplAdapter implements CursoFormateadorResultadosIntPort {
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

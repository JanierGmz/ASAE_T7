package co.edu.unicauca.asae_t7.common.aplicacion.output;

public interface FormateadorResultadosIntPort {

    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
    public void retornarRespuestaErrorEntidadNoExiste(String mensaje);
}

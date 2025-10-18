package co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos;

import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.error.CodigoError;

public class ReglaNegocioExcepcion extends GestionFranjasRuntimeException {

    private static final String FORMATO_EXCEPCION = "%s - Violación a regla de negocio: %s";

    private final String reglaNegocio;

    public ReglaNegocioExcepcion(final String reglaNegocio) {
        super(CodigoError.VIOLACION_REGLA_DE_NEGOCIO);
        this.reglaNegocio = reglaNegocio;
    }

    @Override
    public String formatException() {
        return String.format(FORMATO_EXCEPCION, codigoError.getCodigo(), reglaNegocio);
    }
}

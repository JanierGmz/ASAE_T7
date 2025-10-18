package co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos;

import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.error.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionFranjasRuntimeException extends RuntimeException {

    protected CodigoError codigoError;

    public abstract String formatException();
}

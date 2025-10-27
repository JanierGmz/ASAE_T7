package co.edu.unicauca.asae_t7.common.infraestructura.excepciones;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.error.CodigoError;
import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.error.Error;
import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.error.ErrorUtils;
import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos.EntidadNoExisteException;
import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos.EntidadYaExisteException;
import co.edu.unicauca.asae_t7.common.infraestructura.excepciones.tipos.ReglaNegocioExcepcion;
import jakarta.validation.ConstraintViolationException;
import java.util.Locale;

@ControllerAdvice
public class RestApiExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final Exception ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ERROR_GENERICO.getCodigo(),
                                                CodigoError.ERROR_GENERICO.getLlaveMensaje(),
                                                HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(EntidadYaExisteException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final EntidadYaExisteException ex) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ENTIDAD_YA_EXISTE.getCodigo(),
                                                String.format("%s, %s", CodigoError.ENTIDAD_YA_EXISTE.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.NOT_ACCEPTABLE.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
        }

        @ExceptionHandler(ReglaNegocioExcepcion.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final ReglaNegocioExcepcion ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(), ex.formatException(),
                                                HttpStatus.BAD_REQUEST.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(EntidadNoExisteException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final EntidadNoExisteException ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ENTIDAD_NO_ENCONTRADA.getCodigo(),
                                                String.format("%s, %s",
                                                                CodigoError.ENTIDAD_NO_ENCONTRADA.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.NOT_FOUND.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Error> handleValidationExceptions(final HttpServletRequest req,
                        final MethodArgumentNotValidException ex, final Locale locale) {
                boolean hayErrorCapacidad = ex.getBindingResult().getAllErrors().stream()
                                .anyMatch(error -> "CapacidadEspacioFisico".equals(error.getCode()));

                if (hayErrorCapacidad) {
                        final String detalle = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
                        final Error error = ErrorUtils
                                        .crearError(CodigoError.CAPACIDAD_INSUFICIENTE.getCodigo(),
                                                        String.format("%s, %s",
                                                                        CodigoError.CAPACIDAD_INSUFICIENTE
                                                                                        .getLlaveMensaje(),
                                                                        detalle),
                                                        HttpStatus.BAD_REQUEST.value())
                                        .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
                } else {
                        final String detalle = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
                        final Error error = ErrorUtils
                                        .crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(),
                                                        String.format("%s, %s",
                                                                        CodigoError.VIOLACION_REGLA_DE_NEGOCIO
                                                                                        .getLlaveMensaje(),
                                                                        detalle),
                                                        HttpStatus.BAD_REQUEST.value())
                                        .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
                }
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(ConstraintViolationException.class)
        ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
                return new ResponseEntity<>(e.getMessage(),
                                HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(HandlerMethodValidationException.class)
        public ResponseEntity<Error> handleHandlerMethodValidationException(
                        final HttpServletRequest req,
                        final HandlerMethodValidationException ex) {

                String detalle = ex.getAllValidationResults().get(0).getResolvableErrors().get(0).getDefaultMessage();

                final Error error = ErrorUtils
                                .crearError(
                                                CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(),
                                                String.format("%s, %s",
                                                                CodigoError.VIOLACION_REGLA_DE_NEGOCIO
                                                                                .getLlaveMensaje(),
                                                                detalle),
                                                HttpStatus.BAD_REQUEST.value())
                                .setUrl(req.getRequestURL().toString())
                                .setMetodo(req.getMethod());

                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
}

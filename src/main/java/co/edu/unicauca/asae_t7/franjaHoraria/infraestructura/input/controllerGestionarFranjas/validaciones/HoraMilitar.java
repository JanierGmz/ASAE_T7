package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones;

import jakarta.validation.Payload;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = HoraMilitarValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface HoraMilitar {
    String message() default "{franjaHoraria.hora.horaMilitarInt}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

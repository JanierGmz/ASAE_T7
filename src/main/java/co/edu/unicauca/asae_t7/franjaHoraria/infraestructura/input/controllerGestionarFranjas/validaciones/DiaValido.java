package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones;


import jakarta.validation.Payload;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = DiaValidoValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DiaValido {
    String message() default "{franjaHoraria.dia.notValid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HorarioValidoValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HorarioValido {
    
    String message() default "{franjaHoraria.horarioValido.horaInicioPosterior}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}


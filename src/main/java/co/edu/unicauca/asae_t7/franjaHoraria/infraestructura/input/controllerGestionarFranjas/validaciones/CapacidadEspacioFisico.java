package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * Anotación personalizada para validar que la capacidad del espacio físico
 * sea suficiente para la cantidad de estudiantes matriculados en el curso.
 */
@Documented
@Constraint(validatedBy = CapacidadEspacioFisicoValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CapacidadEspacioFisico {
    
    String message() default "{franjaHoraria.capacidadEspacioFisico.insuficiente}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}

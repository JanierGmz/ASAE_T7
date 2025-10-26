package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones;

import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion.FranjaHorariaDTOPeticion;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validador personalizado para verificar que la hora de inicio
 * no sea posterior a la hora de fin en una franja horaria.
 */
public class HorarioValidoValidator implements ConstraintValidator<HorarioValido, FranjaHorariaDTOPeticion> {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public void initialize(HorarioValido constraintAnnotation) {

    }

    @Override
    public boolean isValid(FranjaHorariaDTOPeticion franjaHoraria, ConstraintValidatorContext context) {
        if (franjaHoraria == null || franjaHoraria.getHoraInicio() == null || franjaHoraria.getHoraFin() == null) {
            return true;
        }

        try {
            LocalTime horaInicio = LocalTime.parse(franjaHoraria.getHoraInicio(), TIME_FORMATTER);
            LocalTime horaFin = LocalTime.parse(franjaHoraria.getHoraFin(), TIME_FORMATTER);

            return !horaInicio.isAfter(horaFin);

        } catch (DateTimeParseException e) {
            return true;
        }
    }
}

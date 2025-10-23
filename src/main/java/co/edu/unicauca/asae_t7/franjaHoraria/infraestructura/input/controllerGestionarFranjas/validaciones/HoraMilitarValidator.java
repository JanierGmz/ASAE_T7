package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class HoraMilitarValidator implements ConstraintValidator<HoraMilitar, String> {
    private static final Pattern PATRON = Pattern.compile("^(?:[01]\\d|2[0-3]):[0-5]\\d$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return PATRON.matcher(value).matches();
    }
}


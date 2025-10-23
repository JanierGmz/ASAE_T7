package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.text.Normalizer;
import java.util.Set;

public class DiaValidoValidator implements ConstraintValidator<DiaValido, String> {

    private static final Set<String> DIAS_VALIDOS = Set.of(
        "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        String normalizado = Normalizer.normalize(value, Normalizer.Form.NFD)
                                       .replaceAll("\\p{M}", "")
                                       .toUpperCase();

        return DIAS_VALIDOS.contains(normalizado);
    }
}

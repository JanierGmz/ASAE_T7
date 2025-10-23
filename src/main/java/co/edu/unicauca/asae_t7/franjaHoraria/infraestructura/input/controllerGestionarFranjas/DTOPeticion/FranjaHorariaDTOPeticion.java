package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion;

import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones.DiaValido;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones.HoraMilitar;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaDTOPeticion {

    @NotBlank(message = "{franjaHoraria.dia.notBlank}")
    @DiaValido
    private String dia;

    @NotBlank(message = "{franjaHoraria.horaInicio.notBlank}")
    @HoraMilitar
    private String horaInicio;

    @NotBlank(message = "{franjaHoraria.horaFin.notBlank}")
    @HoraMilitar
    private String horaFin;

    @NotNull(message = "{franjaHoraria.espacioFisico.notNull}")
    @Positive(message = "{franjaHoraria.espacioFisico.positive}")
    private Integer idEspacioFisico;

    @NotNull(message = "{franjaHoraria.curso.notNull}")
    @Positive(message = "{franjaHoraria.curso.positive}")
    private Integer idCurso;
}

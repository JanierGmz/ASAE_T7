package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FranjaHorariaDTOPeticion {
    private Integer id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}

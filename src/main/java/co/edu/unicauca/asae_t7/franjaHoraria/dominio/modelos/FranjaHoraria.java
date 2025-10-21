package co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos;

import java.time.LocalTime;

import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FranjaHoraria {
    private Integer id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    private EspacioFisico objEspacioFisico;
    private Curso objCurso;
}

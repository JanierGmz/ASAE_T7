package co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos;

import java.time.LocalTime;

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
    

    private Integer idEspacioFisico;
    private Integer idCurso;
    //private EspacioFisico objEspacioFisico;
    //private Curso objCurso;
}

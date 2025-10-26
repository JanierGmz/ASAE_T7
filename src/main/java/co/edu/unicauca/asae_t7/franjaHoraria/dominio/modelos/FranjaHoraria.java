package co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos;

import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import co.edu.unicauca.asae_t7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;
import co.edu.unicauca.asae_t7.docente.dominio.modelos.Docente;

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
    
    private EspacioFisico objEspacioFisico;
    private Curso objCurso;
    private List<Docente> listaDocentes;
}

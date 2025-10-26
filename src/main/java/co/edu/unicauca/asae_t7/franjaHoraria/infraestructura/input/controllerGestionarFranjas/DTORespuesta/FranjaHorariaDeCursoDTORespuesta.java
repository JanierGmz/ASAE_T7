package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.DTORespuesta.CursoDTORespuesta;
import co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.DTORespuesta.EspacioFisicoDTORespuesta;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FranjaHorariaDeCursoDTORespuesta {
    private Integer id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    private EspacioFisicoDTORespuesta objEspacioFisico;
    private CursoDTORespuesta objCurso;
    private List<DocenteDTORespuesta> listaDocentes;
}
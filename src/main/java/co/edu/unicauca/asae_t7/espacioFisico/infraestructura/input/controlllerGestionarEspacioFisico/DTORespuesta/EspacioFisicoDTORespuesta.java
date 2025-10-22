package co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisicoDTORespuesta {
    private Integer id;
    private String nombre;
    private int capacidad;
    private Boolean estado;
    private String ubicacion;

}

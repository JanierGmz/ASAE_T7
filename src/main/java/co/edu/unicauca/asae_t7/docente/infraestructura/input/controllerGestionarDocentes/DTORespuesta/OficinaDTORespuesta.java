package co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OficinaDTORespuesta {

    private Integer id;
    private String nombre;
    private String ubicacion;
}

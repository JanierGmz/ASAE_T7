package co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTORespuesta {

    private Integer id;
    private String nombres;
    private String apellidos;
    private String correo;

    private OficinaDTORespuesta objOficina;
}

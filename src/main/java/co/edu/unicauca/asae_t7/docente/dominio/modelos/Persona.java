package co.edu.unicauca.asae_t7.docente.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private Integer id;
    private String nombres;
    private String apellidos;
    private String correo;
}

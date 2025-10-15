package co.edu.unicauca.asae_t7.docente.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oficina {
    private Integer id;
    private String nombre;
    private String ubicacion;

    private List<Docente> docentes = new ArrayList<>();
}

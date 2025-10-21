package co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspacioFisico {
    private Integer id;
    private String nombre;
    private int capacidad;
    private Boolean estado;
    private String ubicacion;

    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();
}

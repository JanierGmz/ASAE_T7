package co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspacioFisicoDTOPeticion {
    private Integer id;
    private String nombre;
    private int capacidad;
    private Boolean estado;
    private String ubicacion;

}

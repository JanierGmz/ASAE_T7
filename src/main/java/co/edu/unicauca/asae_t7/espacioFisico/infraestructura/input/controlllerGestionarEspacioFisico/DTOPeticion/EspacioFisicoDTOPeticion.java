package co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.DTOPeticion;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspacioFisicoDTOPeticion {
    @NotNull(message = "{espacioFisico.id.notNull}")
    @Positive(message = "{espacioFisico.id.positive}")
    private Integer id;
    @NotEmpty(message = "{espacioFisico.nombre.notEmpty}")
    @NotNull(message = "{espacioFisico.nombre.notNull}")
    @Size(min = 3, max = 50, message = "{espacioFisico.nombre.length}")
    private String nombre;
    @Positive(message = "{espacioFisico.capacidad.positive}")
    @NotNull(message = "{espacioFisico.capacidad.notNull}")
    @NotEmpty(message = "{espacioFisico.capacidad.notEmpty}")
    private int capacidad;
    @NotNull(message = "{espacioFisico.estado.notNull}")
    @NotEmpty(message = "{espacioFisico.estado.notEmpty}")
    private Boolean estado;
    @NotNull(message = "{espacioFisico.ubicacion.notNull}")
    @NotEmpty(message = "{espacioFisico.ubicacion.notEmpty}")
    @Size(min = 3, max = 100, message = "{espacioFisico.ubicacion.length}")
    private String ubicacion;

}

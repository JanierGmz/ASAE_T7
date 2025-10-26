package co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "EspaciosFisicos")
public class EspacioFisicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false, unique = true)
    private String nombre;

    private int capacidad;

    private Boolean estado;

    @Column(length = 100)
    private String ubicacion;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "objEspacioFisico")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objEspacioFisico")
    private List<FranjaHorariaEntity> franjasHorarias = new ArrayList<>();
}

package co.edu.unicauca.asae_t7.curso.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae_t7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {
    private Integer id;
    private String nombre;
    private Asignatura objAsignatura;
    
    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();
    private List<Docente> docentes = new ArrayList<>();

}
package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.validaciones;

import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion.FranjaHorariaDTOPeticion;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Validador personalizado para verificar que la capacidad del espacio físico
 * sea suficiente para la cantidad de estudiantes matriculados en el curso.
 */
@Component
public class CapacidadEspacioFisicoValidator implements ConstraintValidator<CapacidadEspacioFisico, FranjaHorariaDTOPeticion> {

    @Autowired
    private CursoRepositoryInt cursoRepository;

    @Autowired
    private EspacioFisicoRepositoryInt espacioFisicoRepository;

    @Override
    public void initialize(CapacidadEspacioFisico constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(FranjaHorariaDTOPeticion franjaHoraria, ConstraintValidatorContext context) {
        if (franjaHoraria == null || franjaHoraria.getIdCurso() == null || franjaHoraria.getIdEspacioFisico() == null) {
            return true;
        }

        try {
            // Obtener el curso por ID
            Optional<CursoEntity> cursoEntity = cursoRepository.findById(franjaHoraria.getIdCurso());
            if (cursoEntity.isEmpty()) {
                return true; 
            }

            // Obtener el espacio físico por ID
            Optional<EspacioFisicoEntity> espacioFisicoEntity = espacioFisicoRepository.findById(franjaHoraria.getIdEspacioFisico());
            if (espacioFisicoEntity.isEmpty()) {
                return true; 
            }

            // Verificar si la capacidad del espacio físico es suficiente
            Integer cantidadEstudiantes = cursoEntity.get().getCantidadEstudiantesMatriculados();
            Integer capacidadEspacio = espacioFisicoEntity.get().getCapacidad();

            return capacidadEspacio >= cantidadEstudiantes;

        } catch (Exception e) {
            return true;
        }
    }
}

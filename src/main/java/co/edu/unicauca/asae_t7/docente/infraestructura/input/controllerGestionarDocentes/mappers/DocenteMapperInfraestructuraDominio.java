package co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.mappers;

import co.edu.unicauca.asae_t7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae_t7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {

    Docente docentePeticionToDocente(DocenteDTOPeticion docentePeticion);

    DocenteDTORespuesta docenteToDocenteRespuesta(Docente docente);

    List<DocenteDTORespuesta> docentesToDocenteRespuestaList(List<Docente> docentes);
}

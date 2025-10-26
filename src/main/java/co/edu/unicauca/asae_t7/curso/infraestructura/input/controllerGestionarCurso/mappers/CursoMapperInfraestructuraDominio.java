package co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;
import co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.DTOPeticion.CursoDTOPeticion;
import co.edu.unicauca.asae_t7.curso.infraestructura.input.controllerGestionarCurso.DTORespuesta.CursoDTORespuesta;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoMapperInfraestructuraDominio {
    Curso mappearDePeticionACurso(CursoDTOPeticion peticion);

    CursoDTORespuesta mappearDeCursoACursoRespuesta(Curso objCurso);

    List<CursoDTORespuesta> mappearDeCursosARespuesta(List<Curso> cursos);
}

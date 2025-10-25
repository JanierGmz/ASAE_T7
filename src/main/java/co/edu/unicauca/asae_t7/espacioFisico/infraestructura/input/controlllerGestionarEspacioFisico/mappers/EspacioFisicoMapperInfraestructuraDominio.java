package co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae_t7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.DTOPeticion.EspacioFisicoDTOPeticion;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.input.controlllerGestionarEspacioFisico.DTORespuesta.EspacioFisicoDTORespuesta;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EspacioFisicoMapperInfraestructuraDominio {

    EspacioFisico mappearDePeticionAEspacioFisico(EspacioFisicoDTOPeticion peticion);

    EspacioFisicoDTORespuesta mappearDeEspacioFisicoARespuesta(EspacioFisico objEspacioFisico);

    List<EspacioFisicoDTORespuesta> mappearDeEspaciosFisicosARespuesta(List<EspacioFisico> espaciosFisicos);
}

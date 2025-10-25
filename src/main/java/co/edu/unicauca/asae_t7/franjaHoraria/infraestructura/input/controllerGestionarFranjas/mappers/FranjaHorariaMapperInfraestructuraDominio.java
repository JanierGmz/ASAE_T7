package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaDTORespuesta;

@Mapper(componentModel = "spring")
public interface FranjaHorariaMapperInfraestructuraDominio {
    
    FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion peticion);

    FranjaHorariaDTORespuesta mappearDeFranjaHorariaARespuesta(FranjaHoraria objFranjaCreada);

    List<FranjaHorariaDTORespuesta> mappearDeProductosARespuesta(List<FranjaHoraria> franjaHorarias);
}

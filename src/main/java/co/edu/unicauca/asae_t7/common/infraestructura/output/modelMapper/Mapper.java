package co.edu.unicauca.asae_t7.common.infraestructura.output.modelMapper;

import co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae_t7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

@Configuration
public class Mapper {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();

        // Configuración para no cargar Cursos en Docentes
        TypeMap<DocenteEntity, Docente> mapa = objMapper.emptyTypeMap(DocenteEntity.class,
                Docente.class);
        mapa.addMappings(n -> n.skip(Docente::setCursos)).implicitMappings();

        // Configuración para no cargar Curso en FranjaHoraria
        TypeMap<FranjaHorariaEntity, FranjaHoraria> mapa2 = objMapper.emptyTypeMap(FranjaHorariaEntity.class,
                FranjaHoraria.class);
        mapa2.addMappings(n -> n.skip(FranjaHoraria::setObjCurso)).implicitMappings();
        return objMapper;
    }
}

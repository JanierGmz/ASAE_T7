package co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class DocenteMapper {

    @Bean
    public ModelMapper crearDocenteMapper() {
        return new ModelMapper();
    }
}

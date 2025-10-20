package co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.mappers;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@Configuration
public class CursoMapper {
    @Bean
    public ModelMapper crearCursoMapper() {
        return new ModelMapper();
    }
}

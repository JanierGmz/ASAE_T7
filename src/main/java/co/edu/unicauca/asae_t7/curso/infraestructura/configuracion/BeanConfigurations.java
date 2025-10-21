package co.edu.unicauca.asae_t7.curso.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae_t7.curso.dominio.casosDeUso.GestionarCursoCUAdapter;
import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.curso.aplicacion.output.GestionarCursoGatewayIntPort;


@Configuration
public class BeanConfigurations {
    @Bean
    public GestionarCursoCUAdapter crearGestionarCursoCUInt(
            GestionarCursoGatewayIntPort objGestionarCursoGateway,
            FormateadorResultadosIntPort objCursoFormateadorResultados) {
        GestionarCursoCUAdapter objGestionarCursoCU = new GestionarCursoCUAdapter(objGestionarCursoGateway,
                objCursoFormateadorResultados);
        return objGestionarCursoCU;
    }
}

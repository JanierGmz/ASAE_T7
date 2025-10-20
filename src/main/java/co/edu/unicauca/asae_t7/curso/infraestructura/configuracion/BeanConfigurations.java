package co.edu.unicauca.asae_t7.curso.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae_t7.curso.dominio.casosDeUso.GestionarCursoCUAdapter;
import co.edu.unicauca.asae_t7.curso.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae_t7.curso.aplicacion.output.CursoFormateadorResultadosIntPort;

@Configuration
public class BeanConfigurations {
    @Bean
    public GestionarCursoCUAdapter crearGestionarCursoCUInt(
            GestionarCursoGatewayIntPort objGestionarCursoGateway,
            CursoFormateadorResultadosIntPort objCursoFormateadorResultados) {
        GestionarCursoCUAdapter objGestionarCursoCU = new GestionarCursoCUAdapter(objGestionarCursoGateway,
                objCursoFormateadorResultados);
        return objGestionarCursoCU;
    }
}

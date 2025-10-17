package co.edu.unicauca.asae_t7.docente.infraestructura.configuracion;

import co.edu.unicauca.asae_t7.docente.aplicacion.output.DocenteFormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae_t7.docente.dominio.casosDeUso.GestionarDocenteCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
            GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
            DocenteFormateadorResultadosIntPort objDocenteFormateadorResultados) {
        GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objGestionarDocenteGateway,
                objDocenteFormateadorResultados);
        return objGestionarDocenteCU;
    }
}

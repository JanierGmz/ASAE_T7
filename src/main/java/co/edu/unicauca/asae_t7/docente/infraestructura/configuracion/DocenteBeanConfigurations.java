package co.edu.unicauca.asae_t7.docente.infraestructura.configuracion;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae_t7.docente.dominio.casosDeUso.GestionarDocenteCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocenteBeanConfigurations {

    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
            GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
            FormateadorResultadosIntPort objDocenteFormateadorResultados) {
        GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objGestionarDocenteGateway,
                objDocenteFormateadorResultados);
        return objGestionarDocenteCU;
    }
}

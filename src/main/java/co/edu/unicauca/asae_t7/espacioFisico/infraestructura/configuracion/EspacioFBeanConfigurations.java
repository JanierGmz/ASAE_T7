package co.edu.unicauca.asae_t7.espacioFisico.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae_t7.espacioFisico.dominio.casosDeUso.GestionarEspacioFisicoCUAdapter;

@Configuration
public class EspacioFBeanConfigurations {

    @Bean
    public GestionarEspacioFisicoCUAdapter crearGestionarEspacioFisicoCUInt(
            GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway,
            FormateadorResultadosIntPort objEspacioFisicoFormateadorResultados) {
        GestionarEspacioFisicoCUAdapter objGestionarEspacioFisicoCU = new GestionarEspacioFisicoCUAdapter(
                objGestionarEspacioFisicoGateway, objEspacioFisicoFormateadorResultados);
        return objGestionarEspacioFisicoCU;
    }
}

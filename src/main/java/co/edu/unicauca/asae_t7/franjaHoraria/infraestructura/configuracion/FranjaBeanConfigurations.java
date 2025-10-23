package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.casosDeUso.GestionarFranjaHorariaCUAdapter;

@Configuration
public class FranjaBeanConfigurations {

    @Bean
    public GestionarFranjaHorariaCUAdapter crearGestionarFranjaHorariaCUInt(
            GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        GestionarFranjaHorariaCUAdapter objGestionarFranjaHorariaCU = new GestionarFranjaHorariaCUAdapter(
                objGestionarFranjaHorariaGateway, objFormateadorResultados);
        return objGestionarFranjaHorariaCU;
    }
}

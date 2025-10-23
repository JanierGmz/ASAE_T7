package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.casosDeUso.GestionarFranjaHorariaCUAdapter;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.handlers.*;

@Configuration
public class FranjaBeanConfigurations {

    @Bean
    public GestionarFranjaHorariaCUAdapter crearGestionarFranjaHorariaCUInt(
            GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFormateadorResultados,
            ValidacionChain objValidacionChain) {
        GestionarFranjaHorariaCUAdapter objGestionarFranjaHorariaCU = new GestionarFranjaHorariaCUAdapter(
                objGestionarFranjaHorariaGateway, objFormateadorResultados, objValidacionChain);
        return objGestionarFranjaHorariaCU;
    }

    @Bean
    public DocenteOcupado crearBeanDocenteOcupado(
            GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        return new DocenteOcupado(
                objGestionarFranjaHorariaGateway,
                objFranjaHorariaFormateadorResultados);
    }

    @Bean
    public EspacioFisicoOcupado crearBeanEspacioFisicoOcupado(
            GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        return new EspacioFisicoOcupado(
                objGestionarFranjaHorariaGateway,
                objFranjaHorariaFormateadorResultados);
    }

    @Bean
    public ExisteCurso crearBeanExisteCurso(
            GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        return new ExisteCurso(
                objGestionarFranjaHorariaGateway,
                objFranjaHorariaFormateadorResultados);
    }

    @Bean
    public ExisteDocente crearBeanExisteDocente(
            GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        return new ExisteDocente(
                objGestionarFranjaHorariaGateway,
                objFranjaHorariaFormateadorResultados);
    }

    @Bean
    public ExisteEspacioFisico crearBeanExisteEspacioFisico(
            GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        return new ExisteEspacioFisico(
                objGestionarFranjaHorariaGateway,
                objFranjaHorariaFormateadorResultados);
    }

    @Bean
    public ValidacionChain crearBeanValidacionChain(
            ExisteDocente existeDocenteHandler,
            ExisteCurso existeCursoHandler,
            ExisteEspacioFisico existeEspacioFisicoHandler,
            DocenteOcupado docenteOcupadoHandler,
            EspacioFisicoOcupado espacioFisicoOcupadoHandler) {

        return new ValidacionChain(
                existeDocenteHandler,
                existeCursoHandler,
                existeEspacioFisicoHandler,
                docenteOcupadoHandler,
                espacioFisicoOcupadoHandler);
    }

}

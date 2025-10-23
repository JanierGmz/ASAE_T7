package co.edu.unicauca.asae_t7.franjaHoraria.dominio.casosDeUso;


import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;

public class GestionarFranjaHorariaCUAdapter  implements GestionarFranjaHorariaCUIntPort{

    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;

    private final FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados;

    public GestionarFranjaHorariaCUAdapter(GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,  FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        this.objGestionarFranjaHorariaGateway = objGestionarFranjaHorariaGateway;
        this.objFranjaHorariaFormateadorResultados = objFranjaHorariaFormateadorResultados;
    }

    @Override
    public FranjaHoraria crear(FranjaHoraria objFranjaHoraria) {
        return this.objGestionarFranjaHorariaGateway.guardar(objFranjaHoraria);
    }

}

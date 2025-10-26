package co.edu.unicauca.asae_t7.franjaHoraria.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae_t7.common.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.chainResponsibility.handlers.ValidacionChain;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;

public class GestionarFranjaHorariaCUAdapter  implements GestionarFranjaHorariaCUIntPort{

    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;

    private final FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados;

    private final ValidacionChain objValidacionChain;

    public GestionarFranjaHorariaCUAdapter(GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,  FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados,
    ValidacionChain objValidacionChain) {
        this.objGestionarFranjaHorariaGateway = objGestionarFranjaHorariaGateway;
        this.objFranjaHorariaFormateadorResultados = objFranjaHorariaFormateadorResultados;
        this.objValidacionChain = objValidacionChain;
    }

    @Override
    public FranjaHoraria crear(FranjaHoraria objFranjaHoraria) {
        System.out.println("Iniciando creación de franja horaria...");
        System.out.println("Dia: " + objFranjaHoraria.getDia());
        System.out.println("Hora Inicio: " + objFranjaHoraria.getHoraInicio());
        System.out.println("Hora Fin: " + objFranjaHoraria.getHoraFin());
        System.out.println("Id Curso: " + objFranjaHoraria.getIdCurso());
        System.out.println("Id Espacio Fisico: " + objFranjaHoraria.getIdEspacioFisico());
        
        if(!objValidacionChain.validar(objFranjaHoraria)){
            this.objFranjaHorariaFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error: La franja horaria no cumple con las reglas de negocio.");
            return null; // No continuar con el guardado si la validación falla
        }
        return this.objGestionarFranjaHorariaGateway.guardar(objFranjaHoraria);
    }

    @Override
    public List<FranjaHoraria> buscarFranjasHorariasPorCursoId(Integer idCurso) {
        return this.objGestionarFranjaHorariaGateway.buscarFranjasHorariasPorCursoId(idCurso);
    }

    @Override
    public boolean eliminarFranjasHorariasPorCursoId(Integer idCurso) {
        return this.objGestionarFranjaHorariaGateway.eliminarFranjasHorariasPorCursoId(idCurso);
    }

    @Override
    public List<FranjaHoraria> buscarFranjasHorariasPorDocenteId(Integer idDocente) {
        return this.objGestionarFranjaHorariaGateway.buscarFranjasHorariasPorDocenteId(idDocente);
    }

}

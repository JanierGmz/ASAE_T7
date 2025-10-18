package co.edu.unicauca.asae_t7.docente.dominio.casosDeUso;

import co.edu.unicauca.asae_t7.docente.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae_t7.docente.aplicacion.output.DocenteFormateadorResultadosIntPort;
import co.edu.unicauca.asae_t7.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae_t7.docente.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {

    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;

    private final DocenteFormateadorResultadosIntPort objDocenteFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objGestionarDocenteGateway,  DocenteFormateadorResultadosIntPort objDocenteFormateadorResultados) {
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
        this.objDocenteFormateadorResultados = objDocenteFormateadorResultados;
    }

    @Override
    public Docente crear(Docente objDocente) {
        Docente objDocenteCreado = null;
        if(objDocente.getId() != null && this.objGestionarDocenteGateway.existeDocentePorId(objDocente.getId())){
            this.objDocenteFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error: Docente ya existe con ese ID.");
        }else {
            if(this.objGestionarDocenteGateway.existeDocentePorCorreo(objDocente.getCorreo())){
                this.objDocenteFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error: Docente ya existe con ese correo.");
            }
            objDocenteCreado = this.objGestionarDocenteGateway.guardar(objDocente);
        }
        return objDocenteCreado;
    }
}

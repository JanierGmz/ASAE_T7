package co.edu.unicauca.asae_t7.curso.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae_t7.curso.aplicacion.input.GestionarCursoCUIntPort;
import co.edu.unicauca.asae_t7.curso.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;

public class GestionaCursoCUAdapter implements GestionarCursoCUIntPort{
    private final GestionarCursoGatewayIntPort objGestionarProductoGateway;

    public GestionaCursoCUAdapter(GestionarCursoGatewayIntPort objGestionarProductoGateway) {
        this.objGestionarProductoGateway = objGestionarProductoGateway;
    }

    @Override
    public boolean existeCursoPorCodigo(String codigo){
        return objGestionarProductoGateway.existeCursoPorCodigo(codigo);
    }

    @Override
    public Curso consultar(Integer codigo){
        return objGestionarProductoGateway.consultar(codigo);
    }

    @Override
    public List<Curso> listar(){
        List<Curso> listaCursos = objGestionarProductoGateway.listar();
        return listaCursos;
    }
}

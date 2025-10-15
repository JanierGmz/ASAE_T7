package co.edu.unicauca.asae_t7.curso.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;

public interface GestionarCursoGatewayIntPort {
    public boolean existeCursoPorCodigo(String codigo);
    public Curso consultar(Integer codigo);
    public List<Curso> listar();
}

package co.edu.unicauca.asae_t7.curso.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;

public interface GestionarCursoGatewayIntPort {
    public boolean existeCursoPorId(Integer id);
    public Curso consultar(Integer codigo);
    public List<Curso> listar();
    public List<Curso> buscarCursosPorAsignatura(String nombreAsignatura);
}

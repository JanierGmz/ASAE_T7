package co.edu.unicauca.asae_t7.curso.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;

public interface GestionarCursoCUIntPort {
    public boolean existeCursoPorId(Integer id);
    public Curso consultar(Integer codigo);
    public List<Curso> listar();
}

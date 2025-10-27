package co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae_t7.curso.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;
import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae_t7.curso.dominio.modelos.Curso;

@Service
public class GestionarCursoGatewayImplAdapter implements GestionarCursoGatewayIntPort {
    private final CursoRepositoryInt objCursoRepository;

    @Autowired
    @Qualifier("modelMapperPrincipal")
    private ModelMapper cursoModelMapper;

    public GestionarCursoGatewayImplAdapter(CursoRepositoryInt objCursoRepository) {
        this.objCursoRepository = objCursoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeCursoPorId(Integer id) {
        return this.objCursoRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Curso consultar(Integer codigo) {
        CursoEntity objCursoEntity = this.objCursoRepository.findById(codigo).orElse(null);
        Curso objCurso = this.cursoModelMapper.map(objCursoEntity, Curso.class);
        return objCurso;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listar() {
        Iterable<CursoEntity> lista = this.objCursoRepository.findAll();
        List<Curso> listaObtenida = this.cursoModelMapper.map(lista, new TypeToken<List<Curso>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> buscarCursosPorAsignatura(String nombreAsignatura) {
        Iterable<CursoEntity> listaCursosEntity = this.objCursoRepository.findByObjAsignaturaNombre(nombreAsignatura);
        List<Curso> listaCursos = this.cursoModelMapper.map(listaCursosEntity, new TypeToken<List<Curso>>() {
        }.getType());
        return listaCursos;
    }
}

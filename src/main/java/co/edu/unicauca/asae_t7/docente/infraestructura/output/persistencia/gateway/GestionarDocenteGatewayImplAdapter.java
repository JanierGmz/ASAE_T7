package co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae_t7.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae_t7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final DocenteRepositoryInt objDocenteRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocenteRepositoryInt objDocenteRepository, ModelMapper docenteModelMapper) {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docenteModelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeDocentePorId(Integer idDocente) {
        return this.objDocenteRepository.existsById(idDocente);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeDocentePorCorreo(String correoDocente) {
        return this.objDocenteRepository.existeDocentePorCorreo(correoDocente) == 1;
    }

    @Override
    @Transactional()
    public Docente guardar(Docente objDocente) {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);
        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        return objDocenteRespuesta;
    }
}

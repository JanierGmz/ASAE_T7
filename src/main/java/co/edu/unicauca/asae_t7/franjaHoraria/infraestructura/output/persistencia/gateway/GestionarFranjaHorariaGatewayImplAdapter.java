package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.output.persistencia.gateway;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
import co.edu.unicauca.asae_t7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae_t7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepositoryInt;

@Service
public class GestionarFranjaHorariaGatewayImplAdapter implements GestionarFranjaHorariaGatewayIntPort {

    private final FranjaHorariaRepositoryInt objFranjaHorariaRepository;
    private final CursoRepositoryInt objCursoRepository;
    private final EspacioFisicoRepositoryInt objEspacioFisicoRepository;
    private final ModelMapper franjaHorariaModelMapper;

    public GestionarFranjaHorariaGatewayImplAdapter(FranjaHorariaRepositoryInt objFranjaHorariaRepository,
            CursoRepositoryInt objCursoRepository, EspacioFisicoRepositoryInt objEspacioFisicoRepository,
            ModelMapper franjaHorariaModelMapper) {
        this.objFranjaHorariaRepository = objFranjaHorariaRepository;
        this.objCursoRepository = objCursoRepository;
        this.objEspacioFisicoRepository = objEspacioFisicoRepository;
        this.franjaHorariaModelMapper = franjaHorariaModelMapper;
    }

    @Override
    @Transactional
    public FranjaHoraria guardar(FranjaHoraria objFranjaHoraria) {

        FranjaHorariaEntity objFranjaHorariaEntity = this.franjaHorariaModelMapper.map(objFranjaHoraria, FranjaHorariaEntity.class);

        

        CursoEntity objCursoEntity = this.objCursoRepository.getReferenceById(objFranjaHoraria.getIdCurso());
        objFranjaHorariaEntity.setObjCurso(objCursoEntity);

        EspacioFisicoEntity objEspacioFisicoEntity = this.objEspacioFisicoRepository.getReferenceById(objFranjaHoraria.getIdEspacioFisico());
        objFranjaHorariaEntity.setObjEspacioFisico(objEspacioFisicoEntity);

        objFranjaHorariaEntity.setDia(objFranjaHorariaEntity.getDia().toUpperCase());

        FranjaHorariaEntity objFranjaHorariaEntityRegistrado = this.objFranjaHorariaRepository.save(objFranjaHorariaEntity);
        FranjaHoraria objFranjaHorariaRespuesta = this.franjaHorariaModelMapper.map(objFranjaHorariaEntityRegistrado, FranjaHoraria.class);
        return objFranjaHorariaRespuesta;
    }

}

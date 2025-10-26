package co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import co.edu.unicauca.asae_t7.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae_t7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae_t7.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
@Service
public class GestionarEspacioFisicoGatewayImplAdapter implements GestionarEspacioFisicoGatewayIntPort {
    private final EspacioFisicoRepositoryInt objEspacioFisicoRepository;
    private final ModelMapper espacioFisicoMapper;

    public GestionarEspacioFisicoGatewayImplAdapter(EspacioFisicoRepositoryInt objEspacioFisicoRepository, ModelMapper espacioFisicoMapper) {
        this.objEspacioFisicoRepository = objEspacioFisicoRepository;
        this.espacioFisicoMapper = espacioFisicoMapper;
    }

    @Override
    public List<EspacioFisico> listarPorNombreYCapacidadEspaciosFisicos(String nombre,
            Integer capacidad) {
        Iterable<EspacioFisicoEntity> lista= this.objEspacioFisicoRepository.findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(nombre, capacidad);
        List<EspacioFisico> listaObtenida= this.espacioFisicoMapper.map(lista,new TypeToken<List<EspacioFisico>>() {}.getType()); 
        return listaObtenida;
    }

    @Override
    public int actualizarEstadoPorId(Integer id, Boolean estado) {
        return objEspacioFisicoRepository.actualizarEstadoPorId(id, estado);
    }

    @Override
    public boolean existeEspacioFisico(Integer id) {
        return objEspacioFisicoRepository.existsById(id);
    }
}

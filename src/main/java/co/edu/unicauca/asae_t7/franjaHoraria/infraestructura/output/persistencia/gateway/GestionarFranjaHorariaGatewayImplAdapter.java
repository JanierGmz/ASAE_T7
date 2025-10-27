package co.edu.unicauca.asae_t7.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.modelmapper.TypeToken;

import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae_t7.curso.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;
import co.edu.unicauca.asae_t7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae_t7.docente.infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;
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
        private final DocenteRepositoryInt objDocenteRepository;
        private final ModelMapper franjaHorariaModelMapper;

        public GestionarFranjaHorariaGatewayImplAdapter(FranjaHorariaRepositoryInt objFranjaHorariaRepository,
                        CursoRepositoryInt objCursoRepository,
                        EspacioFisicoRepositoryInt objEspacioFisicoRepository,
                        DocenteRepositoryInt objDocenteRepository,
                        ModelMapper franjaHorariaModelMapper) {
                this.objFranjaHorariaRepository = objFranjaHorariaRepository;
                this.objCursoRepository = objCursoRepository;
                this.objEspacioFisicoRepository = objEspacioFisicoRepository;
                this.objDocenteRepository = objDocenteRepository;
                this.franjaHorariaModelMapper = franjaHorariaModelMapper;
        }

        @Override
        @Transactional
        public FranjaHoraria guardar(FranjaHoraria objFranjaHoraria) {

                FranjaHorariaEntity objFranjaHorariaEntity = this.franjaHorariaModelMapper.map(objFranjaHoraria,
                                FranjaHorariaEntity.class);

                CursoEntity objCursoEntity = this.objCursoRepository.getReferenceById(objFranjaHoraria.getIdCurso());
                objFranjaHorariaEntity.setObjCurso(objCursoEntity);

                EspacioFisicoEntity objEspacioFisicoEntity = this.objEspacioFisicoRepository
                                .getReferenceById(objFranjaHoraria.getIdEspacioFisico());
                objFranjaHorariaEntity.setObjEspacioFisico(objEspacioFisicoEntity);

                objFranjaHorariaEntity.setDia(objFranjaHorariaEntity.getDia().toUpperCase());

                FranjaHorariaEntity objFranjaHorariaEntityRegistrado = this.objFranjaHorariaRepository
                                .save(objFranjaHorariaEntity);
                FranjaHoraria objFranjaHorariaRespuesta = this.franjaHorariaModelMapper.map(
                                objFranjaHorariaEntityRegistrado,
                                FranjaHoraria.class);
                return objFranjaHorariaRespuesta;
        }

        @Override
        @Transactional(readOnly = true)
        public boolean espacioOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Integer idEspacioFisico) {
                return this.objFranjaHorariaRepository.existeOcupacionEnHorario(dia, horaInicio, horaFin,
                                idEspacioFisico);
        }

        @Override
        @Transactional(readOnly = true)
        public Integer docenteOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Integer idDocente) {
                return this.objFranjaHorariaRepository.docenteOcupadoEnHorario(dia, horaInicio, horaFin, idDocente);
        }

        @Override
        @Transactional(readOnly = true)
        public boolean existeEspacioFisico(Integer idEspacioFisico) {
                return this.objEspacioFisicoRepository.existsById(idEspacioFisico);
        }

        @Override
        @Transactional(readOnly = true)
        public boolean existeDocente(Integer idDocente) {
                return this.objDocenteRepository.existsById(idDocente);
        }

        @Override
        @Transactional(readOnly = true)
        public boolean existeCurso(Integer idCurso) {
                return this.objCursoRepository.existsById(idCurso);
        }

        @Override
        @Transactional(readOnly = true)
        public List<Integer> obtenerDocenteIdsPorCurso(Integer idCurso) {
                return this.objCursoRepository.findDocenteIdsByCursoId(idCurso);
        }

        @Override
        @Transactional(readOnly = true)
        public List<FranjaHoraria> findByObjCursoId(Integer idCurso) {
                List<FranjaHorariaEntity> entities = objFranjaHorariaRepository.findByObjCursoId(idCurso);
                return entities.stream()
                                .map(entity -> franjaHorariaModelMapper.map(entity, FranjaHoraria.class))
                                .toList();
        }

        @Override
        @Transactional(readOnly = true)
        public List<FranjaHoraria> buscarFranjasHorariasPorCursoId(Integer idCurso) {
                Iterable<FranjaHorariaEntity> listaFranjasHorariasEntity = this.objFranjaHorariaRepository
                                .findFranjasYEspacioPorCursoId(idCurso);
                List<FranjaHoraria> listaFranjasHorarias = this.franjaHorariaModelMapper.map(listaFranjasHorariasEntity,
                                new TypeToken<List<FranjaHoraria>>() {
                                }.getType());
                return listaFranjasHorarias;
        }

        @Override
        @Transactional
        public boolean eliminarFranjasHorariasPorCursoId(Integer idCurso) {
                return this.objFranjaHorariaRepository.deleteFranjasByCursoId(idCurso) > 0;
        }

        @Override
        @Transactional(readOnly = true)
        public List<FranjaHoraria> buscarFranjasSinCursoPorCursoId(Integer idCurso) {

                List<Integer> idsDocentes = objCursoRepository.findDocenteIdsByCursoId(idCurso);
                List<DocenteEntity> docentesCursoEntities = objDocenteRepository.findAllById(idsDocentes);

                List<Docente> docentesDominio = docentesCursoEntities.stream()
                                .map(docenteEntity -> franjaHorariaModelMapper.map(docenteEntity, Docente.class))
                                .toList();

                List<FranjaHorariaEntity> franjasEntities = objFranjaHorariaRepository
                                .findByObjCursoId(idCurso);

                System.out.println("---------------Antes del mapeo------------------");
                List<FranjaHoraria> franjasDominio = this.franjaHorariaModelMapper.map(franjasEntities,
                                new TypeToken<List<FranjaHoraria>>() {
                                }.getType());
                System.out.println("---------------Después del mapeo------------------");
                franjasDominio.forEach(franja -> franja.setListaDocentes(docentesDominio));

                return franjasDominio;
        }

        @Override
        @Transactional(readOnly = true)
        public List<FranjaHoraria> buscarFranjasHorariasPorDocenteId(Integer idDocente) {
                Iterable<FranjaHorariaEntity> listaFranjasHorariasEntity = this.objFranjaHorariaRepository
                                .findFranjasByDocenteIdWithEagerFetch(idDocente);
                List<FranjaHoraria> listaFranjasHorarias = this.franjaHorariaModelMapper.map(listaFranjasHorariasEntity,
                                new TypeToken<List<FranjaHoraria>>() {
                                }.getType());
                return listaFranjasHorarias;
        }
}

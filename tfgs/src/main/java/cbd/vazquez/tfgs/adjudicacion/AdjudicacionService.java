package cbd.vazquez.tfgs.adjudicacion;

import cbd.vazquez.tfgs.propuesta.PropuestaDTO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdjudicacionService {

    @Autowired
    private AdjudicacionRepository repository;

    public Adjudicacion saveAdjudicacion(Adjudicacion adjudicacion) {
        return repository.save(adjudicacion);
    }

    public Adjudicacion updateAdjudicacion(ObjectId id, String estado) {
        Adjudicacion adjudicacionToUpdate = repository.findById(id).orElse(null);
        adjudicacionToUpdate.setEstado(estado);
        return repository.save(adjudicacionToUpdate);
    }

    public AdjudicacionDTO getAdjudicacionByAlumno(ObjectId alumnoId) {
        Adjudicacion adjudicacion = repository.findAdjudicacionByAlumno(alumnoId).orElse(null);
        return new AdjudicacionDTO(adjudicacion);
    }

    public List<AdjudicacionDTO> getAdjudicacionByProfesor(ObjectId profesorId) {
        List<Adjudicacion> adjudicaciones = repository.findAdjudicacionByProfesor(profesorId);
        return adjudicaciones.stream().map(adjudicacion -> new AdjudicacionDTO(adjudicacion)).collect(Collectors.toList());
    }

    public AdjudicacionDTO getAdjudicacionByPropuesta(ObjectId propuestaId) {
        Adjudicacion adjudicacion = repository.findAdjudicacionByPropuesta(propuestaId).orElse(null);
        return new AdjudicacionDTO(adjudicacion);
    }

    public List<AdjudicacionDTO> getAdjudicacionByEstado(String estado) {
        List<Adjudicacion> adjudicaciones = repository.findAdjudicacionByEstado(estado);
        return adjudicaciones.stream().map(adjudicacion -> new AdjudicacionDTO(adjudicacion)).collect(Collectors.toList());
    }

    public void deleteAdjudicacion(ObjectId id) {
        repository.deleteById(id);
    }

    public List<AdjudicacionDTO> getAllAdjudicaciones() {
        List<Adjudicacion> adjudicaciones = repository.findAll();
        return adjudicaciones.stream().map(adjudicacion -> new AdjudicacionDTO(adjudicacion)).collect(Collectors.toList());
    }

    public AdjudicacionDTO getAdjudicacionById(ObjectId id) {
        Adjudicacion adjudicacion = repository.findById(id).orElse(null);
        return new AdjudicacionDTO(adjudicacion);
    }

    public Adjudicacion createAdjudicacion(Adjudicacion adjudicacion) {
        return repository.save(adjudicacion);
    }

}

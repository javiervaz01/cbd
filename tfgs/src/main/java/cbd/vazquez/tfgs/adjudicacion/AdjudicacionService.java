package cbd.vazquez.tfgs.adjudicacion;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Adjudicacion getAdjudicacionByAlumno(ObjectId alumnoId) {
        return repository.findAdjudicacionByAlumno(alumnoId).orElse(null);
    }

    public List<Adjudicacion> getAdjudicacionByProfesor(ObjectId profesorId) {
        return repository.findAdjudicacionByProfesor(profesorId);
    }

    public Adjudicacion getAdjudicacionByPropuesta(ObjectId propuestaId) {
        return repository.findAdjudicacionByPropuesta(propuestaId).orElse(null);
    }

    public List<Adjudicacion> getAdjudicacionByEstado(String estado) {
        return repository.findAdjudicacionByEstado(estado);
    }

    public void deleteAdjudicacion(ObjectId id) {
        repository.deleteById(id);
    }

    public List<Adjudicacion> getAllAdjudicaciones() {
        return repository.findAll();
    }

    public Adjudicacion getAdjudicacionById(ObjectId id) {
        return repository.findById(id).orElse(null);
    }


}

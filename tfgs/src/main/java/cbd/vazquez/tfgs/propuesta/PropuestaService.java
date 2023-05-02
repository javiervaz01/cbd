package cbd.vazquez.tfgs.propuesta;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropuestaService {

    @Autowired
    private PropuestaRepository repository;

    public List<Propuesta> getAllPropuestas() {
        return repository.findAll();
    }

    public Optional<Propuesta> getPropuestaByTitulo(String titulo) {
        return repository.findPropuestaByTitulo(titulo);
    }

    public Optional<List<Propuesta>> getPropuestasByProfesor(ObjectId profesor) {
        return repository.findPropuestaByProfesor(profesor);
    }

    public Optional<List<Propuesta>> getPropuestasByDepartamento(DEPARTAMENTO departamento) {
        return repository.findPropuestaByDepartamento(departamento);
    }

    public void createPropuesta(Propuesta propuesta) {
        repository.save(propuesta);
    }

    public void deletePropuesta(ObjectId id) {
        repository.deleteById(id);
    }

    public void updatePropuesta(ObjectId id, Propuesta propuesta) {
        repository.findById(id).map(p -> {
            p.setTitulo(propuesta.getTitulo());
            p.setDescripcion(propuesta.getDescripcion());
            p.setDepartamento(propuesta.getDepartamento());
            p.setProfesor(propuesta.getProfesor());
            return repository.save(p);
        });
    }
}

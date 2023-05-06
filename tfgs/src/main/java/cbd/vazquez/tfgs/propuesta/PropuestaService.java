package cbd.vazquez.tfgs.propuesta;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropuestaService {

    @Autowired
    private PropuestaRepository repository;

    public List<PropuestaDTO> getAllPropuestas() {
        List<Propuesta> propuestas = repository.findAll();
        return propuestas.stream().map(propuesta -> new PropuestaDTO(propuesta)).collect(Collectors.toList());
    }

    public PropuestaDTO getPropuestaByTitulo(String titulo) {
        Propuesta propuesta = repository.findPropuestaByTitulo(titulo).get();
        return new PropuestaDTO(propuesta);
    }

    public PropuestaDTO getPropuestaById(ObjectId id) {
        Propuesta propuesta = repository.findPropuestaById(id).get();
        return new PropuestaDTO(propuesta);
    }

    public List<PropuestaDTO> getPropuestasByProfesor(ObjectId profesor) {
        Optional<List<Propuesta>> propuestas = repository.findPropuestaByProfesor(profesor);
        return propuestas.get().stream().map(propuesta -> new PropuestaDTO(propuesta)).collect(Collectors.toList());
    }

    public List<PropuestaDTO> getPropuestasByDepartamento(DEPARTAMENTO departamento) {
        Optional<List<Propuesta>> propuestas = repository.findPropuestaByDepartamento(departamento);
        return propuestas.get().stream().map(propuesta -> new PropuestaDTO(propuesta)).collect(Collectors.toList());
    }

    public void createPropuesta(Propuesta propuesta) {
        repository.save(propuesta);
    }

    public void deletePropuesta(ObjectId id) {
        repository.deleteById(id);
    }



    public void updatePropuesta(ObjectId id, Propuesta propuesta){
        repository.findById(id).map(p -> {
            if(propuesta.getTitulo() != null){
                p.setTitulo(propuesta.getTitulo());
            }
            if(propuesta.getDescripcion() != null){
                p.setDescripcion(propuesta.getDescripcion());
            }
            if(propuesta.getDepartamento() != null){
                p.setDepartamento(propuesta.getDepartamento());
            }
            if(propuesta.getProfesor() != null){
                p.setProfesor(propuesta.getProfesor());
            }
            return repository.save(p);
        });
    }
}

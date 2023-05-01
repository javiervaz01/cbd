package cbd.vazquez.tfgs.propuesta;

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

    public Optional<List<Propuesta>> getPropuestasByProfesor(Profesor profesor) {
        return repository.findPropuestaByProfesor(profesor);
    }

    public Optional<List<Propuesta>> getPropuestasByDepartamento(DEPARTAMENTO departamento) {
        return repository.findPropuestaByDepartamento(departamento);
    }
}

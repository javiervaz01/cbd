package cbd.vazquez.tfgs.propuesta;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropuestaRepository extends MongoRepository<Propuesta, ObjectId> {

    Optional<Propuesta> findPropuestaByTitulo(String titulo);

    Optional<List<Propuesta>> findPropuestaByProfesor(Profesor profesor);

    Optional<List<Propuesta>> findPropuestaByDepartamento(DEPARTAMENTO departamento);

    Optional<List<Propuesta>> findPropuestaByTitulo(Profesor profesor);

}

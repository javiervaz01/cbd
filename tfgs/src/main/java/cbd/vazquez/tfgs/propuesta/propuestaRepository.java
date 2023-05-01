package cbd.vazquez.tfgs.propuesta;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface propuestaRepository extends MongoRepository<Propuesta, ObjectId> {
Optional<Propuesta> findPropuestaByTitulo(String titulo);

Optional<List<Propuesta>> findPropuestaByProfesor(Profesor profesor);


}

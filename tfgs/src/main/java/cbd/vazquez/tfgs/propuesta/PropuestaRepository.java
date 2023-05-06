package cbd.vazquez.tfgs.propuesta;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropuestaRepository extends MongoRepository<Propuesta, ObjectId> {

    @Query("{'titulo': ?0}")
    Optional<Propuesta> findPropuestaByTitulo(String titulo);

    @Query("{'id': ?0}")
    Optional<Propuesta> findPropuestaById(ObjectId Id);

    @Query("{'profesor': ?0}")
    Optional<List<Propuesta>> findPropuestaByProfesor(ObjectId profesorId);

    @Query("{'departamento': ?0}")
    Optional<List<Propuesta>> findPropuestaByDepartamento(DEPARTAMENTO departamento);



}

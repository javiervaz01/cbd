package cbd.vazquez.tfgs.propuesta;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends MongoRepository<Profesor, ObjectId> {

    @Query("{'nombre': ?0}")
    Optional<Profesor> findProfesorByNombre(String nombre);

    @Query("{'departamento': ?0}")
    List<Profesor> findProfesorByDepartamento(DEPARTAMENTO departamento);


}

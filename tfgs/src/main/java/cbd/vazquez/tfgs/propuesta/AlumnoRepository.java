package cbd.vazquez.tfgs.propuesta;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends MongoRepository<Alumno, ObjectId> {

        @Query("{'nombre': ?0}")
        Optional<Alumno> findAlumnoByNombre(String nombre);
}

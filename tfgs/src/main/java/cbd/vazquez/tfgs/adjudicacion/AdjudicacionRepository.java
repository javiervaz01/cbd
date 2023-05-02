package cbd.vazquez.tfgs.adjudicacion;

import cbd.vazquez.tfgs.propuesta.Propuesta;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdjudicacionRepository extends MongoRepository<Adjudicacion, ObjectId> {

    @Query("{'alumno.$id': ?0}")
    Optional<Adjudicacion> findAdjudicacionByAlumno(ObjectId alumnoId);

    @Query("{'profesor.$id': ?0}")
    List<Adjudicacion> findAdjudicacionByProfesor(ObjectId profesorId);

    @Query("{'propuesta.$id': ?0}")
    Optional<Adjudicacion> findAdjudicacionByPropuesta(ObjectId propuestaId);

    @Query("{'estado': ?0}")
    List<Adjudicacion> findAdjudicacionByEstado(String estado);



}

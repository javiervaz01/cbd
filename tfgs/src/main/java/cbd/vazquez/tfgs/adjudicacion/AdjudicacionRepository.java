package cbd.vazquez.tfgs.adjudicacion;

import cbd.vazquez.tfgs.propuesta.Propuesta;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdjudicacionRepository extends MongoRepository<Adjudicacion, ObjectId> {

    @Query("{'titulo': ?0}")
    Optional<Adjudicacion> findAdjudicacionByTitulo(String titulo);

}

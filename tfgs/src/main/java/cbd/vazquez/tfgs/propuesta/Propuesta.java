package cbd.vazquez.tfgs.propuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Propuesta {

    @Id
    private ObjectId id;

    private String titulo;

    private String descripcion;

    @DocumentReference(collection = "profesores")
    private Profesor profesor;


    private DEPARTAMENTO departamento;

    private String estado;


}

package cbd.vazquez.tfgs.adjudicacion;

import cbd.vazquez.tfgs.propuesta.Alumno;
import cbd.vazquez.tfgs.propuesta.Profesor;
import cbd.vazquez.tfgs.propuesta.Propuesta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "adjudicaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adjudicacion {

    @Id
    private ObjectId id;

    @DocumentReference(collection = "propuestas")
    private Propuesta propuesta;

    @DocumentReference(collection = "alumnos")
    private Alumno alumno;

    @Field("estado")
    private String estado;

    public Adjudicacion(Propuesta propuesta, Alumno alumno, String estado) {
        this.propuesta = propuesta;
        this.alumno = alumno;
        //this.profesor = profesor;
        this.estado = estado;
    }



}

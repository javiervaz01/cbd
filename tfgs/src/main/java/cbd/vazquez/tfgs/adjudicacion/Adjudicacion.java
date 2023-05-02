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

@Document(collection = "adjudicaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adjudicacion {

    @Id
    private ObjectId id;

    @DocumentReference(collection = "propuestas")
    private ObjectId propuestaId;

    @DocumentReference(collection = "alumnos")
    private Alumno alumno;

    @DocumentReference(collection = "profesores")
    private Profesor profesor;

    private String estado;

    public Adjudicacion(ObjectId propuestaId, Alumno alumno, Profesor profesor, String estado) {
        this.propuestaId = propuestaId;
        this.alumno = alumno;
        this.profesor = profesor;
        this.estado = estado;
    }



}

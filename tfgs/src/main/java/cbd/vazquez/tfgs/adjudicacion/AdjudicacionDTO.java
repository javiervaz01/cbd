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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdjudicacionDTO {

    @Id
    private String id;

    @DocumentReference(collection = "propuestas")
    private Propuesta propuesta;

    @DocumentReference(collection = "alumnos")
    private Alumno alumno;

    private String estado;

    public AdjudicacionDTO(Propuesta propuesta, Alumno alumno, String estado) {
        this.propuesta = propuesta;
        this.alumno = alumno;
        this.estado = estado;
    }
    public AdjudicacionDTO(Adjudicacion adjudicacion) {
        this.id = adjudicacion.getId().toHexString();
        this.propuesta = adjudicacion.getPropuesta();
        this.alumno = adjudicacion.getAlumno();
        this.estado = adjudicacion.getEstado();
    }
}

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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropuestaDTO {

    @Id
    private String id;

    private String titulo;

    private String descripcion;

    @DocumentReference(collection = "profesores")
    private Profesor profesor;


    private DEPARTAMENTO departamento;

    public PropuestaDTO(String titulo, String descripcion, Profesor profesor, DEPARTAMENTO departamento) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.departamento = departamento;
    }

    public PropuestaDTO(Propuesta propuesta) {
        this.id = propuesta.getId().toHexString();
        this.titulo = propuesta.getTitulo();
        this.descripcion = propuesta.getDescripcion();
        this.profesor = propuesta.getProfesor();
        this.departamento = propuesta.getDepartamento();
    }


}

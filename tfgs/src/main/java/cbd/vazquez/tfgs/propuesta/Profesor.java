package cbd.vazquez.tfgs.propuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profesores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @Id
    private ObjectId id;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private DEPARTAMENTO departamento;

    public Profesor(String nombre, String apellidos, String email, String telefono, DEPARTAMENTO departamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.departamento = departamento;
    }
}

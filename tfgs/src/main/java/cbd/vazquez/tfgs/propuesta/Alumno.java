package cbd.vazquez.tfgs.propuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alumnos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @Id
    private ObjectId id;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private String dni;

    private String titulacion;

    public Alumno(String nombre, String apellidos, String email, String telefono, String dni, String titulacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.titulacion = titulacion;
    }

}

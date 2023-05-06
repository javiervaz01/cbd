package cbd.vazquez.tfgs.propuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {

    @Id
    private String id;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private String dni;

    private String titulacion;

    public AlumnoDTO(String nombre, String apellidos, String email, String telefono, String dni, String titulacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.titulacion = titulacion;
    }

    public AlumnoDTO(Alumno alumno) {
        this.id = alumno.getId().toHexString();
        this.nombre = alumno.getNombre();
        this.apellidos = alumno.getApellidos();
        this.email = alumno.getEmail();
        this.telefono = alumno.getTelefono();
        this.dni = alumno.getDni();
        this.titulacion = alumno.getTitulacion();
    }

}

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
public class ProfesorDTO {

    @Id
    private String id;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private DEPARTAMENTO departamento;

    public ProfesorDTO(String nombre, String apellidos, String email, String telefono, DEPARTAMENTO departamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.departamento = departamento;
    }

    public ProfesorDTO(Profesor profesor) {
        this.id = profesor.getId().toHexString();
        this.nombre = profesor.getNombre();
        this.apellidos = profesor.getApellidos();
        this.email = profesor.getEmail();
        this.telefono = profesor.getTelefono();
        this.departamento = profesor.getDepartamento();
    }
}

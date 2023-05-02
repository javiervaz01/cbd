package cbd.vazquez.tfgs.propuesta;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class propuestaController {

    @Autowired
    private PropuestaService service;

    @GetMapping("/propuestas")
    public List<Propuesta> allPropuestas() {
        return service.getAllPropuestas();
    }

    @GetMapping("/propuestas/titulo/{titulo}")
    public ResponseEntity<Optional<Propuesta>> getPropuestaByTitulo(@PathVariable String titulo) {
        return new ResponseEntity<Optional<Propuesta>>(service.getPropuestaByTitulo(titulo), HttpStatus.OK);
    }

    @GetMapping("/propuestas/profesor/{profesor}")
    public ResponseEntity<Optional<List<Propuesta>>> getPropuestasByProfesor(@PathVariable ObjectId profesor) {
        return new ResponseEntity<Optional<List<Propuesta>>>(service.getPropuestasByProfesor(profesor), HttpStatus.OK);
    }

    @GetMapping("/propuestas/departamento/{departamento}")
    public ResponseEntity<Optional<List<Propuesta>>> getPropuestasByDepartamento(@PathVariable DEPARTAMENTO departamento) {
        return new ResponseEntity<Optional<List<Propuesta>>>(service.getPropuestasByDepartamento(departamento), HttpStatus.OK);
    }

    @Autowired
    private MongoClient mongoClient;

    @GetMapping("/test")
    public String testMongoConnection() {
        MongoDatabase database = mongoClient.getDatabase("cbd");
        return "Connected to database: " + database.getName();
    }
}

package cbd.vazquez.tfgs.propuesta;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class propuestaController {

    @Autowired
    private PropuestaService service;

    @GetMapping("/propuestas")
    public List<PropuestaDTO> allPropuestas() {
        return service.getAllPropuestas();
    }

    @GetMapping("/propuestas/titulo/{titulo}")
    public PropuestaDTO getPropuestaByTitulo(@PathVariable String titulo) {
        return service.getPropuestaByTitulo(titulo);
    }

    @GetMapping("/propuestas/{id}")
    public PropuestaDTO getPropuestaById(@PathVariable ObjectId id) {
        return service.getPropuestaById(id);
    }

    @GetMapping("/pruebaId")
    public String getPropuestaByTitulo() {
        return service.getAllPropuestas().get(0).getId();
    }

    @GetMapping("/propuestas/profesor/{profesor}")
    public List<PropuestaDTO> getPropuestasByProfesor(@PathVariable ObjectId profesor) {
        return service.getPropuestasByProfesor(profesor);
    }

    @GetMapping("/propuestas/departamento/{departamento}")
    public List<PropuestaDTO> getPropuestasByDepartamento(@PathVariable DEPARTAMENTO departamento) {
        return service.getPropuestasByDepartamento(departamento);
    }

    @PostMapping("/propuestas")
    public ResponseEntity<?> createPropuesta(@RequestBody Propuesta propuesta) {
        service.createPropuesta(propuesta);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/propuestas/{id}")
    public ResponseEntity<?> deletePropuesta(@PathVariable ObjectId id) {
        service.deletePropuesta(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/propuestas/{id}")
    public ResponseEntity<?> updatePropuesta(@PathVariable ObjectId id, @RequestBody Propuesta propuesta) {
        service.updatePropuesta(id, propuesta);
        return ResponseEntity.ok().build();
    }







    @Autowired
    private MongoClient mongoClient;

    @GetMapping("/test")
    public String testMongoConnection() {
        MongoDatabase database = mongoClient.getDatabase("cbd");
        return "Connected to database: " + database.getName();
    }
}

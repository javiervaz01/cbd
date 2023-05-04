package cbd.vazquez.tfgs.adjudicacion;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
public class AdjudicacionController {

    @Autowired
    private AdjudicacionService service;

    @GetMapping("/adjudicaciones")
    public List<Adjudicacion> allAdjudicaciones() {
        return service.getAllAdjudicaciones();
    }

    @GetMapping("/adjudicaciones/alumno/{alumno}")
    public Adjudicacion getAdjudicacionByAlumno(@PathVariable ObjectId alumno) {
        return service.getAdjudicacionByAlumno(alumno);
    }

    @GetMapping("/adjudicaciones/profesor/{profesor}")
    public List<Adjudicacion> getAdjudicacionByProfesor(@PathVariable ObjectId profesor) {
        return service.getAdjudicacionByProfesor(profesor);
    }

    @GetMapping("/adjudicaciones/propuesta/{propuesta}")
    public Adjudicacion getAdjudicacionByPropuesta(@PathVariable ObjectId propuesta) {
        return service.getAdjudicacionByPropuesta(propuesta);
    }

    @GetMapping("/adjudicaciones/estado/{estado}")
    public List<Adjudicacion> getAdjudicacionByEstado(@PathVariable String estado) {
        return service.getAdjudicacionByEstado(estado);
    }

    @GetMapping("/adjudicaciones/{id}")
    public Adjudicacion getAdjudicacionById(@PathVariable ObjectId id) {
        return service.getAdjudicacionById(id);
    }

    //Only the estado of the Adjudicacion can be changed
    @PutMapping("/adjudicaciones/{id}")
    public Adjudicacion updateAdjudicacion(@PathVariable ObjectId id, @RequestBody String estado) {
        return service.updateAdjudicacion(id, estado);
    }

    @PostMapping("/adjudicaciones")
    public Adjudicacion createAdjudicacion(@RequestBody Adjudicacion adjudicacion) {
        return service.createAdjudicacion(adjudicacion);
    }
}

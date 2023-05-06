package cbd.vazquez.tfgs.propuesta;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class AlumnoController {

    @Autowired
    private AlumnoRepository repository;

    @GetMapping("/alumnos")
    public List<AlumnoDTO> alAlumnos() {
        List<Alumno> alumnos = repository.findAll();
        return alumnos.stream().map(alumno -> new AlumnoDTO(alumno)).collect(Collectors.toList());
    }

    @GetMapping("alumnos/{id}")
    public Optional<Alumno> getAlumnoById(@PathVariable ObjectId id){
        return repository.findById(id);
    }

    @PostMapping("/alumnos")
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno){
        repository.save(alumno);
        return ResponseEntity.ok().build();    }
}

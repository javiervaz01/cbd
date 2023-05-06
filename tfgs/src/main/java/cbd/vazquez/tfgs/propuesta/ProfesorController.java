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
public class ProfesorController {

    @Autowired
    private ProfesorRepository repository;

    @GetMapping("/profesores")
    public List<ProfesorDTO> allProfesores() {
        List<Profesor> profesores = repository.findAll();
        return profesores.stream().map(profesor -> new ProfesorDTO(profesor)).collect(Collectors.toList());
    }

    @GetMapping("/profesores/{id}")
    public Optional<Profesor> getProfesorById(@PathVariable ObjectId id){
        return repository.findById(id);
    }

    @GetMapping("/profesores/nombre/{nombre}")
    public ProfesorDTO getProfesorByNombre(@PathVariable String nombre){

        Profesor profesor = repository.findProfesorByNombre(nombre).get();
        return new ProfesorDTO(profesor);
    }

    @GetMapping("/profesores/nombre/{nombre}/id")
    public String getProfesorIdByNombre(@PathVariable String nombre){
        Profesor profesor = repository.findProfesorByNombre(nombre).get();
        return profesor.getId().toHexString();
    }

    @GetMapping("/profesores/departamento/{departamento}")
    public Iterable<Profesor> getProfesorByDepartamento(@PathVariable DEPARTAMENTO departamento){
        return repository.findProfesorByDepartamento(departamento);
    }

    @PostMapping("/profesores")
    public ResponseEntity<?> createProfesor(@RequestBody Profesor profesor){
        repository.save(profesor);
        return ResponseEntity.ok().build();
    }
}

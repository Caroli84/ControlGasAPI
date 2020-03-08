package controlGas.controllers;

import controlGas.dao.LecturaRepository;
import controlGas.model.Lectura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LecturaController {
    @Autowired
    LecturaRepository lecturaRepository;

    @GetMapping("/controlGas/lectura/{id}")
    public ResponseEntity<Lectura> getLectura(@PathVariable Long id) {
        Optional<Lectura> lecturaOpt=lecturaRepository.findById(id);
        if(lecturaOpt.isPresent()){
            Lectura lectura=lecturaOpt.get();
            return new ResponseEntity<Lectura>(lectura, HttpStatus.OK);
        }else{
            return new ResponseEntity<Lectura>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/controlGas/lectura")
    public List<Lectura> getLectura() {
        return lecturaRepository.findAll();
    }

    @PostMapping("/controlGas/lectura")
    public void addLectura(@RequestBody Lectura lectura){lecturaRepository.save(lectura);}

    @DeleteMapping("/controlGas/lectura")
    public void deleteLectura(@RequestBody int id) {
        lecturaRepository.deleteById(Long.valueOf(id));
    }

    @PutMapping("/controlGas/lectura")
    public void updateLectura(@RequestBody Lectura lectura){lecturaRepository.save(lectura);}
}

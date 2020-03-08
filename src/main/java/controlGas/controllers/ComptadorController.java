package controlGas.controllers;

import controlGas.dao.ComptadorRepository;
import controlGas.model.Comptador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComptadorController {
    @Autowired
    ComptadorRepository comptadorRepository;

    @GetMapping("/controlGas/comptador/{id}")
    public List<Comptador> getComptador(@PathVariable Integer id) {
        return comptadorRepository.findAll();
    }

    @GetMapping("/controlGas/comptador")
    public List<Comptador> getComptador() {
        return comptadorRepository.findAll();
    }

    @PostMapping("/controlGas/comptador")
    public void addComptador(@RequestBody Comptador comptador){
        comptador.setClient(comptador.getClient()); // asigno id de cliente al contador
        comptadorRepository.save(comptador);

    }

    @DeleteMapping("/controlGas/comptador")
    public void deleteComptador(@RequestBody int id) {
        comptadorRepository.deleteById(Long.valueOf(id));
    }

    @PutMapping("/controlGas/comptador")
    public void updateComptador(@RequestBody Comptador comptador){comptadorRepository.save(comptador);}

}

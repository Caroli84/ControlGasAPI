package controlGas.controllers;

import controlGas.dao.PreuRepository;
import controlGas.model.Preu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PreuController {
    @Autowired
    PreuRepository preuRepository;

    @GetMapping("/controlGas/Preu/{id}")
    public ResponseEntity<Preu> getPreu(@PathVariable Long id) {
        Optional<Preu> preuOpt=preuRepository.findById(id);
            if(preuOpt.isPresent()){
                Preu preu=preuOpt.get();
                return new ResponseEntity<Preu>(preu, HttpStatus.OK);
            }else{
                return new ResponseEntity<Preu>(HttpStatus.NOT_FOUND);
            }

    }

    @GetMapping("/controlGas/Preu")
    public List<Preu> getPreu() {
        return preuRepository.findAll();
    }

//resposeentity si all va bien dara 200 en el header d ela reposta si algo falla devolvera 500
    //pero no podemos hacer nada mas de dar otro tipo de codigos, permite controlar el header y el body
    //404 no trobat lo enseñaria y asi el cliente notiene q interpretar pq algo esta vacio. El rest envia Entities con una cabecera.
    //el mapped lo tiene el que tiene menos, el One
    //cada comptador nomes tindra una lectura facturada, no le hacemos relacion, solo guardamos el id de la ultima lectura


    @PostMapping("/controlGas/Preu")
    public void addPreu(@RequestBody Preu preu){preuRepository.save(preu);}

    @DeleteMapping("/controlGas/Preu")
    public void deletePreu(@RequestBody int id) {
        preuRepository.deleteById(Long.valueOf(id));
    }

    @PutMapping("/controlGas/Preu")
    public void updatePreu(@RequestBody Preu preu){preuRepository.save(preu);}
}

package controlGas.controllers;

import controlGas.dao.ClientRepository;
import controlGas.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/controlGas/client/{id}")
    public List<Client> getClient(@PathVariable Integer id) {        return clientRepository.findAll();    }

    @GetMapping("/controlGas/client")
    public List<Client> getClient() {
        return clientRepository.findAll();
    }

//resposeentity si all va bien dara 200 en el header d ela reposta si algo falla devolvera 500
  //pero no podemos hacer nada mas de dar otro tipo de codigos, permite controlar el header y el body
    //404 no trobat lo enseñaria y asi el cliente notiene q interpretar pq algo esta vacio. El rest envia Entities con una cabecera.
    //el mapped lo tiene el que tiene menos, el One
    //cada comptador nomes tindra una lectura facturada, no le hacemos relacion, solo guardamos el id de la ultima lectura


    @PostMapping("/controlGas/client")
    public void addClient(@RequestBody Client client){clientRepository.save(client);}

    @DeleteMapping("/controlGas/client")
    public void deleteClient(@RequestBody int id) {
        clientRepository.deleteById(Long.valueOf(id));
    }

    @PutMapping("/controlGas/client")
    public void updateClient(@RequestBody Client client){clientRepository.save(client);}


}

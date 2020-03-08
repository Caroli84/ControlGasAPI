package controlGas.dao;

import controlGas.model.Comptador;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComptadorRepository extends CrudRepository<Comptador, Long> {
    Optional<Comptador> findById(Long id); //tiene metodos ispresent() lo guardo en variable boolean
    //Comptador findByName(String name);
    List<Comptador> findAll();
    void deleteById(Long id);

}


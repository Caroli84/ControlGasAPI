package controlGas.dao;

import controlGas.model.Comptador;
import controlGas.model.Lectura;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LecturaRepository extends CrudRepository<Lectura, Long> {
    Optional<Lectura> findById(Long id); //tiene metodos ispresent() lo guardo en variable boolean
    //Lectura findById(ID);
    List<Lectura> findAll();
    void deleteById(Long id);
    List<Lectura> findByComptadorAndDataGreaterThan(Comptador comptador, Date data);


}
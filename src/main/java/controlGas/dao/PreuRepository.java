package controlGas.dao;

import controlGas.model.Client;
import controlGas.model.Preu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PreuRepository extends CrudRepository<Preu, Long> {
    Optional<Preu> findById(Long id);
    List<Preu> findAll();
    void deleteById(Long id);
    List<Preu> findByIniciGreaterThanAndFiLessThan(Double consum, Double consumm);

}

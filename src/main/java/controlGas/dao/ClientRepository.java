package controlGas.dao;

import controlGas.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findById(Long id); //tiene metodos ispresent() lo guardo en variable boolean
    //Client findByName(String name);
    List<Client> findAll();
    void deleteById(Long id);

}

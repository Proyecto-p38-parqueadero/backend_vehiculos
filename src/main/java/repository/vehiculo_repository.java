package repository;

import  models.vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface vehiculo_repository extends MongoRepository {

    Optional<Object> findBy(String placa);
}

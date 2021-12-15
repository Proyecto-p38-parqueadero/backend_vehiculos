package com.misiontic.vehiculo_ms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.misiontic.vehiculo_ms.models.vehiculo;

import java.util.List;
import java.util.Optional;

public interface vehiculo_repository extends MongoRepository<vehiculo,String> {

    List<vehiculo> findByplaca(String placa);

}

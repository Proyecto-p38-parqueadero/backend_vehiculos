package com.misiontic.vehiculo_ms.controller;
import com.misiontic.vehiculo_ms.exceptions.ExepcionNotFound;
import com.misiontic.vehiculo_ms.models.vehiculo;
import com.misiontic.vehiculo_ms.repository.vehiculo_repository;
import org.springframework.web.bind.annotation.*;

@RestController

public class vehiculo_controller {

    private final vehiculo_repository Vehiculo_repository;
    public vehiculo_controller(vehiculo_repository Vehiculo_repository ){
        this.Vehiculo_repository = Vehiculo_repository;
    }
    @GetMapping("/vehiculo/{placa}")
    vehiculo getvehiculo(@PathVariable String placa){
        return (vehiculo) Vehiculo_repository.findById(placa) .orElseThrow(() -> new ExepcionNotFound( "no se encontro vehiculo"+ placa));

    }
    @PostMapping("/vehiculo")
    vehiculo newvehiculo(@RequestBody vehiculo Vehiculo){
        return (vehiculo) Vehiculo_repository.save(Vehiculo);
    }
}

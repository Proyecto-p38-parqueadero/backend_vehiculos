package controller;
import exceptions.ExepcionNotFound;
import models.vehiculo;
import repository.vehiculo_repository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController

public class vehiculo_controller {

    private final vehiculo_repository Vehiculo_repository;
    public vehiculo_controller(vehiculo_repository Vehiculo_repository ){
        this.Vehiculo_repository = Vehiculo_repository;
    }
    @GetMapping("/vehiculo/{placa}")
    vehiculo getvehiculo(@PathVariable String placa){
        return (vehiculo) Vehiculo_repository.findBy(placa) .orElseThrow(() -> new ExepcionNotFound( "no se encontro vehiculo"+ placa));

    }
    @PostMapping("/vehiculo")
    vehiculo newvehiculo(@RequestBody vehiculo Vehiculo){
        return (vehiculo) Vehiculo_repository.save(Vehiculo);
    }
}

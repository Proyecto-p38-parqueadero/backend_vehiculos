package com.misiontic.vehiculo_ms.controller;
import com.misiontic.vehiculo_ms.exceptions.ExepcionNotFound;
import com.misiontic.vehiculo_ms.models.vehiculo;
import com.misiontic.vehiculo_ms.repository.vehiculo_repository;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController

public class vehiculo_controller {

    private final vehiculo_repository Vehiculo_repository;

    public vehiculo_controller(vehiculo_repository Vehiculo_repository) {
        this.Vehiculo_repository = Vehiculo_repository;


    }

    @GetMapping("/")
    String checkMessage() {
        return "Welcome to vehiculoMS";
    }

    @GetMapping("/vehiculo/{placa}")
    vehiculo getvehiculo(@PathVariable String placa) {
        return (vehiculo) Vehiculo_repository.findById(placa).orElseThrow(() -> new ExepcionNotFound("no se encontro vehiculo" + placa));

    }

    @PostMapping("/vehiculo")
    vehiculo newvehiculo(@RequestBody vehiculo Vehiculo) {
        Vehiculo.setfecha_ingreso(new Date());
        return (vehiculo) Vehiculo_repository.save(Vehiculo);

    }

    @DeleteMapping("/vehiculo/delete/{placa}")
    String deleteVehiculo(@PathVariable String placa) {

        vehiculo Vehiculo = Vehiculo_repository.findById(placa).orElse(null);
        if (Vehiculo == null)
            throw new ExepcionNotFound("el vehiculo no existe");
        Vehiculo_repository.deleteById(placa);
        return "eliminacion ejecutada exitosamente";
    }

    @PutMapping("/vehiculo/update")
    vehiculo updatevehiculo(@RequestBody vehiculo Vehiculoupd) {
        vehiculo Vehiculo = Vehiculo_repository.findById(Vehiculoupd.getplaca()).orElse(null);
        if (Vehiculo == null)
            throw new ExepcionNotFound("el vehiculo no existe");
        Vehiculo.setpropietario(Vehiculoupd.getpropietario());
        return Vehiculo_repository.save(Vehiculo);

    }

    @GetMapping("/vehiculo/all/{placa}")
    List<vehiculo> getallvehiculo(@PathVariable String placa) {
        vehiculo Vehiculo = Vehiculo_repository.findById(placa).orElse(null);
        if (Vehiculo == null) {
            throw new ExepcionNotFound("el vehiculo no existe");

        }
        List<vehiculo> vehiculo = Vehiculo_repository.findAll();
        return vehiculo;

    }
}



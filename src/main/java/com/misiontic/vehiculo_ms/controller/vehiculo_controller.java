package com.misiontic.vehiculo_ms.controller;
import com.misiontic.vehiculo_ms.exceptions.ExepcionNotFound;
import com.misiontic.vehiculo_ms.models.vehiculo;
import com.misiontic.vehiculo_ms.repository.vehiculo_repository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
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

    //@GetMapping("/vehiculo/{placa}")
    //vehiculo getvehiculo(@PathVariable String placa) {
        //return (vehiculo) Vehiculo_repository.findById(placa).orElseThrow(() -> new ExepcionNotFound("no se encontro vehiculo" + placa));

    //}
    @Operation(summary = "Agregar un vehiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehiculo agregrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos",
                    content = @Content)})

    @PostMapping("/vehiculo")
    vehiculo newvehiculo(@RequestBody vehiculo Vehiculo) {
        Vehiculo.setfecha_ingreso(new Date());
        return (vehiculo) Vehiculo_repository.save(Vehiculo);

    }

    @Operation(summary = "Eliminar vehiculo por placa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehiculo eliminado con exito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Vehiculo no encontrado",
                    content = @Content)})

    @DeleteMapping("/vehiculo/delete/{placa}")
    String deleteVehiculo(@PathVariable String placa) {

        vehiculo Vehiculo = Vehiculo_repository.findById(placa).orElse(null);
        if (Vehiculo == null)
            throw new ExepcionNotFound("el vehiculo no existe");
        Vehiculo_repository.deleteById(placa);
        return "eliminacion ejecutada exitosamente";
    }

    @Operation(summary = "Actualizar vehiculo por placa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehiculo actualizado con exito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Vehiculo no encontrado",
                    content = @Content)})

    @PutMapping("/vehiculo/update")
    vehiculo updatevehiculo(@RequestBody vehiculo Vehiculoupd) {
        vehiculo Vehiculo = Vehiculo_repository.findById(Vehiculoupd.getplaca()).orElse(null);
        if (Vehiculo == null)
            throw new ExepcionNotFound("el vehiculo no existe");
        Vehiculo.setpropietario(Vehiculoupd.getpropietario());
        return Vehiculo_repository.save(Vehiculo);

    }
    @Operation(summary = "Consultar vehiculo por placa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehiculo encontrado con exito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Vehiculo no encontrado",
                    content = @Content)})
    @GetMapping("/vehiculo/all/{placa}")
    vehiculo getonevehiculo(@PathVariable String placa) {
        vehiculo Vehiculo = Vehiculo_repository.findById(placa).orElse(null);
        if (Vehiculo == null) {
            throw new ExepcionNotFound("el vehiculo no existe");

        }
        return Vehiculo;

    }
}



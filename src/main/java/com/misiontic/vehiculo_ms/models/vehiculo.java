package com.misiontic.vehiculo_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class vehiculo {

    @Id
    private String placa;
    private Date   fecha_ingreso;
    private String propietario;

    public vehiculo(String placa, Date fecha_ingreso,String propietario){
        this.placa = placa;
        this.fecha_ingreso = fecha_ingreso;
        this.propietario =propietario;
    }


    public String getplaca() {
        return placa;
    }

    public void setplaca(String placa) {
        this.placa = placa;
    }

    public Date getfecha_ingreso() {
        return fecha_ingreso;
    }

    public void setfecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getpropietario() {
        return propietario;
    }

    public void setpropietario(String propietario) {
        this.propietario = propietario;
    }
}

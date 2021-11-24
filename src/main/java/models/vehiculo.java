package models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class vehiculo {

    @Id
    private String placa;
    private Date   fecha_ingreso;
    private String propietario;

    public vehiculo(String placa, Date fecha_ingreso,String propietario){
        this.placa= placa;
        this.fecha_ingreso = fecha_ingreso;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}

package com.los_Turneados.Innova.Soft.modelos;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MovimientoDeDinero")
public class MovimientoDinero {

    @Id
    private String id_transaccion;
    private String monto;
    private String concepto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado usuario;

    public MovimientoDinero() {
    }

    public MovimientoDinero(String id_transaccion, String monto, String concepto, LocalDate fecha, Empleado usuario) {
        this.id_transaccion = id_transaccion;
        this.monto = monto;
        this.concepto = concepto;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public String getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(String id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

}

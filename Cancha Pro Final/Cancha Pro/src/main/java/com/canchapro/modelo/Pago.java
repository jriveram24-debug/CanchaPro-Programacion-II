package com.canchapro.modelo;
import java.time.LocalDateTime;
public class Pago {
    private String codigo,reserva,metodo,observacion,fecha;
    private double monto;
    public Pago(String codigo,String reserva,double monto,String metodo,String observacion,String fecha){
        this.codigo=codigo;this.reserva=reserva;this.monto=monto;this.metodo=metodo;this.observacion=observacion;this.fecha=fecha;
    }
    public Pago(String codigo,String reserva,double monto,String metodo,String observacion){this(codigo,reserva,monto,metodo,observacion,LocalDateTime.now().toString());}
    public String getCodigo(){return codigo;} public String getReserva(){return reserva;}
    public double getMonto(){return monto;} public String getMetodo(){return metodo;}
    public String getObservacion(){return observacion;} public String getFecha(){return fecha;}
}

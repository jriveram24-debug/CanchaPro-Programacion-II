

package com.canchapro.modelo;
import java.time.LocalTime;
import java.time.LocalDate;


public class Reservacion {
    private String codigo; 
    private Cliente cliente; 
    private Cancha cancha;
    private LocalDate fecha; 
    private LocalTime hora;
    private int horas;
    private String estado; 
    
    public Reservacion(String codigo, Cliente cliente, Cancha cancha, LocalDate fecha, LocalTime hora, int horas, String estado){
        
        this.codigo = codigo;
        this.cliente = cliente;
        this.cancha = cancha;
        this.fecha = fecha;
        this.hora = hora;
        this.horas = 1;
        setHoras(horas);
        
        this.estado = "activa";
        setEstado(estado);
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (horas > 0){
        
           this.horas = horas;
             
        } else {
            System.out.println("Error, las horas deben ser mayor a 0");
         }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if(estado.equalsIgnoreCase("activa")||
           estado.equalsIgnoreCase("cancelada")||
           estado.equalsIgnoreCase("finalizada")){
       
            this.estado = estado;
    
        } else{
            System.out.println("ERROR: estado no permitido");
        }
    }
    
    public int CalcularTotal(){
        return cancha.getPrecio() * horas;
    }
    public LocalTime calcularHoraFinal(){
    return hora.plusHours(horas);
    }
    
    public boolean validaHorario(){
    return !hora.isBefore(cancha.getHoraApertura())
            && hora.plusHours(horas).isAfter(hora)
            && !calcularHoraFinal().isAfter(cancha.getHoraCierre());
    }
    public boolean validarFecha(){
        return !fecha.isBefore(LocalDate.now());
    }
    
    public boolean traslapes(Reservacion otra){
        return this.cancha.getCodigo().equals(otra.getCancha().getCodigo())
        && this.fecha.equals(otra.getFecha())
        && this.hora.isBefore(otra.calcularHoraFinal())
        && this.calcularHoraFinal().isAfter(otra.getHora())
                ;}
}




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
    private double servicios = 0;
    private String detalleServicios = "";
    private String fechaCancelacion = "";
    private String motivoCancelacion = "";
    private String operadorCancelacion = ""; 
    
    public Reservacion(String codigo, Cliente cliente, Cancha cancha, LocalDate fecha, LocalTime hora, int horas, String estado){
        
        this.codigo = codigo;
        this.cliente = cliente;
        this.cancha = cancha;
        this.fecha = fecha;
        this.hora = hora;
        this.horas = 1;
        setHoras(horas);
        
        this.estado = "PENDIENTE";
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
        if (estado == null) return;
        String nuevo = estado.toUpperCase();
        if(nuevo.equals("ACTIVA")) nuevo="CONFIRMADA"; // compatibilidad con archivos viejos
        if(nuevo.equals("FINALIZADA") || nuevo.equals("CANCELADA") || nuevo.equals("PENDIENTE") || nuevo.equals("CONFIRMADA") || nuevo.equals("EN_CURSO")) {
            if(this.estado != null && (this.estado.equals("FINALIZADA") || this.estado.equals("CANCELADA")) && !this.estado.equals(nuevo)) return;
            this.estado=nuevo;
        }
    }
    public boolean cambiarEstado(String nuevo) {
        if(nuevo==null)return false;
        nuevo=nuevo.toUpperCase();
        if(estado.equals("CANCELADA")||estado.equals("FINALIZADA"))return false;
        boolean ok=(estado.equals("PENDIENTE")&&(nuevo.equals("CONFIRMADA")||nuevo.equals("CANCELADA")))
            ||(estado.equals("CONFIRMADA")&&(nuevo.equals("EN_CURSO")||nuevo.equals("CANCELADA")))
            ||(estado.equals("EN_CURSO")&&nuevo.equals("FINALIZADA"));
        if(ok)setEstado(nuevo);
        return ok;
    }
    public boolean cancelar(String motivo,String operador) {
        if(motivo==null||motivo.trim().isEmpty()||operador==null||operador.trim().isEmpty())return false;
        if(!cambiarEstado("CANCELADA"))return false;
        fechaCancelacion=java.time.LocalDateTime.now().toString();motivoCancelacion=motivo;operadorCancelacion=operador;return true;
    }
    public double CalcularTotal(){
        int dia=fecha.getDayOfWeek().getValue();
        double tarifa=dia>=6?250:(hora.isBefore(java.time.LocalTime.of(17,0))?150:225);
        return tarifa*horas+servicios;
    }
    public void agregarServicio(String nombre,double precio){
        if(nombre==null||nombre.trim().isEmpty()||!Double.isFinite(precio)||precio<0)throw new IllegalArgumentException("Servicio incorrecto");
        servicios+=precio;
        detalleServicios+=(detalleServicios.isEmpty()?"":" | ")+nombre+" Q"+precio;
    }
    public void cargarServicios(double total,String detalle){servicios=total;detalleServicios=detalle==null?"":detalle;}
    public double getServicios(){return servicios;}
    public String getDetalleServicios(){return detalleServicios;}
    public String getFechaCancelacion(){return fechaCancelacion;}
    public String getMotivoCancelacion(){return motivoCancelacion;}
    public String getOperadorCancelacion(){return operadorCancelacion;}
    public void cargarCancelacion(String fecha,String motivo,String operador){fechaCancelacion=fecha;motivoCancelacion=motivo;operadorCancelacion=operador;}
    public LocalTime calcularHoraFinal(){
    return hora.plusHours(horas);
    }
    
    public boolean validaHorario(){
    return horas > 0 && !hora.isBefore(cancha.getHoraApertura())
            && hora.plusHours(horas).isAfter(hora)
            && !calcularHoraFinal().isAfter(cancha.getHoraCierre());
    }
    public boolean validarFecha(){
        return !fecha.isBefore(LocalDate.now());
    }
    
    
    public boolean traslapes(Reservacion otra) {
        return !this.estado.equalsIgnoreCase("CANCELADA")
            && !otra.getEstado().equalsIgnoreCase("CANCELADA")
            && this.cancha.getCodigo().equalsIgnoreCase(otra.getCancha().getCodigo())
            && this.fecha.equals(otra.getFecha())
            && this.hora.isBefore(otra.calcularHoraFinal())
            && this.calcularHoraFinal().isAfter(otra.getHora());
}

}


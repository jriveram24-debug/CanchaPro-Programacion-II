

package com.canchapro.modelo;


public class Reservacion {
    private String codigo; 
    private Cliente cliente; 
    private Cancha cancha;
    private String fecha; 
    private String hora;
    private int horas;
    private String estado; 
    
    public Reservacion(String codigo, Cliente cliente, Cancha cancha, String fecha, String hora, int horas, String estado){
        
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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
}


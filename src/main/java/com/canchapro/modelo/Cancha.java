
package com.canchapro.modelo;
import java.time.LocalTime;


public class Cancha {
    private String  codigo;
    private String nombre;
    private String tipo;
    private int precio;
    private String estado; 
    private int capacidad;
    private LocalTime HoraApertura;
    private LocalTime HoraCierre;
    
    
    
    public Cancha(String codigo, String nombre, String tipo, int precio, String estado, int capacidad, LocalTime HoraApertura, LocalTime HoraCierre){
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = "Disponible   ";
        setEstado(estado);
        
        this.capacidad = capacidad;
        this.HoraApertura = HoraApertura;
        this.HoraCierre = HoraCierre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado.equalsIgnoreCase("Disponible") ||
            estado.equalsIgnoreCase("Mantenimiento")||
            estado.equalsIgnoreCase("inactiva")){  
        
            this.estado = estado;   
        
    }else {
            System.out.println("Error estado no identificado");
        }
    }
    
    public int getcapacidad() {
        return capacidad; 
    }
    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }
    
    public  LocalTime getHoraApertura(){
        return HoraApertura;
    }
    public void setHoraApertura (LocalTime HoraApertura){
        this.HoraApertura = HoraApertura;
    }
    
    public LocalTime getHoraCierre (){
        return HoraCierre;
    }
    
    public void setHoraCierre(LocalTime HoraCierre){
        this.HoraCierre = HoraCierre;
    }
}

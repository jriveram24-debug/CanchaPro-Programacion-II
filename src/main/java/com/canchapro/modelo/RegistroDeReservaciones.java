
package com.canchapro.modelo;


public class RegistroDeReservaciones {
    private Reservacion[]  reservaciones;
    private int cantidad;
    
    public RegistroDeReservaciones(){
    reservaciones = new Reservacion[20];
    cantidad = 0;
            }
    public void agregarReservaciones(Reservacion Nueva){
    
        if (!Nueva.getCancha().getEstado().equalsIgnoreCase("Disponible")){
            System.out.println("La cancha no esta disponible");
            return;
            
    }
    if (!Nueva.validarFecha()){
        System.out.println("La fecha de reservacion no es valida");
        return;
    }
    
    if (!Nueva.validaHorario()){
        System.out.println("El horario no es permitido");
        return;
    }
    
    for(int i = 0; i<cantidad; i++){
        if(Nueva.traslapes(reservaciones[i])){
            System.out.println("Error: ya existe la reserva en el horario requerido");
        return;
        }
    }
    
        if(cantidad < reservaciones.length){
        reservaciones[cantidad] = Nueva;
        cantidad++;
        System.out.println("Reservacion Resgistrada correctamente");
    
        }else{
        System.out.println("NO HAY ESPACIOS PARA MAS RESERVACIONES");
    }
    
    }
    
}

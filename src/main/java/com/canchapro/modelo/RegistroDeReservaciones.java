
package com.canchapro.modelo;


public class RegistroDeReservaciones {
    private Reservacion[]  reservaciones;
    private int cantidad;
    
    public RegistroDeReservaciones(){
    reservaciones = new Reservacion[20];
    cantidad = 0;
            }
    public void agregarReservaciones(Reservacion Nueva){
    if(cantidad < reservaciones.length){
        reservaciones[cantidad] = Nueva;
        cantidad++;
        System.out.println("Reservacion Resgistrada correctamente");
    }else{
        System.out.println("NO HAY ESPACIOS PARA MAS RESERVACIONES");
    }
            }
}

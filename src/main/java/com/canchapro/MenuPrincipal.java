
package com.canchapro;
import com.canchapro.modelo.Cancha;
import com.canchapro.modelo.Cliente;
import com.canchapro.modelo.Reservacion;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.Month;

public class MenuPrincipal {
    public void iniciar(){
    System.out.println("Bienvenido a CanchaPro");
        System.out.println("Sistema de Gestion y Reservas Deportivas");
        System.out.println("Proyecto Final - Programacion II");
    
    Cliente cliente1 = new Cliente(
            "julio rivera ",
            "239",
            "923993", 
            "correo", 
            "12 de mayo" );
                       
    
        System.out.println("Nombre: "   +     cliente1.getNombre());
        System.out.println("codigo: "   +     cliente1.getCodigo());
        System.out.println("Telefono: " +     cliente1.getTelefono());    
        System.out.println("Correo: "   +     cliente1.getCorreo());
        System.out.println("Fecha: "    +     cliente1.getFecha());
        
        System.out.println("CANCHA 1 ");   
        
        Cancha Cancha1 = new Cancha(
                "323",
                "Cancha 1",
                "futbol 5",
                150,
                "nueva",
                 10 ,
                LocalTime.of(8, 0),
                LocalTime.of(23, 0));
            
        System.out.println("Codigo: "        + Cancha1.getCodigo());
        System.out.println("Nombre: "        + Cancha1.getNombre());
        System.out.println("TIpo de juego: " + Cancha1.getTipo());
        System.out.println("Precio: "        + Cancha1.getPrecio());
        System.out.println("Estado: "        + Cancha1.getEstado());
        System.out.println("Capacidad: "      + Cancha1.getcapacidad());
        System.out.println("Hora de apertura: " + Cancha1.getHoraApertura());
        System.out.println("Hora de cierre: "   + Cancha1.getHoraCierre());
        
        Reservacion Reservacion1 = new Reservacion(
                "R01",
                cliente1,
                Cancha1,
                LocalDate.of(2026, 10, 21),
                LocalTime.of(19, 0),
                6,
                "activa"
        );
        
        System.out.println("     RESERVACION     ");
        
        System.out.println("Codigo:"  + Reservacion1.getCodigo());
        System.out.println("Nombre:"   + Reservacion1.getCliente().getNombre());
        System.out.println("Cancha:"   + Reservacion1.getCancha().getNombre());
        System.out.println("Fecha:"    + Reservacion1.getFecha());
        System.out.println("Hora:"     + Reservacion1.getHora());
        
        System.out.println("Horas:"    + Reservacion1.getHoras());
        System.out.println("Hora final: " + Reservacion1.calcularHoraFinal());
        System.out.println("Horario valido: " + Reservacion1.validaHorario());
        
        System.out.println("Estado:"   + Reservacion1.getEstado());
        
        
        Reservacion1.setEstado("Cancelada");
        Reservacion1.setEstado("pendiente");
        System.out.println("Estado final: "  + Reservacion1.getEstado());
        
        
        System.out.println("TOTAL: "   + Reservacion1.CalcularTotal());
    }
    
    
    
    
    
    }


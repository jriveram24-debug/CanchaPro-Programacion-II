
package com.canchapro.modelo;


public class RegistroDeReservaciones {
    private Reservacion[]  reservaciones;
    private int cantidad;
    
    public RegistroDeReservaciones(){
    reservaciones = new Reservacion[20];
    cantidad = 0;
            }
    public boolean agregarReservaciones(Reservacion Nueva){
        if(Nueva==null||Nueva.getCliente()==null||Nueva.getCancha()==null)return false;
        for(int j=0;j<cantidad;j++)if(reservaciones[j].getCodigo().equalsIgnoreCase(Nueva.getCodigo()))return false;
    
        if (!Nueva.getCancha().getEstado().equalsIgnoreCase("Disponible")){
            System.out.println("La cancha no esta disponible");
            return false;
            
    }
    if (!Nueva.validarFecha()){
        System.out.println("La fecha de reservacion no es valida");
        return false;
    }
    
    if (!Nueva.validaHorario()){
        System.out.println("El horario no es permitido");
        return false;
    }
    
    for(int i = 0; i<cantidad; i++){
        if(Nueva.traslapes(reservaciones[i])){
            System.out.println("Error: ya existe la reserva en el horario requerido");
        return false;
        }
    }
    
        if(cantidad < reservaciones.length){
        reservaciones[cantidad] = Nueva;
        cantidad++;
        
        guardarReservaciones();
        
        System.out.println("Reservacion Resgistrada correctamente");
        return true;
    
        }else{
        System.out.println("NO HAY ESPACIOS PARA MAS RESERVACIONES");
        return false;
    }
    
    }
    public int getCantidad() {
    return cantidad;
}

    public Reservacion getReservacion(int posicion) {
    if (posicion >= 0 && posicion < cantidad) {
        return reservaciones[posicion];
    }
    return null;
}
    
    
public void guardarReservaciones() {
    try (java.io.PrintWriter archivo =
            new java.io.PrintWriter(new java.io.FileWriter("reservaciones.txt"))) {

        for (int i = 0; i < cantidad; i++) {
            Reservacion r = reservaciones[i];

            archivo.println(
                r.getCodigo() + ";" +
                r.getCliente().getCodigo() + ";" +
                r.getCancha().getCodigo() + ";" +
                r.getFecha() + ";" +
                r.getHora() + ";" +
                r.getHoras() + ";" +
                r.getEstado() + ";" + r.getServicios() + ";" + r.getDetalleServicios().replace(";", " ") + ";" + r.getFechaCancelacion() + ";" + r.getMotivoCancelacion().replace(";", " ") + ";" + r.getOperadorCancelacion().replace(";", " ")
            );
        }

        System.out.println("Reservaciones guardadas correctamente");

    } catch (java.io.IOException e) {
        System.out.println("Error al guardar reservaciones: " + e.getMessage());
    }
}
        public void cargarReservaciones(
        RegistroDeClientes registroClientes,
        RegistroDeCanchas registroCanchas) {

        java.io.File archivo = new java.io.File("reservaciones.txt");

        if (!archivo.exists()) {
            return;
    }

        cantidad = 0;

        try (java.util.Scanner lector = new java.util.Scanner(archivo)) {

            while (lector.hasNextLine() && cantidad < reservaciones.length) {

                String linea = lector.nextLine();
                String[] datos = linea.split(";",-1);

            if (datos.length != 7 && datos.length != 12) {
                continue;
            }

            Cliente cliente = null;
            Cancha cancha = null;

            for (int i = 0; i < registroClientes.getCantidad(); i++) {
                Cliente c = registroClientes.getCliente(i);

                if (c.getCodigo().equalsIgnoreCase(datos[1])) {
                    cliente = c;
                    break;
                }
            }

            for (int i = 0; i < registroCanchas.getCantidad(); i++) {
                Cancha c = registroCanchas.getCancha(i);

                if (c.getCodigo().equalsIgnoreCase(datos[2])) {
                    cancha = c;
                    break;
                }
            }

            if (cliente == null || cancha == null) {
                System.out.println("No se pudo recuperar la reservacion: " + datos[0]);
                continue;
            }

            try {
                Reservacion reserva = new Reservacion(
                    datos[0],
                    cliente,
                    cancha,
                    java.time.LocalDate.parse(datos[3]),
                    java.time.LocalTime.parse(datos[4]),
                    Integer.parseInt(datos[5]),
                    datos[6]
                );

                if(datos.length==12){
                    reserva.cargarServicios(Double.parseDouble(datos[7]),datos[8]);
                    reserva.cargarCancelacion(datos[9],datos[10],datos[11]);
                }
                if(reserva.getHoras()<=0||!reserva.validaHorario())throw new IllegalArgumentException("Horario inválido");
                reservaciones[cantidad] = reserva;
                cantidad++;

            } catch (RuntimeException e) {
                System.out.println("Reservacion invalida: " + datos[0]);
            }
        }

        System.out.println("Reservaciones cargadas: " + cantidad);

    } catch (java.io.IOException e) {
        System.out.println("Error al cargar reservaciones: " + e.getMessage());
    }
}
        

}

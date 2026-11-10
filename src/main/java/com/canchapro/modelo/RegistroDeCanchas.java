
package com.canchapro.modelo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalTime;

public class RegistroDeCanchas {
    

    private Cancha[] canchas = new Cancha[20];
    private int cantidad = 0;

    public boolean agregarCancha(Cancha nueva) {

        if (cantidad >= canchas.length) {
            System.out.println("No hay espacio para más canchas");
            return false;
        }

        for (int i = 0; i < cantidad; i++) {
            if (canchas[i].getCodigo().equalsIgnoreCase(nueva.getCodigo())) {
                System.out.println("Ya existe una cancha con ese código");
                return false;
            }
        }

        canchas[cantidad] = nueva;
        cantidad++;
        
        guardarCanchas();

        System.out.println("Cancha registrada correctamente");
        return true;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Cancha getCancha(int posicion) {
        return canchas[posicion];
    }
    public boolean cambiarEstado(String codigo, String nuevoEstado) {

    for (int i = 0; i < cantidad; i++) {

        if (canchas[i].getCodigo().equalsIgnoreCase(codigo)) {

            canchas[i].setEstado(nuevoEstado);
            guardarCanchas();

            System.out.println("Estado de cancha actualizado");
            return true;
        }
    }

    System.out.println("Cancha no encontrada");
    return false;
}
    ///ARCHIVO - CANCHAS
    public void guardarCanchas() {

    try {
        FileWriter archivo = new FileWriter("canchas.txt");

        for (int i = 0; i < cantidad; i++) {

            Cancha cancha = canchas[i];

            archivo.write(
                cancha.getCodigo() + ";" +
                cancha.getNombre() + ";" +
                cancha.getTipo() + ";" +
                cancha.getPrecio() + ";" +
                cancha.getEstado() + ";" +
                cancha.getCapacidad() + ";" +
                cancha.getHoraApertura() + ";" +
                cancha.getHoraCierre() + "\n"
            );
        }

        archivo.close();

        System.out.println("Canchas guardadas correctamente");

    } catch (IOException e) {
        System.out.println("Error al guardar las canchas");
    }
}
    public void cargarCanchas() {

    File archivo = new File("canchas.txt");

    if (!archivo.exists()) {
        return;
    }

    try {
        Scanner lector = new Scanner(archivo);

        cantidad = 0;

        while (lector.hasNextLine() && cantidad < canchas.length) {

            String linea = lector.nextLine();
            String[] datos = linea.split(";");

            if (datos.length != 8) {
                continue;
            }

            Cancha cancha = new Cancha(
                datos[0],
                datos[1],
                datos[2],
                (int) Double.parseDouble(datos[3]),
                datos[4],
                Integer.parseInt(datos[5]),
                LocalTime.parse(datos[6]),
                LocalTime.parse(datos[7])
            );

            canchas[cantidad] = cancha;
            cantidad++;
        }

        lector.close();

        System.out.println("Canchas cargadas: " + cantidad);

    } catch (FileNotFoundException e) {
        System.out.println("No se encontró el archivo de canchas");
    } catch (IllegalArgumentException e) {
        System.out.println("Error en los datos del archivo de canchas");
    }
}
    
}
    


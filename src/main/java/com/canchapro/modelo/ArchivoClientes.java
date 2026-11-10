    
package com.canchapro.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


public class ArchivoClientes {
    public void guardarCliente(Cliente cliente){
        try (FileWriter archivo = new FileWriter("clientes.txt",true)){
            
            
            archivo.write(cliente.getNombre() + ",");
            archivo.write(cliente.getCodigo() + ",");
            archivo.write(cliente.getTelefono() + ",");
            archivo.write(cliente.getFecha() + ",");
            archivo.write(cliente.getCorreo() + "\n");
            
            
            System.out.println("Cliente guardado en archivos");
        
        }catch (IOException e){
            System.out.println("Error al guardar el cliente: " + e.getMessage());}
        
    }
    public void cargarClientes(RegistroDeClientes registro) {
    try (BufferedReader lector = new BufferedReader(new FileReader("clientes.txt"))) {
        
        String linea;

        while ((linea = lector.readLine()) != null) {
        String[] datos = linea.split(",");
            String nombre = datos[0];
            String codigo = datos[1];
            String telefono = datos[2];
            String fecha = datos[3];
            String correo = datos[4];
            
            Cliente cliente = new Cliente(nombre, codigo, telefono, correo, fecha);
            registro.agregarCliente(cliente);
            
            System.out.println(linea);
        
}
        
    } catch (IOException e) {
        System.out.println("Error al leer clientes: " + e.getMessage());
    }
}
}

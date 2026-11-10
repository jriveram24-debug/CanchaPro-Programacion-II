
package com.canchapro.modelo;


public class RegistroDeClientes {
    private Cliente[] clientes = new Cliente [20];
    private int cantidad = 0;
           
    public boolean agregarCliente(Cliente nuevo) {

    for (int i = 0; i < cantidad; i++) {
        if (clientes[i].getCodigo().equalsIgnoreCase(nuevo.getCodigo())) {
            System.out.println("ERROR: Ya existe un cliente con ese codigo");
            return false;
        }
    }

    if (cantidad < clientes.length) {
        clientes[cantidad] = nuevo;
        cantidad++;
        System.out.println("Cliente guardado correctamente");
        return true;
    } else {
        System.out.println("No hay espacio para mas clientes");
        return false;
    }
}
    public int getCantidad(){
        return cantidad;
        
        
                }
    
    public void listarClientes() {
        
        
        
    for (int i = 0; i < cantidad; i++) {
        System.out.println("Cliente " + (i + 1));
        System.out.println("Nombre: " + clientes[i].getNombre());
        System.out.println("Codigo: " + clientes[i].getCodigo());
        System.out.println("---------------------");
    }
    
    }
    public Cliente buscarPorTelefono(String telefono) {
    for (int i = 0; i < cantidad; i++) {
        if (clientes[i].getTelefono().equals(telefono)) {
            return clientes[i];
        }
    }
    return null;
}
}
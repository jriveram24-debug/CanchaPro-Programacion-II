
package com.canchapro.modelo;


public class Tienda {
    private String nombre;
    private boolean activa;
    
    private Productos[] productos;
    private int cantidadProductos;
    
    public Tienda(String nombre){
    this.nombre = nombre;
    this.activa = false;
    this.productos = new Productos[20];
    this.cantidadProductos = 0;
    
    }
    
    public void activarTienda(){
    activa  = true;
        System.out.println("MODULO DE TIENDA ACTIVADO CORRECTAMENTE");
    }
    
    public void cancelarTienda(){
    activa = false;
        System.out.println("EL MODULO DE TIENDA ESTA DESACTIVADA");
    }
    public boolean isACtiva(){
    return activa;
    }
    
    
    
    public void agregarProducto(Productos nuevo){
        
        
        if (buscarProducto(nuevo.getCodigo()) != null) {
            System.out.println("Ya existe un producto con ese codigo");
            return;
}
        
        if (cantidadProductos >= productos.length){
            System.out.println("La tienda esta llena");
            return;
        }
        
        productos[cantidadProductos] = nuevo;
        cantidadProductos++;
        
        System.out.println("Producto Agregado");
}
    public Productos buscarProducto(String codigo) {
        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getCodigo().equalsIgnoreCase(codigo)) {
            return productos[i];
        }
    }

    return null;
}
    
    
    public boolean realizarVenta(String codigo, int cantidad) {

        if (!activa) {
        System.out.println("La tienda esta desactivada");
        return false;
    }

    Productos producto = buscarProducto(codigo);

        if (producto == null) {
        System.out.println("Producto no encontrado");
        return false;
    }

    return producto.venderProduct(cantidad);
}
    
    
} 

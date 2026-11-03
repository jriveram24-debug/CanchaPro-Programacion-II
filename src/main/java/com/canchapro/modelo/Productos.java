
package com.canchapro.modelo;


public class Productos {
    private String nombre;
    private String codigo;
    private double precio; 
    private int stock;
    private String categoria;
    private int stockmin;
    
    public Productos(String nombre, String codigo, double precio, int stock, String categoria, int stockmin){
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.stockmin = stockmin;
        
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStockmin() {
        return stockmin;
    }

    public void setStockmin(int stockmin) {
        this.stockmin = stockmin;
    }

    public boolean necesitaReposicion() {
    return stock <= stockmin;
}
    
    public boolean venderProduct(int cantidad){
     if (cantidad <= 0 || cantidad > stock){
         System.out.println("No valida o insuficiente producto");
        return false;
     }
     stock = stock - cantidad;
        System.out.println("venta realizada correctamente");
        return true;

    }
}
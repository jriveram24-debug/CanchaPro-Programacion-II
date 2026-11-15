/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.canchapro.modelo;

/**
 *
 * @author Julio Rivera
 */
public class Cliente {
    private String nombre;
    private String codigo;
    private String telefono;
    private String correo;
    private String fecha;
    
    
    
public Cliente(String nombre, String codigo, String telefono, String correo, String fecha){
    this.nombre = nombre;
    this.codigo = codigo; 
    this.telefono = telefono;
    this.correo = correo;
    this.fecha = fecha;
    
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}

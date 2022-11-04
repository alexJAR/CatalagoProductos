package com.softtek.example.model;


public class Producto {
    
    private String nombre;
    //private String categoria; //Eliminar
    private double precio;
    private int codigo;
    private int id;

    public Producto(String nombre, double precio, int codigo, int id) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto" + "nombre=" + nombre + ", precio=" + precio + ", codigo=" + codigo +"id: "+getId();
    }
    
    
}

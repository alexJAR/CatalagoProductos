package com.softtek.example.model;

public class Periferico extends Producto{
    protected String color;
    private CategoriaPeriferico categoria;

    public Periferico(String nombre, double precio, int codigo, int id, String color, CategoriaPeriferico categoria) {
        super(nombre, precio, codigo, id);
        this.color = color;
        this.categoria = categoria;
    }

    public String getColor() {
        return color;
    }

    public CategoriaPeriferico getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "ID: "+getId()+"\nPeriferico: "+getNombre() +"\nPrecio: "+getPrecio()+ "\nColor: " + 
                color +"\nCodigo: "+getCodigo()+"\nCategoria del producto: "+categoria.getNombre();
    }
    
}

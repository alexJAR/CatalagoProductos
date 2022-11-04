package com.softtek.example.model;


public class Consola extends Producto {
    //Agregar atributo objetoconsola
    protected String compañia;
    protected String capacidad;
    private CategoriaConsola categoria;

    public Consola(String nombre, double precio, int codigo,int id, String compañia, String capacidad, CategoriaConsola categoria) {
        super(nombre, precio, codigo, id);
        this.compañia = compañia;
        this.capacidad = capacidad;
        this.categoria = categoria;
    }

    public String getCompañia() {
        return compañia;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public CategoriaConsola getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "ID: "+getId()+"\nNombre: "+getNombre() + "\nPrecio: "+getPrecio()+"\nCompañia: "+ compañia + "\nCapacidad: " + 
                capacidad +"\nCodigo: "+getCodigo()+ "\nCategoria del producto: "+categoria.getNombre();
    }

    
    
}

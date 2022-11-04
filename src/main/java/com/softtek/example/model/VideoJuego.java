package com.softtek.example.model;

public class VideoJuego extends Producto{
    
    protected String tipo;
    protected String clasificacion;
    private CategoriaVJ categoria;

    public VideoJuego(String nombre, double precio, int codigo, int id, String tipo, String clasificacion, CategoriaVJ categoria) {
        super(nombre, precio, codigo, id);
        this.tipo = tipo;
        this.clasificacion = clasificacion;
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public CategoriaVJ getCategoria() {
        return categoria;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setCategoria(CategoriaVJ categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ID: "+getId()+"\nVideojuego: "+getNombre() + "\nCategoria de videojuego: " + tipo +"\nPrecio: "+getPrecio()+ "\nClasificacion: "
                + clasificacion + "\nCodigo: "+getCodigo()+"\nCategoria del producto: "+categoria.getNombre();
    }
}

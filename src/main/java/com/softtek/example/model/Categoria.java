package com.softtek.example.model;


public class Categoria {
    
    private String nombre;
    private VideoJuego listaVideoJuego[] = new VideoJuego[5];
    private int numJuego = 0;
    private Consola listaConsola[] = new Consola[5];
    private int numConsola = 0;
    private Periferico listaPeriferico[] = new Periferico[5];
    private int numPeriferico = 0;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    
    public Categoria(String nombre, VideoJuego v[]) {
        this.nombre = nombre;
        listaVideoJuego = v;
        numJuego = v.length;
    }
    public Categoria(String nombre, Consola c[]) {
        this.nombre = nombre;
        listaConsola = c;
        numConsola = c.length;
    }
    public Categoria(String nombre, Periferico p[]) {
        this.nombre = nombre;
        listaPeriferico = p;
        numPeriferico = p.length;
    }
    
    public void insertarVideoJuego(VideoJuego v){
        listaVideoJuego[numJuego] = v;
        numJuego++;
    }
    
    public void insertarConsola(Consola c){
        listaConsola[numConsola] = c;
        numConsola++;
    }
    
    public void insertarPeriferico(Periferico p){
        listaPeriferico[numPeriferico] = p;
        numPeriferico++;
    }

    public VideoJuego[] getListaVideoJuego() {
        return listaVideoJuego;
    }
    
    public String getVideojuego(int i){
        return listaVideoJuego[i].getNombre();
    }
    
    public Consola[] getListaConsola() {
        return listaConsola;
    }
    
    public String getConsola(int i) {
        return listaConsola[i].toString();
    }

    public Periferico[] getListaPeriferico() {
        return listaPeriferico;
    }
    
    public String getPeriferico(int i){
        return listaPeriferico[i].toString();
    }
    
    
}

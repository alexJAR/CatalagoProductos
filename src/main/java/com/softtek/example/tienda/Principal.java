package com.softtek.example.tienda;
/*
    Agregar sub menu a cada menu, agregar opcion para salir y agregar opcion para editar y eliminar a cada submenu y agregar
    validaciones.
*/
import com.softtek.example.model.Consola;
import com.softtek.example.model.VideoJuego;
import com.softtek.example.model.Periferico;
import com.softtek.example.model.Categoria;
import com.softtek.example.model.CategoriaConsola;
import com.softtek.example.model.CategoriaPeriferico;
import com.softtek.example.model.CategoriaVJ;
import com.softtek.example.model.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {
    
    public static CategoriaVJ videojuego = new CategoriaVJ(1, "Videojuego");
    public static CategoriaConsola categoriac = new CategoriaConsola(2, "Consola");
    public static CategoriaPeriferico categoriap = new CategoriaPeriferico(3, "Periferico");
    public static int id = 1;
    
    static ArrayList<Producto> producto = new ArrayList<Producto>();
    static Scanner sc = new Scanner(System.in);
       
    public static void main(String[] args) {
        //Agregar producto
        producto.add(new VideoJuego("nfs", 1000, 312, id, "carreras", "todos", videojuego));//1
        id++;
        producto.add(new Periferico("USB", 120, 12, id, "red", categoriap));//2
        id++;
        producto.add(new VideoJuego("cod", 12000, 31, id, "carreras", "+18", videojuego));//3
        id++;
        producto.add(new Consola("XBOX", 12000, 201, id, "Microsoft", "1TB", categoriac));//4
        id++;
        producto.add(new Consola("PS5", 12900, 301, id, "SONY", "1TB", categoriac));//5
        id++;
        producto.add(new Periferico("teclado", 1200, 101, id, "Negro", categoriap));//6
        id++;

        menu();
//        String str1 = "+22";
//        System.out.println(isValidIdentifier(str1));
//        System.out.println(clasificacion());
        
    }
    
     public static boolean isValidIdentifier(String identifier){
 
        // Regex to check valid identifier.
        String regex = "[0-9]";
 
        // Compile the ReGex
        Pattern p = Pattern.compile("^[\\+][0-9]{1,2}");
 
        // If the identifier is empty
        // return false
        if (identifier == null) {
            return false;
        }
 
        // Pattern class contains matcher() method
        // to find matching between given identifier
        // and regular expression.
        Matcher m = p.matcher(identifier);
 
        // Return if the identifier
        // matched the ReGex
        return m.matches();
    }
     
    public static String clasificacion(){
        boolean valido = false;
        String clasificacion = "";
        System.out.println("Clasificación ej: todos, +8, +12, +18... ");
        do {            
            System.out.print("Ingrese la clasifiación: ");
            clasificacion = sc.nextLine();
//            sc.nextLine();
            clasificacion = clasificacion.toUpperCase();
            if (clasificacion.equals("todos") || clasificacion.equals("TODOS")) {
                valido = true;
            }
            else if(isValidIdentifier(clasificacion)){
                valido = true;
            }
            else{
                System.out.println("Error, ingrese una clasificación valida");
            }
        } while (!valido);
        
        return clasificacion;
    }
    
    public static void menu(){
        int opcion;
        char resp;
        boolean exit = false;
        do{
                           
            System.out.println("Selecciones una opción:");
            System.out.println("1.- Videojuegos");
            System.out.println("2.- Consolas");
            System.out.println("3.- Perifericos");
            System.out.println("4.- Mostrar todos los productos");
            System.out.println("5.- Salir");
            System.out.print("opción:");
            
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            
                switch(opcion){
                    case 1: menuVideojuegos(); //Agregar videojuego
                        break;
                    case 2: menuConsolas(); //Agregar consola
                        break;
                    case 3: menuPerifericos();//Agregar periferico
                        break;
                    case 4: mostrarProductos(); //Muestra todos los productos
                        break;
                    case 5:
                        exit=true;
                        break;
                    default: 
                        System.out.println("Opcion incorrecta, por favor seleccione una opción valida");
                }
            }catch (Exception e) {
                System.out.println("Opción invalida, debe ingresar solo numeros");
                sc.next();
            }
            
//            System.out.println("\nDesea realizar otra opción? (s/n): ");
//            resp = sc.next().charAt(0);
//            System.out.println("");
        } while(!exit);
//        while(resp=='s' || resp=='S');
    }
    
    public static void menuVideojuegos(){
        int opcion;
        char resp;
        boolean exit = false;
        do {                            
            System.out.println("Seleccione una opción");
            System.out.println("1.-Agregar videojuego");
            System.out.println("2.-Editar videojuego");
            System.out.println("3.-Eliminar videojuego");
            System.out.println("4.-Mostrar todos los videojuegos");
            System.out.println("5.-Regresar");
            System.out.print("Opción: ");
                
            try {
                
             
                opcion = sc.nextInt();
                sc.nextLine();
                switch(opcion){
                    case 1:agregarVideojuego();
                        break;
                    case 2:
                        int aux;
                        System.out.print("Ingrese el id del videojuego que desea editar");
                        aux = validarNumero();
                        editarVideojuego(aux);
                        break;
                    case 3:
                        int num;
                        System.out.print("Ingrese el id del videojuego que desea eliminar: ");
                        num = validarNumero();
                        eliminarVideojuego(num);
                        break;
                    case 4: mostrarJuegos();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción invalida");
                }
            }catch (InputMismatchException e) {
                    System.out.println("Opcion invalida, debe ingresar un numero");
                    sc.next();
            }
//            System.out.println("\nDesea realizar otra opción? (s/n): ");
//            resp = sc.next().charAt(0);
//            System.out.println("");
        } while (!exit);
//        while (resp=='s' || resp=='S');
    }
    
    public static void menuConsolas(){
        int opcion;
        char resp;
        boolean exit = false;
        do {                         
            System.out.println("Seleccione una opción");
            System.out.println("1.-Agregar consola");
            System.out.println("2.-Editar consola");
            System.out.println("3.-Eliminar consola");
            System.out.println("4.-Mostrar todas las consolas");
            System.out.println("5.-Regresar");
            System.out.print("Opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch(opcion){
                    case 1:agregarConsola();
                        break;
                    case 2:
                        int nume;
                        System.out.print("Ingrese el ID de la Consola que desea editar: ");
                        nume = validarNumero();
                        editarConsola(nume);
                        break;
                    case 3:
                        int numel;
                        System.out.print("Ingrese el ID de la consola que desea eliminar: ");
                        numel = validarNumero();
                        eliminarConsola(numel);
                        break;
                    case 4: mostrarConsolas();
                        break;
                    case 5:
                        exit=true;
                        break;
                    default:
                        System.out.println("Opción invalida, seleccione una opción valida");
                }
            }catch (InputMismatchException e) {
                    System.out.println("Opcion invalida, debe ingresar un numero");
                    sc.next();
            }
//            System.out.println("\nDesea realizar otra opción? (s/n): ");
//            resp = sc.next().charAt(0);
//            System.out.println("");
        }while(!exit); 
//        while (resp=='s' || resp=='S');
    }
    public static void menuPerifericos(){
        int opcion;
        char resp;
        boolean exit = false;
        do {                           
            System.out.println("Seleccione una opción");
            System.out.println("1.-Agregar periferico");
            System.out.println("2.-Editar periferico");
            System.out.println("3.-Eliminar periferico");
            System.out.println("4.-Mostrar todos los perifericos");
            System.out.println("5.-Regresar");
            System.out.print("Opción: ");
            try {
                
                opcion = sc.nextInt();
                sc.nextLine();
                switch(opcion){
                    case 1:agregarPeriferico();
                        break;
                    case 2:
                        int nump;
                        System.out.print("Ingrese el ID del periferico que desea editar: ");
                        nump = validarNumero();
                        editarPeriferico(nump);
                        break;
                    case 3:
                        int numpe;
                        System.out.print("Ingrese el ID del periferico que desea eliminar: ");
                        numpe = validarNumero();
                        eliminarPeriferico(numpe);
                        break;
                    case 4: mostrarPerifericos();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.print("Opción invalida, selecciones una opción valida");
                }
            }catch (InputMismatchException e) {
                    System.out.println("Opcion invalida, debe ingresar un numero");
                    sc.next();
            }
//            System.out.println("\nDesea realizar otra opción? (s/n): ");
//            resp = sc.next().charAt(0);
//            System.out.println("");
        } while(!exit);
//        while (resp=='s' || resp=='S');
    }
    
    public static void agregarVideojuego(){
        String nombre, tipo, clasificacion;
        int codigo;
        double precio;
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Precio: ");
        precio= validarDouble();
        sc.nextLine();
        System.out.print("Categoria del juego: ");
        tipo = sc.nextLine();
//        System.out.print("Clasificacion: ");
        clasificacion = clasificacion();
        System.out.print("Codigo del producto: ");
        codigo = validarNumero();
        sc.nextLine();
        
        VideoJuego juego = new VideoJuego(nombre, precio, codigo, id, tipo, clasificacion, videojuego);
        //Guarda el juego en el arreglo productos e incrementamos contador id
        id++;
        producto.add(juego);
        
    }
    
    public static void eliminarVideojuego(int num){
        int aux = num - 1;
        if(producto.get(aux) instanceof VideoJuego){
            VideoJuego v = (VideoJuego) producto.get(aux);
            System.out.println("El videojuego "+v.getNombre()+" fue eliminado.");
            producto.remove(aux);
        }else{
            System.out.println("Error, ingrese el ID de un videojuego");
        }
    }
    
    public static void editarVideojuego(int num){
        //VideoJuego vj = (VideoJuego) producto.get(num);
        String nombre, tipo, clasificacion;
        int codigo, aux;
        double precio;
        aux = num - 1;
        sc.nextLine();
        if(producto.get(aux) instanceof VideoJuego){
            VideoJuego vj = (VideoJuego) producto.get(aux);
            System.out.print("Nombre anterior: "+vj.getNombre()+"\nNuevo nombre: ");
            nombre = sc.nextLine();
            System.out.print("Precio anterior: "+vj.getPrecio()+"\nNuevo precio: ");
            precio= validarDouble();
            sc.nextLine();
            System.out.print("Categoria anterior del juego: "+vj.getTipo());
            tipo = sc.nextLine();
            System.out.print("Clasificacion anterior: "+vj.getClasificacion()+"\nClasificacion nueva: ");
            clasificacion = clasificacion();
            System.out.print("Codigo anterior del producto: "+vj.getCodigo()+"\nNuevo codigo del juego: ");
            codigo = validarNumero();
            sc.nextLine();
            VideoJuego vj2 = new VideoJuego(nombre, precio, codigo, num, tipo, clasificacion, videojuego);
            //Coloca los nuevos valores en la misma posicion del objeto que se selecciono
            producto.set(aux, vj2);
        }else{
            System.out.println("Error, ingrese el ID de un videojuego");
        }
    }
    
    public static void agregarConsola(){
        String nombre, compañia, capacidad;
        double precio;
        int codigo;
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Precio: ");
        precio = validarDouble();
        sc.nextLine();
        System.out.print("Compañia: ");
        compañia = sc.nextLine();
        System.out.print("Capacidad: ");
        capacidad = sc.nextLine();
        System.out.print("Codigo: ");
        codigo = validarNumero();
        sc.nextLine();
        
        Consola consola = new Consola(nombre, precio, codigo, id, compañia, capacidad, categoriac);
        
        //Guarda la consola en el arreglo productos
        id++;
        producto.add(consola);
    }
    public static void eliminarConsola(int num){
        int aux = num - 1;
        if(producto.get(aux) instanceof Consola){
            Consola con = (Consola) producto.get(aux);
            System.out.println("La consola "+con.getNombre()+" fue eliminada.");
            producto.remove(aux);
        }else{
            System.out.println("Error, ingrese el ID de una consola");
        }
    }
    
    public static void editarConsola(int num){
        String nombre, compañia, capacidad;
        double precio;
        int codigo, aux;
        aux = num - 1;
        sc.nextLine();
        if(producto.get(aux) instanceof Consola){
            Consola con = (Consola) producto.get(aux);
            
            System.out.print("Nombre anterior: "+con.getNombre()+"\nNuevo nombre: ");
            nombre = sc.nextLine();
            System.out.print("Precio anterior: "+con.getPrecio()+"\nNuevo precio: ");
            precio = validarDouble();
            sc.nextLine();
            System.out.print("Compañia anterior: "+con.getCompañia()+"\nCompañia: ");
            compañia = sc.nextLine();
            System.out.print("Capacidad anterior: "+con.getCapacidad()+"\nCapacidad: ");
            capacidad = sc.nextLine();
            System.out.print("Codigo anterior: "+con.getCodigo()+"\nNuevo codigo: ");
            codigo = validarNumero();
            sc.nextLine();
            Consola con2 = new Consola(nombre, precio, codigo, num, compañia, capacidad, categoriac);
            //Actualia los datos del registro
            producto.set(aux, con2);
        }else{
            System.out.println("Error, debe ingresar el ID de una consola");
        }
        
    }
    
    public static void agregarPeriferico(){
        String nombre, color;
        double precio;
        int codigo;
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Precio: ");
        precio = validarDouble();
        sc.nextLine();
        System.out.print("Color: ");
        color = sc.nextLine();
        System.out.print("Codigo: ");
        codigo = validarNumero();
        sc.nextLine();
        
        Periferico periferico = new Periferico(nombre, precio, codigo, id, color, categoriap);
        id++;
        producto.add(periferico);
    }
    public static void eliminarPeriferico(int num){
        int aux = num - 1;
        if(producto.get(aux) instanceof Periferico){
            Periferico pf = (Periferico) producto.get(aux);
            System.out.println("El periferico "+pf.getNombre()+" fue eliminado.");
            producto.remove(aux);
        }else{
            System.out.println("Error, ingrese el ID de un periferico");
        }
    }
    
    public static void editarPeriferico(int num){
        String nombre, color;
        double precio;
        int codigo, aux;
        aux = num - 1;
        sc.nextLine();
        if(producto.get(aux) instanceof Periferico){
            Periferico pf = (Periferico) producto.get(aux);
            
            System.out.print("Nombre anterior: "+pf.getNombre()+"\nNuevo nombre: ");
            nombre = sc.nextLine();
            System.out.print("Precio anterior: "+pf.getPrecio()+"\nNuevo precio: ");
            precio = validarDouble();
            sc.nextLine();
            System.out.print("Color anterior: "+pf.getColor()+"\nNuevo color: ");
            color = sc.nextLine();
            System.out.print("Codigo anterior: "+pf.getCodigo()+"\nNuevo codigo: ");
            codigo = validarNumero();
            sc.nextLine();

            Periferico pf2 = new Periferico(nombre, precio, codigo, num, color, categoriap);
            //Edita el periferico anterior
            producto.set(aux, pf2);
            
        }else{
            System.out.println("Error, Debe de ingresar el ID de un periferico");
        }
        
    }
    
    public static void mostrarProductos(){
        
        
        for(Producto prod: producto){
            System.out.println(prod.toString());
            System.out.println("");
        }
    }
    
    public static void mostrarJuegos() {
        ArrayList<Producto> videojuegosArray = new ArrayList<Producto>();
        
        for (int i = 0; i < producto.size(); i++) {
            
            if(producto.get(i) instanceof VideoJuego){
                VideoJuego v = (VideoJuego) producto.get(i);
                videojuegosArray.add(v);
            }
        }
        for(Producto vj: videojuegosArray){
            System.out.println(vj.toString());
            System.out.println("");
        }
    }
    
    public static void mostrarConsolas() {
        ArrayList<Producto> consolasArray = new ArrayList<Producto>();
        
        for (int i = 0; i < producto.size(); i++) {
            
            if(producto.get(i) instanceof Consola){
                Consola c = (Consola) producto.get(i);
                consolasArray.add(c);
            }
        }
        for(Producto con: consolasArray){
            System.out.println(con.toString());
            System.out.println("");
        }
    }
    
    public static void mostrarPerifericos() {
        ArrayList<Producto> perifericoArray = new ArrayList<Producto>();
        
        for (int i = 0; i < producto.size(); i++) {
            
            if(producto.get(i) instanceof Periferico){
                Periferico p = (Periferico) producto.get(i);
                perifericoArray.add(p);
            }
        }
        for(Producto pf: perifericoArray){
            System.out.println(pf.toString());
            System.out.println("");
        }
    }
    
    public static int validarNumero(){
        int num=0;
        boolean isNum = false;
        
        do {            
            try {
                //System.out.println("Ingrese: ");
                num = sc.nextInt();
                isNum = true;
            } catch (Exception e) {
                System.out.print("Error, solo puede ingresar numeros enteros\nIngrese el dato: ");
                sc.nextLine();
            }
        } while (!isNum);
        return num;
    }
    
    public static double validarDouble(){
        double num=0;
        boolean isNum = false;
        
        do {            
            try {
                num = sc.nextDouble();
                isNum = true;
            } catch (Exception e) {
                System.out.print("Error, solo puede ingresar numeros\nIngrese el dato: ");
                sc.nextLine();
            }
        } while (!isNum);
        return num;
    }
    
    
}
      
////      System.out.println(v1.getCategoriaV());
//        System.out.println(c1.getVideojuego(0));
//        System.out.println(Arrays.toString(c1.getListaVideoJuego()));
//        System.out.println("");
//        System.out.println(Arrays.toString(c2.getListaConsola()));
//        System.out.println("");
//        System.out.println(Arrays.toString(c3.getListaPeriferico()));
//  //    System.out.println(c1.getListaVideoJuego().length);
// 
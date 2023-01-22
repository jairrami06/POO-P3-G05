package Utilidad;

import Enums.TipoCliente;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import modelo.Cliente;
import usuario.Usuario;

public class Servicio implements Serializable{
    //atributos de la clase
    private int codigo;
    private String nombre;
    private double precio;
    private static ArrayList<Integer> codigosServicios = new ArrayList();
    private static ArrayList<Servicio> servicios;
    
    //cosntructor por default util para las validaciones
    public Servicio() {
    
    }
    
    //constructores de la clase
    public Servicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = generarCodigo();
    }
    
    public Servicio(int codigo,String nombre, double precio){
        this(nombre, precio);
        this.codigo = codigo;
    }
    
    //metodo para generar un codigo de servicio cuando se agregue un nuevo servicio
    public int generarCodigo(){
        int codigo = codigosServicios.size() + 1;
        codigosServicios.add(codigo);
        return codigo;
    }
    //metodo tostring para el formato
    public String toString(){
        return nombre+"";
    }
    //sobreescritura de equals para las validaciones
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if (obj != null &&  obj instanceof Servicio){
            Servicio other = (Servicio) obj;
            return codigo == other.codigo;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
        return hash;
    }
    //getters y setters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    public double getPrecio() {
        return precio;
    }
    
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public static ArrayList<Servicio> cargarServicios(String ruta) {
        ArrayList<Servicio> serviciosN = new ArrayList<>();
        
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            serviciosN = (ArrayList<Servicio>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return serviciosN;
    }
    
    public static void guardarServiciosS(Servicio s){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Servicios.ser"))){
            servicios.add(s);
            out.writeObject(servicios);
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
    }
    
    
    
    
}
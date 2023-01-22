package Utilidad;

import Enums.TipoVehiculo;
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
import modelo.Proveedor;

public class Orden implements Serializable{
    //atributos de la clase orden donde se usan sus datos y 2 listas importantes para filtrar datos y obtener
    //informes especificos
    private int codOrden;
    private String codigoCliente;
    private String fecha;
    private double total;
    private String nombreCliente;
    private String placa;
    private String tipovehiculo;
    private String tecnico;
    private  ArrayList<Servicio> registroServicio;
    private  ArrayList<Integer> registroCantidades;
    private static ArrayList<Orden> ordenes;
    
    public Orden(){
    
    }
   
    //mconstructor de la clase orden
    public Orden(int codOrden, String codigoCliente, String fecha,String nombreCliente ,double total, String tipovehiculo,String placa, ArrayList<Servicio> registroServicio, ArrayList<Integer> registroCantidades) {
        this.codOrden = codOrden;
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.total = total;
        this.placa = placa;
        this.tipovehiculo = tipovehiculo;
        this.registroServicio = registroServicio;
        this.registroCantidades = registroCantidades;
        
    }
    
    //getters y setters
    public String getFecha() {
        return fecha;
    }
    

    public ArrayList<Servicio> getRegistroServicio() {
        return registroServicio;
    }

    public ArrayList<Integer> getRegistroCantidades() {
        return registroCantidades;
    }

    public String getTecnico() {
        return tecnico;
    }

    public int getCodOrden() {
        return codOrden;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public double getTotal() {
        return total;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public static ArrayList<Orden> getOrdenes() {
        return ordenes;
    }
    
    
    
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    
    public static ArrayList<Orden> cargarOrdenes(String ruta) {
        ArrayList<Orden> ordenes = new ArrayList<>();
        
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            ordenes = (ArrayList<Orden>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return ordenes;
    }
    
    public static void guardarOrdenesS(Orden o){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Ordenes.ser"))){
            ordenes.add(o);
            out.writeObject(ordenes);
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
    }
       
    
}
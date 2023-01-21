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

    
    public static void serializarOrdenes(){
        ordenes = new ArrayList<>();
        ArrayList<Servicio> registroServicios = new ArrayList();
        ArrayList<Integer> registroCant = new ArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader("data/Ordenes.txt"))){
            br.readLine();
            String linea;
            while((linea = br.readLine()) != null){
                registroServicios.clear();
                registroCant.clear();
                String[] sep1 = linea.split(";");
                String[] sep = sep1[0].split(",");
                String[] serv = sep1[1].split(",");
                String[] cant = sep1[2].split(",");
                for(int i=0;i<serv.length;i++){
                    registroServicios.add(Servicio.cargarServicios().get(i));
                    registroCant.add(Integer.valueOf(cant[i]));
                }     
                Orden p = new Orden(Integer.valueOf(sep[0]),sep[1],sep[2],sep[3],Double.valueOf(sep[6]),sep[4],sep[5],registroServicios,registroCant);
                ordenes.add(p);
            }
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/ordenes.ser"))){
            out.writeObject(ordenes);
            out.flush();
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }
    }
    
    
    public static ArrayList<Orden> cargarOrdenes() {
        ArrayList<Orden> ordeness = new ArrayList<>();

       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("data/ordenes.ser"))) {
            ordeness = (ArrayList<Orden>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return ordeness;
    }
    
    
    
    
    
}

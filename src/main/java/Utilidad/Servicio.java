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
    
    public static void serializarServicios(){
        servicios = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("data/Servicios.txt"))){
            br.readLine();
            String linea;
            while((linea = br.readLine()) != null){
                String[] sep = linea.split(",");
                Servicio s = new Servicio(sep[0],Double.valueOf(sep[1]));
                servicios.add(s);
            }
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Servicios.ser"))){
            out.writeObject(servicios);
            out.flush();
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }
    }
    
    public static ArrayList<Servicio> cargarServicios() {
        ArrayList<Servicio> lServicios = new ArrayList<>();
        
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("data/Servicios.ser"))) {
            lServicios = (ArrayList<Servicio>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return lServicios;
    }
    
    
    
}
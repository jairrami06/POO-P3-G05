
package modelo;

import Enums.TipoCliente;
import Enums.TipoVehiculo;
import Utilidad.Vehiculo;
import Utilidad.Orden;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Cliente extends Miembro implements Serializable{
    TipoCliente tipo;
    
    private ArrayList<Orden> ordenesClientes;
    private final ArrayList<Vehiculo> vehiculosCliente = new ArrayList();
    
    //constructor de la clase
    public Cliente(String codigo, String nombre, String direccion, String telefono, TipoCliente tipo) {
        super(codigo, nombre, direccion, telefono);
        this.tipo = tipo;
        ordenesClientes = new ArrayList();
    }
    
    public Cliente(){}
    
    public Cliente(String codigo){
        this.codigo = codigo;
    }
    
    public String toString(){
        return nombre+"";
    }
    
    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
    //getter necesario para obtener la lista de ordenes
    public ArrayList<Orden> getOrdenesClientes() {
        return ordenesClientes;
    }

    public ArrayList<Vehiculo> getVehiculosCliente() {
        return vehiculosCliente;
    }
    
    public Vehiculo guardarVehiculos(Cliente c, TipoVehiculo t, String p){
        Vehiculo v = new Vehiculo(p, t);
        vehiculosCliente.add(v);
        return v;
    }
    
    public static ArrayList<Cliente> cargarClientes(String ruta) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            clientes = (ArrayList<Cliente>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return clientes;
    }
    
    public static void guardarClientesS(Cliente c){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Clientes.ser"))){
            clientes.add(c);
            out.writeObject(clientes);
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
    }
    
    
    
    
}

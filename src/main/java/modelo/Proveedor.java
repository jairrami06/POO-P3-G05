package modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Proveedor extends Miembro{
    //clase proveedor para almacenar una lista de los codigos de proveedores para su reconocimiento y validacion en el codigo
    
    public Proveedor(String cedula, String nombre, String direccion, String telefono) {
        super(cedula, nombre, direccion, telefono);
    }
    
    public static ArrayList<Proveedor> cargarProveedores(String ruta) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            proveedores = (ArrayList<Proveedor>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return proveedores;
    }
    
    public static void guardarProveedoresS(Proveedor p){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Proveedores.ser"))){
            proveedores.add(p);
            out.writeObject(proveedores);
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
    }
    
    
    
    
}

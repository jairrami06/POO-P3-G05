package main;

import Utilidad.Servicio;
import Utilidad.Orden;
import java.util.*;
import modelo.*;
import usuario.*;
import java.io.*;

public class Sistema {
    //atributos de listas estaticas de los objetos que se usaran en todo el codigo para un
    //acceso rapido y conveniente
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Cliente> clientes; 
    public static ArrayList<Proveedor> proveedores;
    public static ArrayList<Servicio> servicios;
    public static ArrayList<Orden>  ordenes;
    public static final String CORREO = "owenyagual@gmail.com";
    
    public static ArrayList<Usuario> cargarUsuarios(){
        usuarios = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\POO-P3-G05-master\\src\\main\\java\\archivos\\Usuarios.txt"))){
                br.readLine();
                String linea;
                while((linea = br.readLine()) != null){
                    String[] sep = linea.split(",");
                    if(sep[3].equals("admin")){
                        Usuario us = new Admin(sep[0],sep[1],sep[2]);
                        usuarios.add(us);
                    }else if(sep[3].equals("tecnico")){
                        Usuario us = new Tecnico(sep[0],sep[1],sep[2]);
                        usuarios.add(us);
                    }else if(sep[3].equals("cobranzas")){
                        Usuario us = new Cobranza(sep[0],sep[1],sep[2]);
                        usuarios.add(us);
                    }
                }
            }catch(FileNotFoundException e1){
                System.out.println(e1);
            }catch(IOException e2){
                System.out.println(e2);
            }catch(Exception e3){
                System.out.println(e3);
            }
        return usuarios; 
    }
    
    //metodo para inicialiazar y cargar los usuarios del sistema por defecto
    public static void inicializarSistema(){
        //por consiguiente se inicializan las listas generales del sistema
        clientes = new ArrayList<>();
        proveedores = new ArrayList<>();
        servicios = new ArrayList<>();
        ordenes = new ArrayList<>();
        //se usa un arraylist para almacenar estos mismos usuarios de la pre carga del sistema
        
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\POO-P3-G05-master\\src\\main\\java\\archivos\\Clientes.txt"))){
            br.readLine();
            String linea;
            while((linea = br.readLine()) != null){
                String[] sep = linea.split(",");
                if(sep[4].equals("Empresarial")){
                    Cliente c = new Cliente(sep[0],sep[1],sep[2],sep[3]);
                    clientes.add(c);
                }else if(sep[3].equals("Personal")){
                    Cliente c = new Cliente(sep[0],sep[1],sep[2],sep[3]);
                    clientes.add(c);
                }
            }
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
        
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\POO-P3-G05-master\\src\\main\\java\\archivos\\Proveedores.txt"))){
            br.readLine();
            String linea;
            while((linea = br.readLine()) != null){
                String[] sep = linea.split(",");
                    Proveedor prov = new Proveedor(sep[0],sep[1],sep[2],sep[3]);
                    proveedores.add(prov);             
            }
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
    }
        //metodo para iniciar sesion de forma general, ya sea que se trate del admin, 
        //los tecnicos o el encargado de cobranza, 
        public static int iniciarSesion(String usuario, String contrasena){
            //con la ayuda de un do-while validamos dentro de si mismo las credenciales
                Usuario validacion = new Admin(usuario,contrasena,"");
                if(usuarios.contains(validacion)){
                    int ind = usuarios.indexOf(validacion);
                    return ind;
                }
                return -1;
    }   
}

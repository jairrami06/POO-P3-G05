package usuario;

import Utilidad.Servicio;
import modelo.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Admin extends Usuario {
    
    Scanner sc = new Scanner(System.in);
    //constructor de la clase
    public Admin(String n_usuario, String contrasena, String nombre) {
        super(n_usuario, contrasena, nombre);
    }
    //metodo para mostrar el menu por pantalla y dar opciones de eleccion al usuario de forma que pueda regresar al mismo menu
    
    
    //primer metodo para administrar clientes el cual recibe una lista de clientes que contiene objetos de tipo cliente
    //de forma que facilite su almacenamiento y accesibilidad a los datos recorriendolos
    
    //este es el metodo especifico para agregar clientes, mismo que recibe la lista de clientes, pide los datos al usuario
    //del nuevo cliente y los añade mediante la instancia de un objeto Cliente
    
    
    //este metodo se realiza de forma similar al de administrar clientes, recibiendo una lista de proveedores para a su vez mostrar
    //por pantalla los existentes y preguntar al usuario si desea agregar uno nuevo o regresar al menu principal
    
    //Igual que para añadir un cliente, este metodo solicita la lista de proveedores y los datos del proveedor nuevo para
    //guardarlos en un objeto de tipo Proveedor y almacenarlos en la lista de proveedores
    
    //en este metodo el cual conlleva la ultima opcion, realiza lo mismo a lo antse descrito, recibir su lista de servicios,
    //imprimirla y consultar si se desea agregar un nuevo servicio, sin embargo este metodo como extra permite editar un servicio
    //existente, ademas de permitir regresar al menu anterior
    
    //en este metodo ya se realiza la accion de agregar servicios, igual que los anteriores recibe su lista de servicios,
    //solicita los datos del nuevo servicio y lo añade
    
    //finalmente en este metodo se realiza la edicion de los servicios existentes, el recibe la lista de servicios, accede a ella,
    //extrae el servicio en especifico que se desea editar con su codigo de identificacion, lo valida y permite al usuario cambiar
    //el precio del mismo
    

}

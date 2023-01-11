package usuario;

import Utilidad.Servicio;
import modelo.*;
import java.util.ArrayList;
import java.util.Scanner;
import main.*;

public class Admin extends Usuario {
    
    Scanner sc = new Scanner(System.in);
    //constructor de la clase
    public Admin(String n_usuario, String contrasena, String nombre) {
        super(n_usuario, contrasena, nombre);
    }
    //metodo para mostrar el menu por pantalla y dar opciones de eleccion al usuario de forma que pueda regresar al mismo menu
    @Override
    public void ingresarMenu() {
        System.out.println("Menú Admin");
        System.out.println("1. Administrar Clientes");
        System.out.println("2. Administrar Proveedores");
        System.out.println("3. Administrar Servicios");
        System.out.println("4. Cerrar sesión");
        int entrada = sc.nextInt();
        sc.nextLine();
        //implementando un switch conseguimos ejecutar las opciones que llaman a metodos especificos
        //y en caso de querer salir, permiten regresar a este menu
        switch (entrada) {
            case 1:
                administrarClientes(Sistema.clientes);
                break;
            case 2:
                administrarProveedores(Sistema.proveedores);
                break;
            case 3:
                administrarServicios(Sistema.servicios);
                break;
            default:
                break;
        }

    }
    //primer metodo para administrar clientes el cual recibe una lista de clientes que contiene objetos de tipo cliente
    //de forma que facilite su almacenamiento y accesibilidad a los datos recorriendolos
    public void administrarClientes(ArrayList<Cliente> listaClientes) {
        if (listaClientes.size() != 0) {
            System.out.println("Cédula o RUC, Nombre, Direccion, Telefono, Tipo de cliente");
        }
        //luego de imprimir el formato, se recorre la lista para mostrar los clientes para mostrar los que
        //existan ya en el sistema
        for (Cliente c : listaClientes) {
            System.out.println(c);
        }
        System.out.println();
        //desde aqui se pregunta lo que se desea realizar, si agregar un nuevo cliente o regresar al menu
        //con ayuda de una validacion
        System.out.println("Seleccione una opcion\n1.Agregar Cliente\n2. Regresar al menú principal");
        int entrada = sc.nextInt();
        sc.nextLine();
        if (entrada == 1) {
            agregarCliente(Sistema.clientes);
        } else if (entrada == 2) {
            ingresarMenu();
        }

    }
    //este es el metodo especifico para agregar clientes, mismo que recibe la lista de clientes, pide los datos al usuario
    //del nuevo cliente y los añade mediante la instancia de un objeto Cliente
    public void agregarCliente(ArrayList<Cliente> listaClientes) {
        System.out.println("Ingrese la cédula del cliente: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        String nombrecliente = sc.nextLine();
        System.out.println("Ingrese la dirección del cliente: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el teléfono del cliente");
        String telefono = sc.nextLine();
        System.out.println("Ingrese el tipo de cliente (1 personal 2 empresarial): ");
        int idTipoCliente = sc.nextInt();
        sc.nextLine();
        if (idTipoCliente == 1) {
            Cliente c = new Personal(cedula, nombrecliente, direccion, telefono);
            listaClientes.add(c);
        } else if (idTipoCliente == 2) {
            Cliente c = new Empresarial(cedula, nombrecliente, direccion, telefono);
            listaClientes.add(c);
        }
        //esta es la forma de permitir regresar al menu anterior, llamando al metodo correspondiente del menu
        administrarClientes(Sistema.clientes);
    }
    //este metodo se realiza de forma similar al de administrar clientes, recibiendo una lista de proveedores para a su vez mostrar
    //por pantalla los existentes y preguntar al usuario si desea agregar uno nuevo o regresar al menu principal
    public void administrarProveedores(ArrayList<Proveedor> listaProveedores) {
        System.out.println("Codigo, Nombre, Direccion, Telefono");
        for (Proveedor c : listaProveedores) {
            System.out.println(c);
        }
        System.out.println();
        System.out.println("Seleccione una opcion\n1.Agregar Proveedor\n2. Regresar al menú principal");
        int entrada = sc.nextInt();
        sc.nextLine();
        if (entrada == 1) {
            agregarProveedor(Sistema.proveedores);
        } else if (entrada == 2) {
            ingresarMenu();
        }

    }
    //Igual que para añadir un cliente, este metodo solicita la lista de proveedores y los datos del proveedor nuevo para
    //guardarlos en un objeto de tipo Proveedor y almacenarlos en la lista de proveedores
    public void agregarProveedor(ArrayList<Proveedor> listaProveedores) {
        System.out.println("Ingrese cédula o RUC del Proveedor: ");
        String codigoprov = sc.nextLine();
        System.out.println("Ingrese el nombre del Proveedor: ");
        String nombreprov = sc.nextLine();
        System.out.println("Ingrese la dirección del Proveedor: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el teléfono del Proveedor");
        String telefono = sc.nextLine();

        Proveedor p = new Proveedor(codigoprov, nombreprov, direccion, telefono);
        listaProveedores.add(p);
        //asi mismo conta su metodo de salida al menu principal al acabar la ejecucion de este metodo
        administrarProveedores(Sistema.proveedores);
    }
    //en este metodo el cual conlleva la ultima opcion, realiza lo mismo a lo antse descrito, recibir su lista de servicios,
    //imprimirla y consultar si se desea agregar un nuevo servicio, sin embargo este metodo como extra permite editar un servicio
    //existente, ademas de permitir regresar al menu anterior
    public void administrarServicios(ArrayList<Servicio> listaServicio) {
        if (listaServicio.size() != 0) {
            System.out.println("Codigo, Nombre, Precio");
        }

        for (Servicio s : listaServicio) {
            System.out.println(s);
        }
        System.out.println();
        //dado que el sistema para agregar servicios es un poco mas complejo, se utiliza un switch para navegar entre las opciones
        //que el cliente necesite, de igual forma denota un codigo mas limpio
        System.out.println("Seleccione una opcion\n1.Agregar Servicio\n2. Editar servicio \n3. Regresar al menú principal");
        int entrada = sc.nextInt();
        sc.nextLine();
        switch (entrada){
            case 1:
                agregarServicio(Sistema.servicios);
                break;
            case 2:
                editarServicio(Sistema.servicios);
                break;
            case 3:
                ingresarMenu();
                break;
            default:
                break;
        }

    }
    //en este metodo ya se realiza la accion de agregar servicios, igual que los anteriores recibe su lista de servicios,
    //solicita los datos del nuevo servicio y lo añade
    public void agregarServicio(ArrayList<Servicio> listaServicios) {
        System.out.println("Ingrese el nombre del servicio: ");
        String nombreserv = sc.nextLine();
        System.out.println("Ingrese el precio del servicio: ");
        double precio = sc.nextDouble();

        Servicio s = new Servicio(nombreserv, precio);
        listaServicios.add(s);

        administrarServicios(Sistema.servicios);
    }
    //finalmente en este metodo se realiza la edicion de los servicios existentes, el recibe la lista de servicios, accede a ella,
    //extrae el servicio en especifico que se desea editar con su codigo de identificacion, lo valida y permite al usuario cambiar
    //el precio del mismo
    public void editarServicio(ArrayList<Servicio> listaServicios) {
        System.out.println("Ingrese el codigo del servicio: ");
        int entrada = sc.nextInt();
        sc.nextLine();

        Servicio x = new Servicio();
        x.setCodigo(entrada);

        if (listaServicios.contains(x)) {
            int ind = listaServicios.indexOf(x);
            System.out.println("Ingrese el nuevo precio: ");
            double nuevoPrecio = sc.nextDouble();
            sc.nextLine();
            listaServicios.get(ind).setPrecio(nuevoPrecio);
        } else {
            System.out.println("El codigo ingresado no esta asociado a ningun servicio");
        }

        administrarServicios(Sistema.servicios);
    }

}


package usuario;
import Utilidad.*;
import Enums.TipoVehiculo;
import modelo.*;

import java.util.*;



public class Tecnico extends Usuario{
    Scanner sc = new Scanner(System.in);
    private ArrayList<Orden> ordenesTecnico;
    private ArrayList<String> borradores;
    
    //este es el constructor d ela clase tecnico
    public Tecnico(String n_usuario, String contrasena, String nombre){
        super(n_usuario,contrasena,nombre);
        ordenesTecnico = new ArrayList();
    }
    //este es el unico getter necesario de esta clase que permite acceder a una lista de ordenes que registro cada tecnico
    public ArrayList<Orden> getOrdenesTecnico() {
        return ordenesTecnico;
    }
    
    
    //en este metodo se sobreescribe el metodo ingresar menu para mostrar las opciones del sistema de los tecnicos y mediante
    //un switch acceder a cada una de estas opciones asi como admitir el regreso a este mismo menu
    //en este metodo se genera la orden del servicio contratado a un tecnico
    
    /*public void genrordenserv(){
        //se utilian dos listas, en la que una se usa para guardar los servicios contratados y en la otra
        //se guarde la cantidad de veces que se ha contratado un servicio en una orden especifica
        ArrayList<Servicio> registroServicios = new ArrayList();
        ArrayList<Integer> registroCantidades = new ArrayList();
    
        registroServicios.clear();
        registroCantidades.clear();
        //se solicita el ingreso del codigo del cliente que contrata los servicios de la empresa y se valida dicha exitencia del codigo
        System.out.println("Ingrese código del cliente: ");
        String codigocliente = sc.nextLine();
        Cliente clienteValidacion = new Cliente(codigocliente,"","","");
        int ind = clientes.indexOf(clienteValidacion);
        //luego de validar el codigo del cliente se guarda la fecha en la que solicito un/varios servicio(s)
        System.out.println("Ingrese fecha servicio (DD-MM-YYYY): ");
        String fechaserv = sc.nextLine();
        System.out.println("Ingrese tipo de vehiculo: ");
        System.out.println("1. Automóvil\n2. Motocicleta\n3. Bus");
        int tipov = sc.nextInt();
        sc.nextLine();
        TipoVehiculo tipo = null;
        //y luego de solicitar el tipo de vehiculo al que desea contratar los servicios, mediante un switch se establece dicho tipo 
        //de vehiculo
        switch (tipov) {
            case 1 :
                tipo = TipoVehiculo.Automovil;
                break;
            case 2:
                tipo = TipoVehiculo.Motocicleta;
                break;
            case 3:
                tipo = TipoVehiculo.Bus;
                break;
            default:
                break;
        }
        
        //se solicita al usuario la placa del vehiculo al cual solicito el/los servicio(s) y se le solicita el codigo de servicio
        //que hace referencia al contratado por el cliente, permitiendo registrar cualquier cantidad de servicios contratables y distintos
        //entre si, de forma que unicamente se pueda parar de registrar servicios con el ingreso del -1
        System.out.println("Ingrese la placa del vehículo: ");
        String placa = sc.nextLine();
        //aqui se utiliza el objeto cliente validado para almacenar en una lista el vehiculo con sus datos que registro
        //para la contratacion de el/los servicio(s)
        Vehiculo v = clienteValidacion.guardarVehiculos(clienteValidacion, tipo, placa);
        int entradaCodigo = 0;
        double total = 0;
        while(entradaCodigo != -1){
            System.out.println("Ingrese codigo del servicio (-1 si no desea continuar ingresando servicios): ");
            entradaCodigo = sc.nextInt();
            sc.nextLine();
            //aqui se valida el codigo del servicio a registrar
            Servicio servicioValidacion = new Servicio();
            servicioValidacion.setCodigo(entradaCodigo);
            //aqui se comprueba que si el servicio existe entonces se toma su valor y se pide la cantidad de veces que se haya
            //contratado dicho servicio para luego almacenarlo
            if(servicios.contains(servicioValidacion)){
                int indServ = servicios.indexOf(servicioValidacion);
                registroServicios.add(servicios.get(indServ));
                System.out.println("Ingrese la cantidad del servicio: ");
                int cantidadServicio = sc.nextInt();
                sc.nextLine();
                registroCantidades.add(cantidadServicio);
                total += servicios.get(indServ).getPrecio() * cantidadServicio;
            }else if(entradaCodigo != -1){
                //aqui se imprime una advertencia sobre el codigo mal escrito en caso de no encontrar una coincidencia
                System.out.println("El codigo ingresado no esta asociado a ningun servicio\n");
            }
        }
        //se procede a imprimir en pantalla el total de lo contratado
        System.out.println("El total a pagar es $"+total+"\n");
        //se instancia un objeto d etipo Orden para guardar la orden generada con todos los datos ingresados y almacenados
        //y finalmente se guarde esta orden en las listas respectivas para su uso en las demas clases necesarias
        Orden ordenGenerada = new Orden(codigocliente, fechaserv, total, v, registroServicios,registroCantidades);
        ordenGenerada.setTecnico(nombre);
        
        clientes.get(ind).getOrdenesClientes().add(ordenGenerada);
        ordenes.add(ordenGenerada);
        ordenesTecnico.add(ordenGenerada);
        
        
    }
    //en este metodo se programa la estructura para reportar los insumos faltantes, donde se pide al usuario tecnico una descricion
    //de lo solicitado para darle la opcion de enviar o no el mensaje en forma de correo, y finalmente mostrar una confirmacion del envio
    //del mensaje o en caso contrario que fue guardado en la lista de mensajes de borradores
    public void reportarFaltaInsumos(){
        System.out.println("Ingrese la descripcion del pedido: ");
        String descripcion = sc.nextLine();
        
        System.out.println("Descripcion guardada.\n¿Desea enviar el correo?\n1. Si\n2. No:");
        int confirmacion = sc.nextInt();
        sc.nextLine();
        
        if(confirmacion == 1){
            System.out.println("Correo Enviado");
        }
        else{
            System.out.println("Guardado en Borradores");
            borradores.add(descripcion);
        }
        
    
    }*/
    
}

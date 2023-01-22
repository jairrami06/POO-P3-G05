package usuario;
import Utilidad.Servicio;
import Utilidad.Orden;

import modelo.*;
import java.util.ArrayList;


public class Cobranza extends Usuario{
    public Cobranza(String n_usuario, String contrasena, String nombre){
        super(n_usuario,contrasena,nombre);
    }
    //aqui se realiza en el metodo ingresarMenu la impresion por pantalla del menu tecnico, y usa similar a las otras clases,
    //un switch para navegar entre las opciones, que permite volver al mismo menu
       
    //en este primer metodo se generan las facturas de los clientes tipo empresarial. Recibe la lista de clientes para extraer
    //y validar el codigo de identificacion del objeto del cliente (que sea de tipo empresarial); ademas, solicita el mes y año
    //del cual se requiere factura y se filtran las ordenes vinculadas a los clientes que coincidan con la fecha, para finalmente
    // mostrar por pantalla los servicios contratados, el detalle de los mismos, el precio de cada uno,y el total final a pagar
    
    
    /*public void generarFactura(ArrayList<Cliente> clientes){
        System.out.println("Ingrese RUC de la empresa");
        String codigoempresa = sc.nextLine();
        System.out.println("Ingrese el mes de facturación (MM): ");
        String mes = sc.nextLine();
        System.out.println("Ingrese el año de facturación (YYYY): ");
        String anio = sc.nextLine();
        //aqui se valida el codigo del cliente de tipo empresarial
        Cliente empresaValidacion = new Cliente(codigoempresa,"","","");
        //dentro de un if, evaluamos la existencia del codigo del cliente
        if(clientes.contains(empresaValidacion)){
            int ind = clientes.indexOf(empresaValidacion);
            Cliente eBuscada = clientes.get(ind);
            //evaluamos que el cliente sea de tipo empresarial
            if(eBuscada instanceof Empresarial){
                System.out.println("Empresa: "+eBuscada.getNombre());
                System.out.println("Periodo de facturacion: "+toStringMeses(mes)+" "+anio);
                System.out.println("Detalle de servicios: ");
                System.out.println("#Placa      Fecha       Tipo        Servicio        Cantidad        Total");
                double totalFactura = 0;     
                //con ayuda de un for, recorremos las ordenes coincidentes con la fecha y cliente, y se imprime en pantalla
                //todo el detalle y valores de pago
                for(Orden o: eBuscada.getOrdenesClientes()){
                    if(mes.equals(o.getFecha().substring(3,5)) && anio.equals(o.getFecha().substring(6))){
                        for(int i = 0; i< o.getRegistroServicio().size();i++){
                            System.out.println(" "+o.getVehiculo().getPlaca() +"         "+o.getFecha().substring(0,5)+"       "+o.getVehiculo().getTipo_vehiculo() +"           "+o.getRegistroServicio().get(i).getNombre()+"                "+o.getRegistroCantidades().get(i)+"                "+o.getRegistroCantidades().get(i)*o.getRegistroServicio().get(i).getPrecio());
                            totalFactura += o.getRegistroCantidades().get(i)*o.getRegistroServicio().get(i).getPrecio();
                        }       
                    }
                }
                //se imprime el total a pagar de todos los servicios
                System.out.println("El total a pagar es de $"+(totalFactura+50));
            }
            else{
                //se imprime una advertencia en caso de que el codigo del cliente no sea de tipo empresarial
                System.out.println("El codigo ingresado no esta asociado a una empresa");
            }
        }
        else{
            //se imprime una advertencia en caso de que el codigo no este registrado en el sistema
            System.out.println("El codigo no esta asociado a ningun cliente");
        }
        //finalmente al terminar la ejecucion del metodo se llama al metodo que nos devuelve al menu principal
      
    }*/

    //en este metodo se reportan los ingresos de todos los servicios contratados en su cantidad total de veces
    //durante un mes y año en concreto
    
    /*public void reportarIngresos(){
        System.out.println("Ingrese el mes de facturación a consultar(MM): ");
        String mes = sc.nextLine();
        System.out.println("Ingrese el año de facturación a consultar(YYYY): ");
        String anio = sc.nextLine();
        System.out.println("Periodo de recaudacion: "+toStringMeses(mes)+" "+anio);
        System.out.println("Servicios               Total");
        //luego de solicitar la fecha de facturacion, se recorre con un for todos los servicios contratados
        for(Servicio s: servicios){
            double v = 0;
            String n = "";
            //para entonces se recorre la lista de ordenes registradas y se valida en conjunto que dichas ordenes
            //contengan servicios contratados en la fecha requerida del reporte
            for(Orden o: ordenes){
                //se compara con un equals la fecha y mediante un objeto referencial de tipo orden se accede a la fecha de cada orden
                //de la lista extrayendo por un lado su mes y por otro eñ año
                if(mes.equals(o.getFecha().substring(3,5)) && anio.equals(o.getFecha().substring(6))){
                    for(Servicio rS: o.getRegistroServicio()){
                        //al coincidir la fecha de contratacion se guarda el nombre de dicho servicio
                        n = rS.getNombre();
                        //y se valida si el nombre de dicho servicio esta registrado en la lista de servicios contratados, de ser asi
                        //se toma tu valor y la cantidad de veces contratado, se multiplica y se guarda para al terminar la iteracion
                        //se imprima dicho valor con su respectivo nombre de servicio
                        if (n.equals(s.getNombre())){
                            int ind = o.getRegistroServicio().indexOf(rS);
                            int cant = o.getRegistroCantidades().get(ind);
                            v += rS.getPrecio()*cant;
                        }
                    }
                }
            }
            System.out.println(s.getNombre()+"              $"+v);
        }
        //aqui se permite regresar al menu principal una vez casi finalizada la ejecucion del metodo
        
    }*/
    //en este metodo de forma similar al anterior, se imprime en pantalla un reporte de todo el saldo recaudado que
    //cada tecnico haya registrado en un mes y año especificos
    
    /*public void reportarIngresosTecnico(){
        System.out.println("Ingrese el mes de facturación a consultar(MM): ");
        String mes = sc.nextLine();
        System.out.println("Ingrese el año de facturación a consultar(YYYY): ");
        String anio = sc.nextLine();
        System.out.println("Periodo de recaudacion: "+toStringMeses(mes)+" "+anio);
        System.out.println("Tecnico               Total");
        //luego de pedir la fecha de consulta al usuario se utiliza la misma estructura del metodo anterior
        //en resumen se recorre la lista de usuarios y validan los que instancian de la clase Tecnico
        for(Usuario u: usuarios){
            if (u instanceof Tecnico){
                Tecnico t = (Tecnico)u;
                String n = "";
                double v = 0;
                //se valida que la lista de ordenes registrada por cada tecnico sea distinta de 0 para permitir mostrarlo en pantalla
                if(t.getOrdenesTecnico().size()!= 0 ){
                    //se recorre la lista de ordenes por cada tecnico y valida la fecha de registro de cada orden para luego recorrer
                    //en un for la lista de servicios registrados por cada tecnico e ir sumando los valores recaudados de la fecha indicada
                    for(Orden o: t.getOrdenesTecnico()){
                        if(mes.equals(o.getFecha().substring(3,5)) && anio.equals(o.getFecha().substring(6))){
                            n = t.getNombre();
                            for(int i = 0 ; i < o.getRegistroServicio(). size() ; i++){
                                v += o.getRegistroServicio().get(i).getPrecio()*o.getRegistroCantidades().get(i);
                            }
                        }
                    }
                    //se imprime el nombre del tecnico y el valor que recaudo en dicho mes
                    System.out.println(n+"              $"+v);
                }
                else{
                    n = t.getNombre();
                    System.out.println(n+"              $"+v);
                }
            }
        }
        //finalmente se llama al metodo para regresar al menu principal
       
    }*/
    //en este metodo similar al tostring, se recibe un numero que el usuario haya ingresado para seleccionar el mes de filtro,
    //unicamente para hacer referencia en un formato de letras a qué mes corresponde dicho numero de mes y devuelve el string del nombre del mes
     public String toStringMeses(String numeroMes){
        switch(numeroMes){
            case "01": 
                return "Enero";
            case "02":
                return "Febrero";
            case "03":
                return "Marzo";
            case "04":
                return "Abril";
            case "05":
                return "Mayo";
            case "06":
                return "Junio";
            case "07":
                return "Julio";
            case "08":
                return "Agosto";
            case "09":
                return "Septiembre";
            case "10":
                return "Octubre";
            case "11":
                return "Noviembre";
            case "12":
                return "Diciembre";
            default:
                return "Mes no existente";
        }
    }
     
}

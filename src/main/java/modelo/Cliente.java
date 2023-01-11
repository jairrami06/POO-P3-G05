
package modelo;

import Enums.TipoVehiculo;
import Utilidad.Vehiculo;
import Utilidad.Orden;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Miembro{
    //atributos de la clase en forma de listas que contendran los codigos de todas sus
    //correlaciones; es decir, las ordenes de cada cliente en par al cliente, asi como
    //una lista de vehiculos que registraron
    private ArrayList<Orden> ordenesClientes;
    private final ArrayList<Vehiculo> vehiculosCliente = new ArrayList();
    //constructor de la clase
    public Cliente(String codigo, String nombre, String direccion, String telefono) {
        super(codigo, nombre, direccion, telefono);
        ordenesClientes = new ArrayList();
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
    
    
    
    
}

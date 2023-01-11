package modelo;

import java.util.ArrayList;

public class Proveedor extends Miembro{
    //clase proveedor para almacenar una lista de los codigos de proveedores para su reconocimiento y validacion en el codigo
    
    public Proveedor(String cedula, String nombre, String direccion, String telefono) {
        super(cedula, nombre, direccion, telefono);
    }
    
}

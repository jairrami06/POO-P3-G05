package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Miembro implements Serializable{
    //atributos de la clase
    protected String codigo;
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected boolean borrado;
    protected static ArrayList<Cliente> clientes;
    protected static ArrayList<Proveedor> proveedores;
    private static final long serialVersionUID = 7511681662295568744L;
    
    //constructores necesarios para guardar los datos asi como validar el miembro
    public Miembro(String codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.borrado = false;
    }
    
    public Miembro(){
        
    }
    // se sobreescribe el equal para validar el codigo de los miembros que si exista
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if (obj != null &&  obj instanceof Miembro){
            Miembro other = (Miembro) obj;
            return codigo.equals(other.codigo);
        }
        return false;
    }
    //el tostring respectivo para dar formato por pantalla
    public String toString(){
        return String.format("%s, %s, %s, %s",codigo,nombre,direccion,telefono);
    }
    //getters y setters 

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

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
    
    
    
    
    
}

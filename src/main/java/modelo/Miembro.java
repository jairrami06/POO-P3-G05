package modelo;

import java.util.ArrayList;

public abstract class Miembro {
    //atributos de la clase
    protected String codigo;
    protected String nombre;
    protected String direccion;
    protected String telefono;
    //constructores necesarios para guardar los datos asi como validar el miembro
    public Miembro(String codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
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
    public String getNombre() {
        return nombre;
    }    
}

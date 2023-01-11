package Utilidad;

import java.util.ArrayList;
import usuario.Usuario;

public class Servicio {
    //atributos de la clase
    private int codigo;
    private String nombre;
    private double precio;
    private static ArrayList<Integer> codigosServicios = new ArrayList();
    
    //cosntructor por default util para las validaciones
    public Servicio() {
    
    }
    
    //constructores de la clase
    public Servicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = generarCodigo();
    }
    
    public Servicio(int codigo,String nombre, double precio){
        this(nombre, precio);
        this.codigo = codigo;
    }
    
    //metodo para generar un codigo de servicio cuando se agregue un nuevo servicio
    public int generarCodigo(){
        int codigo = codigosServicios.size() + 1;
        codigosServicios.add(codigo);
        return codigo;
    }
    //metodo tostring para el formato
    public String toString(){
        return String.format("%s, %s, %s",codigo,nombre,precio);
    }
    //sobreescritura de equals para las validaciones
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if (obj != null &&  obj instanceof Servicio){
            Servicio other = (Servicio) obj;
            return codigo == other.codigo;
        }
        return false;
    }
    //getters y setters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    public double getPrecio() {
        return precio;
    }
    
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
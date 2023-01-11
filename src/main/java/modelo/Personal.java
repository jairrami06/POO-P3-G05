package modelo;


public class Personal extends Cliente{
    //clase personal que hereda de cliente para especificar de quien se trata y tostring necesario para el formato
    public Personal(String cedula, String nombre, String direccion, String telefono) {
        super(cedula, nombre, direccion, telefono);
    }
    
    public String toString(){
        return super.toString()+", Personal";
    }
   
}

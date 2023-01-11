package modelo;


public class Empresarial extends Cliente{
    
    //aqui se implementa el constructor de un cliente empresarial y un tostring necesario
    //para el formato al representarlo en pantalla
    public Empresarial(String ruc, String nombre, String direccion, String telefono) {
        super(ruc, nombre, direccion, telefono);
    }
    
    public String toString(){
        return super.toString()+", Empresarial";
    }
    
}

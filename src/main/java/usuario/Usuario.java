
package usuario;
import java.util.Scanner;

public abstract class Usuario {
    //atributos de la clase Usuario para el almacenamiento de los datos que permiten el ingreso al sistema
    protected String n_usuario;
    protected String contrasena;
    protected String nombre;
    Scanner sc = new Scanner(System.in);
    //constructor de la clase que inicializa los atributos
    public Usuario(String n_usuario, String contrasena, String nombre){
        this.n_usuario = n_usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }
    //este metodo permite siempre la accesibilidad a un menu principal
    public abstract void ingresarMenu();
    
    //getters y setters
    public String getN_usuario(){
        return n_usuario;
    }
    public String getContrasena(){
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }
    //sobreescritura del metodo equals para la validacion de las credenciales
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if (obj != null &&  obj instanceof Usuario){
            Usuario other = (Usuario) obj;
            return n_usuario.equals(other.n_usuario) && contrasena.equals(other.contrasena);
        }
        return false;
    }
}

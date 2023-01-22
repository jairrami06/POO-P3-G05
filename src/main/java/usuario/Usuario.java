
package usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Cliente;


public abstract class Usuario {
    //atributos de la clase Usuario para el almacenamiento de los datos que permiten el ingreso al sistema
    protected String n_usuario;
    protected String contrasena;
    protected String nombre;
    Scanner sc = new Scanner(System.in);
    protected static ArrayList<Usuario> usuarios;
    
    //constructor de la clase que inicializa los atributos
    public Usuario(String n_usuario, String contrasena, String nombre){
        this.n_usuario = n_usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }
    //este metodo permite siempre la accesibilidad a un menu principal
    
    
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
    
    public static ArrayList<Usuario> cargarUsuarios(){
        usuarios = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("data/Usuarios.txt"))){
                br.readLine();
                String linea;
                while((linea = br.readLine()) != null){
                    String[] sep = linea.split(",");
                    if(sep[3].equals("admin")){
                        Usuario us = new Admin(sep[0],sep[1],sep[2]);
                        usuarios.add(us);
                    }else if(sep[3].equals("tecnico")){
                        Usuario us = new Tecnico(sep[0],sep[1],sep[2]);
                        usuarios.add(us);
                    }else if(sep[3].equals("cobranzas")){
                        Usuario us = new Cobranza(sep[0],sep[1],sep[2]);
                        usuarios.add(us);
                    }
                }
            }catch(FileNotFoundException e1){
                System.out.println(e1);
            }catch(IOException e2){
                System.out.println(e2);
            }catch(Exception e3){
                System.out.println(e3);
            }
        return usuarios; 
    }
     public static int iniciarSesion(String usuario, String contrasena){
            //con la ayuda de un do-while validamos dentro de si mismo las credenciales
                Usuario validacion = new Admin(usuario,contrasena,"");
                if(usuarios.contains(validacion)){
                    int ind = usuarios.indexOf(validacion);
                    return ind;
                }
                return -1;
    }   
}

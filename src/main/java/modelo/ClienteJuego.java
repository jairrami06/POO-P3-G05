/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Enums.TipoCliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author jaira
 */
public class ClienteJuego implements Serializable{
    String nombre;
    int aciertos;
    int fallos;
    String tiempojuego;
    String fecha;
    private static ArrayList<ClienteJuego> clientesJuego = new ArrayList();
    
    public ClienteJuego(String nombre, String fecha,String tiempojuego,int aciertos, int fallos){
        this.nombre = nombre;
        this.aciertos = aciertos;
        this.fallos = fallos;
        this.tiempojuego = tiempojuego;
        this.fecha = fecha;
    }

    public ClienteJuego() {
        
    }
    
    public String toString(){
        return nombre+" "+aciertos+" "+fecha+" "+tiempojuego+" "+fallos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getFallos() {
        return fallos;
    }

    public String getTiempojuego() {
        return tiempojuego;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    
    public static ArrayList<ClienteJuego> cargarClientesJuego(String ruta) {
        ArrayList<ClienteJuego> clientesJ = new ArrayList();
        
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            clientesJ = (ArrayList<ClienteJuego>) oi.readObject();
            
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return clientesJ;
    }
    
    public static void guardarClientesJuegoS(ClienteJuego cj){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/ClientesJuego.ser"))){
            clientesJuego.add(cj);
            out.writeObject(clientesJuego);
            
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Enums.TipoCliente;
import java.util.Date;

/**
 *
 * @author jaira
 */
public class ClienteJuego{
    String nombre;
    int aciertos;
    int fallos;
    String tiempojuego;
    Date fecha;
    
    public ClienteJuego(String nombre, Date fecha,String tiempojuego,int aciertos, int fallos){
        this.nombre = nombre;
        this.aciertos = aciertos;
        this.fallos = fallos;
        this.tiempojuego = tiempojuego;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }
    
}

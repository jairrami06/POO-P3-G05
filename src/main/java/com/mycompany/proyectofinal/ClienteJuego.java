/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author oweny
 */
public class ClienteJuego {
    String nombre;
    String fecha;
    String tiempoJuego;
    int aciertos;
    int fallos;

    public ClienteJuego(String nombre, String fecha, String tiempoJuego, int aciertos, int fallos) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.tiempoJuego = tiempoJuego;
        this.aciertos = aciertos;
        this.fallos = fallos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }
    
    
}

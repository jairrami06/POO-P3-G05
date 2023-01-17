/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import static com.mycompany.proyectofinal.MemoriaController.min;
import static com.mycompany.proyectofinal.MemoriaController.seg;
import javafx.scene.control.Label;

/**
 *
 * @author oweny
 */
public class Temporizador extends Thread{
    
    Label lTemp;
    
    public Temporizador(Label lTemp){
        this.lTemp = lTemp; 
    }
    
    public void run(){
        try{
            int x = 0;
            while(MemoriaController.acabo==false){
                Thread.sleep(1000);
                ejecutarHiloTemporizador(x);
                if(MemoriaController.min==0){
                    MemoriaController.acabo=true;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void ejecutarHiloTemporizador(int x){
        System.out.println(x);
        
        if(MemoriaController.seg==0){
            MemoriaController.seg=59;
            MemoriaController.min--;
        }
        
        MemoriaController.seg--;
        
        
        String txtSeg = "";
        String txtMin = String.valueOf(MemoriaController.min);
        
        
        if(MemoriaController.seg<10){
            txtSeg = "0"+ String.valueOf(MemoriaController.seg);
        }else{
            txtSeg =  String.valueOf(MemoriaController.seg);
        }
        
        String txtReloj = txtMin+":"+txtSeg;
        lTemp.setText(txtReloj);
        if(MemoriaController.min==0){
            MemoriaController.acabo=true;
        }
    }
    
    
}

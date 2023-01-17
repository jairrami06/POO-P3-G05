package com.mycompany.proyectofinal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author oweny
 */
public class MemoriaController implements Initializable {

    @FXML
    public Pane panel1;
    @FXML
    private Label temporizador;
    @FXML
    private Label intentos;
    @FXML
    private VBox vbRegistro;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnIniciar;

    public String firstVal = "";
    public Rectangle firstRectangle;
    public static int seg = 0;
    public static int min = 3;
    public static boolean acabo = false;

    public int aciertos = 0, fallos = 0, intentosInicial = 3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");   
    }
    
    @FXML
    public void iniciar(ActionEvent event) {
        ArrayList<Cliente> clientes = Cliente.cargarClientes("data/Clientes.ser");
        Object evt = event.getSource();
        if (evt.equals(btnIniciar)) {
            String cedula = txtCedula.getText();
            String nombre = txtNombre.getText();

            Boolean clienteFound = clientes.contains(new Cliente(cedula));

            if (clienteFound) {
                vbRegistro.setVisible(false);
                vbRegistro.setDisable(true);
                temporizador.setVisible(true);
                intentos.setVisible(true);
                panel1.setVisible(true);

                try {
                    FileInputStream f = new FileInputStream("data/memoria/card.png");
                    Image image = new Image(f);
                    List<Node> newList = panel1.getChildren();
                    for (int i = 0; i < newList.size(); i++) {

                        String type = newList.get(i).getClass().toString();
                        Pattern pattern3 = Pattern.compile("Rectangle", Pattern.CASE_INSENSITIVE);
                        Matcher matcher3 = pattern3.matcher(type);
                        boolean matchFound3 = matcher3.find();

                        if (matchFound3) {
                            Rectangle newRec = (Rectangle) newList.get(i);
                            newRec.setFill(new ImagePattern(image));
                        }

                    }
                    firstVal = "";
                    firstRectangle = new Rectangle();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "La cedula ingresada no corresponde a ningun cliente registrado");
            }
        }
    }
    

    public static void setTimeout(Runnable runnable, int delay) {

        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }).start();

    }

    public void flip(String id, Rectangle rec, Image img) {

        if ("".equals(firstVal)) {
            firstVal = id;
            firstRectangle = rec;
            rec.setFill(new ImagePattern(img));

        } else {
            if (firstVal.equals(id)) {
                rec.setFill(new ImagePattern(img));
                rec.setDisable(true);
                firstRectangle.setDisable(true);
                firstVal = "";
                firstRectangle = new Rectangle();

                aciertos += 1;

            } else {
                try {
                    FileInputStream f = new FileInputStream("data/memoria/card.png");
                    Image image = new Image(f);

                    rec.setFill(new ImagePattern(img));

                    CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(() -> {
                        rec.setFill(new ImagePattern(image));
                        firstRectangle.setFill(new ImagePattern(image));
                        firstVal = "";
                        firstRectangle = new Rectangle();
                    });
                    fallos += 1;

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void changeSource(Event evt) {

        Rectangle someRec = (Rectangle) evt.getSource();
        String recID = someRec.getId();

        Pattern pattern1 = Pattern.compile("aceite", Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(recID);
        boolean matchFound1 = matcher1.find();

        Pattern pattern2 = Pattern.compile("acondicionador", Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(recID);
        boolean matchFound2 = matcher2.find();

        Pattern pattern3 = Pattern.compile("gel", Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(recID);
        boolean matchFound3 = matcher3.find();

        Pattern pattern4 = Pattern.compile("limpiavisores", Pattern.CASE_INSENSITIVE);
        Matcher matcher4 = pattern4.matcher(recID);
        boolean matchFound4 = matcher4.find();

        Pattern pattern5 = Pattern.compile("removedor", Pattern.CASE_INSENSITIVE);
        Matcher matcher5 = pattern5.matcher(recID);
        boolean matchFound5 = matcher5.find();

        Pattern pattern6 = Pattern.compile("remover_agua", Pattern.CASE_INSENSITIVE);
        Matcher matcher6 = pattern6.matcher(recID);
        boolean matchFound6 = matcher6.find();

        //String usuario_dir = System.getProperty("user.dir");
        try {
            if (matchFound1) {

                FileInputStream f = new FileInputStream("data/memoria/aceite.png");
                Image img = new Image(f);
                flip("aceite.png", someRec, img);

            } else if (matchFound2) {

                FileInputStream f = new FileInputStream("data/memoria/acondicionador.png");
                Image img = new Image(f);
                flip("acondicionador.png", someRec, img);

            } else if (matchFound3) {

                FileInputStream f = new FileInputStream("data/memoria/gel.png");
                Image img = new Image(f);
                flip("gel.png", someRec, img);

            } else if (matchFound4) {

                FileInputStream f = new FileInputStream("data/memoria/limpiavisores.png");
                Image img = new Image(f);
                flip("limpiavisores.png", someRec, img);

            } else if (matchFound5) {

                FileInputStream f = new FileInputStream("data/memoria/removedor.png");
                Image img = new Image(f);
                flip("removedor.png", someRec, img);

            } else if (matchFound6) {
                FileInputStream f = new FileInputStream("data/memoria/remover_agua.png");
                Image img = new Image(f);
                flip("remover_agua.png", someRec, img);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void terminarJuego() {

    }

    public void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /*public void iniciarTemporizador(){
        Thread t = new Thread(() -> {
            Platform.runLater(new Runnable(){
                public void run(){
                    try{
                        int x = 180;
                        while(acabo==false){
                            Thread.sleep(1000);
                            //System.out.println(x);
                            x--;
                            if(seg==0){
                                seg=59;
                                min--;
                            }
                            seg--;
                            String txtSeg = "";
                            String txtMin = String.valueOf(min);

                            if(seg<10){
                                txtSeg = "0"+ String.valueOf(seg);
                            }else{
                                txtSeg =  String.valueOf(seg);
                            }

                            String txtReloj = txtMin+":"+txtSeg;
                            temporizador.setText(txtReloj);
                            if(x==0){
                                acabo=true;
                            }
                        }
                    }catch(Exception e){
                            System.out.println(e.getMessage());
                    }  
                }
            });
        });
        t.start();
    }*/
}

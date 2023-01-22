module com.mycompany.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;

    opens com.mycompany.proyectofinal to javafx.fxml;
    opens modelo to javafx.base;
    opens Utilidad to javafx.base;
    exports com.mycompany.proyectofinal;
    
}

module com.example.lab2a {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens pl.lublin.wsei.java.cwiczenia to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia;
}
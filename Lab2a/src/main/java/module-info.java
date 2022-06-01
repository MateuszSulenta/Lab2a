module com.example.lab2a {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab2a to javafx.fxml;
    exports com.example.lab2a;
}
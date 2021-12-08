module com.example.haromszogek {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.haromszogek to javafx.fxml;
    exports com.example.haromszogek;
}
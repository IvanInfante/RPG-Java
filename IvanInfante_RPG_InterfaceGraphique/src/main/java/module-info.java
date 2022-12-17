module com.example.ivanrpg {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ivanrpg to javafx.fxml;
    exports com.example.ivanrpg;
}
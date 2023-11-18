module com.example.aed_trim1_cakefactory_ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aed_trim1_cakefactory_ to javafx.fxml;
    exports com.example.aed_trim1_cakefactory_;
    exports com.example.aed_trim1_cakefactory_.views;
    opens com.example.aed_trim1_cakefactory_.views to javafx.fxml;
    exports com.example.aed_trim1_cakefactory_.controller;
    opens com.example.aed_trim1_cakefactory_.controller to javafx.fxml;
}
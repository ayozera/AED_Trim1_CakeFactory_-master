package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class NuevoPedidoController {

    public Button botonCrear;
    public ChoiceBox choiceCliente;
    public ChoiceBox choiceReceta;
    public DatePicker dateFecha;
    public TextField textfieldComensales;
    public Button botonCerrarSesion;
    public Button botonVolver;

    public void initialize() throws SQLException {

        ArrayList<String> clientes = Consulta.resultSetToList(Objects.requireNonNull(Consulta.consultarNombreCliente(ConexionDB.getConector().getConexion())));
        //choiceCliente.setItems(FXCollections.observableList(clientes));

        ArrayList<String> recetas = Consulta.resultSetToList(Objects.requireNonNull(Consulta.consultarNombreReceta(ConexionDB.getConector().getConexion())));
        choiceReceta.setItems(FXCollections.observableList(recetas));

    }

    public void crearPedido(ActionEvent actionEvent) {
    }

    public void cerrarSesion(ActionEvent actionEvent) {
    }
}

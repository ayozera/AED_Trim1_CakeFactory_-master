package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.Utiles;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import com.example.aed_trim1_cakefactory_.modelo.crud.Insercion;
import com.example.aed_trim1_cakefactory_.views.NuevoPedido;
import com.example.aed_trim1_cakefactory_.views.Pedidos;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class NuevoPedidoController {

    public Button botonCrear;
    public ComboBox choiceCliente;
    public ComboBox choiceReceta;
    public DatePicker dateFecha;
    public TextField textfieldComensales;
    public Button botonCerrarSesion;
    public Button botonVolver;

    public void initialize() throws SQLException {

        ArrayList<String> clientes = Consulta.resultSetToList(Objects.requireNonNull(Consulta.consultarNombreCliente(ConexionDB.getConector().getConexion())));
        choiceCliente.setItems(FXCollections.observableList(clientes));

        ArrayList<String> recetas = Consulta.resultSetToList(Objects.requireNonNull(Consulta.consultarNombreReceta(ConexionDB.getConector().getConexion())));
        choiceReceta.setItems(FXCollections.observableList(recetas));

    }

    public void crearPedido(ActionEvent actionEvent) throws SQLException {

        try {
            String nombreCliente = choiceCliente.getSelectionModel().getSelectedItem().toString();
            String nombreReceta = choiceReceta.getSelectionModel().getSelectedItem().toString();
            LocalDate fecha = dateFecha.getValue();
            Insercion.pedido(nombreCliente, nombreReceta, fecha);

            NuevoPedido.getStageNuevoPedido().close();
            Pedidos.getStagePedidos().close();
            Pedidos.show();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nuevo pedido añadido");
            alert.setHeaderText("Se ha creado un nuevo pedido con los siguientes datos:");
            alert.setContentText("Cliente: " + nombreCliente + " Receta: " + nombreReceta + " Fecha: " + fecha);
            alert.show();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Creación fallida");
            alert.setHeaderText("No se ha podido dar de alta al nuevo pedido");
            alert.setContentText("Verifique que ha cumplimentado todos los campos");
            alert.show();
        }
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        Utiles.cerrarSesion();
    }
}

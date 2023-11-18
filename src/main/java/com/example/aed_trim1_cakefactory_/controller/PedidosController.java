package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import com.example.aed_trim1_cakefactory_.views.EditarPedido;
import com.example.aed_trim1_cakefactory_.views.NuevoPedido;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidosController {
    public TableView tablaPedidos;
    public Button botonCrear;
    public Button botonEditar;
    public TableColumn<ArrayList<String>, String> nombreCliente;
    public TableColumn<ArrayList<String>, String> nombreReceta;
    public TableColumn<ArrayList<String>, String> fecha;
    public TableColumn<ArrayList<String>, String> direccion;
    public TableColumn<ArrayList<String>, String> email;
    public TableColumn<ArrayList<String>, String> telefono;

    public void initialize() throws SQLException {

        setTableValue();

        ArrayList<String> row = new ArrayList<>();

        row.add("Cliente");
        row.add("Receta");
        row.add("Fecha");
        row.add("Direccion");
        row.add("Email");
        row.add("Teléfono");

        ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();
        data.add(row);

        ArrayList<String>[] pedidos = resultSetToList(Consulta.consultarPedido(ConexionDB.getConector().getConexion()));

        for (int i = 0; i < 6; i++) {
            data.add(pedidos[i]);
        }

        tablaPedidos.setItems(data);

    }

    private void setTableValue() {
        nombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        nombreReceta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        direccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        telefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
    }

    public void abrirNuevoPedido(ActionEvent actionEvent) throws IOException {
        NuevoPedido.show();
    }

    public void abrirEditarPedido(ActionEvent actionEvent) throws IOException {
        EditarPedido.show();
    }

    public ArrayList<String>[] resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<String>[] builder = new ArrayList[metaData.getColumnCount()];

        while (rs.next()) {
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                builder[i].add(rs.getString(i));
            }
        }

        return builder;
    }
}

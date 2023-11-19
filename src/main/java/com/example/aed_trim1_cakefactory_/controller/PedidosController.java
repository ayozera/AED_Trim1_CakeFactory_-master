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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static com.example.aed_trim1_cakefactory_.modelo.crud.Consulta.resultSetToTable;

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
    public TableColumn<ArrayList<String>, String> indice;

    public void initialize() throws SQLException {

        setTableValue();

        ArrayList<String> row = new ArrayList<>();

        row.add("");
        row.add("Cliente");
        row.add("Receta");
        row.add("Fecha");
        row.add("Direccion");
        row.add("Email");
        row.add("Teléfono");

        ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();
        data.add(row);

        String[][] pedidos = resultSetToTable(Objects.requireNonNull(Consulta.consultarPedido(ConexionDB.getConector().getConexion())));

        for (int i = 0; i < pedidos.length; i++) {
            ArrayList<String> columna = new ArrayList<>();
            for (int j = 0; j < pedidos[0].length; j++) {
                columna.add(pedidos[i][j]);
            }
            data.add(columna);
        }

        tablaPedidos.setItems(data);

    }

    private void setTableValue() {
        indice.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        nombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        nombreReceta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        direccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
        telefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(6)));
    }

    public void abrirNuevoPedido(ActionEvent actionEvent) throws IOException {
        NuevoPedido.show();
    }

    public void abrirEditarPedido(ActionEvent actionEvent) throws IOException {
        EditarPedido.show();
    }

}

package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import com.example.aed_trim1_cakefactory_.views.EditarPedido;
import com.example.aed_trim1_cakefactory_.views.EditarReceta;
import com.example.aed_trim1_cakefactory_.views.NuevoPedido;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static com.example.aed_trim1_cakefactory_.modelo.crud.Consulta.resultSetToTable;

public class PedidosController {

    public static String id = "";
    public TableView tablaPedidos;
    public Button botonCrear;
    public Button botonEditar;
    public TableColumn<ArrayList<String>, String> nombreCliente;
    public TableColumn<ArrayList<String>, String> nombreReceta;
    public TableColumn<ArrayList<String>, String> fecha;
    public TableColumn<ArrayList<String>, String> direccion;
    public TableColumn<ArrayList<String>, String> email;
    public TableColumn<ArrayList<String>, String> telefono;
    public TableColumn<ArrayList<String>, String> codigo;

    public void initialize() throws SQLException {

        setTableValue();
        ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();

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
        codigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
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
        try {
            TableView.TableViewSelectionModel selectionModel = tablaPedidos.getSelectionModel();
            ObservableList selectedCells = selectionModel.getSelectedCells();

            TablePosition tablePosition = (TablePosition) selectedCells.get(0);
            int row = tablePosition.getRow();

            // Obtén la segunda columna de la fila seleccionada
            TableColumn column = (TableColumn) tablaPedidos.getColumns().get(1);
            String cellValue = column.getCellData(row).toString();
            id = cellValue;

            EditarPedido.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selección nula");
            alert.setHeaderText("Debe seleccionarse primero una fila");
            alert.setContentText("Para editar una receta, primero debe seleccionarse");
            alert.show();
        }

    }

}

package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.DataUp;
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
    public static String nombreClienteText;
    public static String nombreRecetaText;
    public static String fechaText;
    public static String direccionText;
    public static String emailText;
    public static String telefonoText;
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

    public void initialize() throws SQLException, IOException, ClassNotFoundException {

        setTableValue();
        ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();

        String[][] pedidos = resultSetToTable(Objects.requireNonNull(DataUp.cargarMapaConsultas("src/main/files/mapaConsultas.bin").consultar(ConexionDB.getConector().getConexion(), "consultarPedido")));

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

            TableColumn column1 = (TableColumn) tablaPedidos.getColumns().get(0);
            id = column1.getCellData(row).toString();
            TableColumn column2 = (TableColumn) tablaPedidos.getColumns().get(1);
            nombreClienteText = column2.getCellData(row).toString();
            TableColumn column3 = (TableColumn) tablaPedidos.getColumns().get(2);
            nombreRecetaText = column3.getCellData(row).toString();
            TableColumn column4 = (TableColumn) tablaPedidos.getColumns().get(3);
            fechaText = column4.getCellData(row).toString();
            TableColumn column5 = (TableColumn) tablaPedidos.getColumns().get(4);
            direccionText = column5.getCellData(row).toString();
            TableColumn column6 = (TableColumn) tablaPedidos.getColumns().get(5);
            emailText = column6.getCellData(row).toString();
            TableColumn column7 = (TableColumn) tablaPedidos.getColumns().get(6);
            telefonoText = column7.getCellData(row).toString();

            EditarPedido.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selección nula");
            alert.setHeaderText("Debe seleccionarse primero una fila");
            alert.setContentText("Para editar una receta, primero debe seleccionarse");
            alert.show();
        }

    }

    public void cerrarSesion(ActionEvent actionEvent) {
    }
}

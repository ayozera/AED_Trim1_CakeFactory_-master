package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.DataUp;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import com.example.aed_trim1_cakefactory_.modelo.crud.MapaConsultas;
import com.example.aed_trim1_cakefactory_.views.EditarReceta;
import com.example.aed_trim1_cakefactory_.views.NuevaReceta;
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

public class RecetasController {

    public static String id = "";
    public TableView tablaRecetas;
    public Button botonNueva;
    public Button botonEditar;
    public TableColumn<ArrayList<String>, String> nombreReceta;
    public TableColumn<ArrayList<String>, String> precio;
    public TableColumn<ArrayList<String>, String> codigo;
    public Button botonCerrarSesion;

    public void initialize() throws SQLException, IOException, ClassNotFoundException {

        setTableValue();
        ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();
        String[][] recetas = resultSetToTable(Objects.requireNonNull(DataUp.cargarMapaConsultas("src/main/files/mapaConsultas.bin").consultar(ConexionDB.getConector().getConexion(), "consultarReceta")));

        for (int i = 0; i < recetas.length; i++) {
            ArrayList<String> columna = new ArrayList<>();
            for (int j = 0; j < recetas[0].length; j++) {
                columna.add(recetas[i][j]);
            }
            data.add(columna);
        }

        tablaRecetas.setItems(data);

    }

    private void setTableValue() {
        codigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        nombreReceta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        precio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
    }

    public void abrirNuevaReceta(ActionEvent actionEvent) throws IOException {
        NuevaReceta.show();
    }

    public void abrirEditarReceta(ActionEvent actionEvent) throws IOException {

        try {
            TableView.TableViewSelectionModel selectionModel = tablaRecetas.getSelectionModel();
            ObservableList selectedCells = selectionModel.getSelectedCells();

            TablePosition tablePosition = (TablePosition) selectedCells.get(0);
            int row = tablePosition.getRow();

            // Obtén la segunda columna de la fila seleccionada
            TableColumn column = (TableColumn) tablaRecetas.getColumns().get(0);
            id = column.getCellData(row).toString();

            EditarReceta.show();
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

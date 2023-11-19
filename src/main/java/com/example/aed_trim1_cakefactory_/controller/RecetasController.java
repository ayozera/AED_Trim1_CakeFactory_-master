package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import com.example.aed_trim1_cakefactory_.views.EditarReceta;
import com.example.aed_trim1_cakefactory_.views.NuevaReceta;
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

public class RecetasController {
    public TableView tablaRecetas;
    public Button botonNueva;
    public Button botonEditar;
    public TableColumn<ArrayList<String>, String> indice;
    public TableColumn<ArrayList<String>, String> nombreReceta;
    public TableColumn<ArrayList<String>, String> precio;

    public void initialize() throws SQLException {

        setTableValue();
        ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();

        String[][] pedidos = resultSetToTable(Objects.requireNonNull(Consulta.consultarReceta(ConexionDB.getConector().getConexion())));

        for (int i = 0; i < pedidos.length; i++) {
            ArrayList<String> columna = new ArrayList<>();
            for (int j = 0; j < pedidos[0].length; j++) {
                columna.add(pedidos[i][j]);
            }
            data.add(columna);
        }

        tablaRecetas.setItems(data);

    }

    private void setTableValue() {
        indice.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        nombreReceta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        precio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
    }

    public void abrirNuevaReceta(ActionEvent actionEvent) throws IOException {
        NuevaReceta.show();
    }

    public void abrirEditarReceta(ActionEvent actionEvent) throws IOException {
        EditarReceta.show();
    }
}

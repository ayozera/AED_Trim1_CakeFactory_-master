package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static com.example.aed_trim1_cakefactory_.modelo.crud.Consulta.resultSetToTable;

public class EditarRecetaController {
    public TextArea textAreaIngredientes;
    public TextArea textAreaElaboracion;
    public Button botonBorrar;
    public Button botonEditar;

    public void initialize() throws SQLException {


        String[][] ingredientes = resultSetToTable(Objects.requireNonNull(
                Consulta.consultarIngredientes(ConexionDB.getConector().getConexion(), RecetasController.id)));

        String columna = "";
        for (int i = 0; i < ingredientes.length; i++) {
            for (int j = 0; j < ingredientes[0].length; j++) {
                columna = columna.concat(ingredientes[i][j] + "  ");
            }
            columna = columna.concat("\n");
        }

        textAreaIngredientes.setText(columna);
    }
    public void borrarReceta(ActionEvent actionEvent) {
    }

    public void editarReceta(ActionEvent actionEvent) {
    }
}

package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.Utiles;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import com.example.aed_trim1_cakefactory_.modelo.crud.Delete;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
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
        try {
            System.out.println(RecetasController.id);
            Delete.eliminarRegistros("pedido",PedidosController.id);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selección nula");
            alert.setHeaderText("No se ha borrado ningún registro");
            alert.setContentText("Esto puede suceder si el registro ha sido borrado previamente");
            alert.show();
        }
    }

    public void editarReceta(ActionEvent actionEvent) {
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        Utiles.cerrarSesion();
    }
}

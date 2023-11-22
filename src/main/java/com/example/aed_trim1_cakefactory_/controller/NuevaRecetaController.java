package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.Utiles;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static com.example.aed_trim1_cakefactory_.modelo.crud.Consulta.resultSetToTable;

public class NuevaRecetaController {

    public TextArea textAreaElaboracion;
    public Button botonCrear;
    public ListView textAreaIngredientes;
    public ToggleGroup UnidadesDeMedida;
    public Button botonCrear1;
    public ComboBox comboBoxIngredientes;
    public Button botonCuenta;
    public Button botonCerrarSesion;
    public RadioButton radioButtonUnidades;
    public RadioButton radioButtonMililitros;
    public RadioButton radioButtonGramos;
    public Button botonAgnadirIngredientes;
    public Spinner spinnerCantidad;
    public ListView listViewIngredientes;
    public Button botonAgregarReceta;
    public Tooltip toolTipCucharadas;

    public void initialize() throws SQLException {

        ArrayList<String> ingredientes = Consulta.resultSetToList(Objects.requireNonNull(Consulta.consultarNombreIngrediente(ConexionDB.getConector().getConexion())));
        comboBoxIngredientes.setItems(FXCollections.observableList(ingredientes));

        spinnerCantidad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000));
        spinnerCantidad.setEditable(true);

        toolTipCucharadas.setShowDelay(Duration.millis(100));
    }


    public void crear(ActionEvent actionEvent) {
    }

    public void abrirCuenta(ActionEvent actionEvent) {
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        Utiles.cerrarSesion();
    }
}

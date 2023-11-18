package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.views.EditarReceta;
import com.example.aed_trim1_cakefactory_.views.NuevaReceta;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class RecetasController {
    public TableView tablaRecetas;
    public Button botonNueva;
    public Button botonEditar;

    public void abrirNuevaReceta(ActionEvent actionEvent) throws IOException {
        NuevaReceta.show();
    }

    public void abrirEditarReceta(ActionEvent actionEvent) throws IOException {
        EditarReceta.show();
    }
}

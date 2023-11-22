package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.views.Pedidos;
import com.example.aed_trim1_cakefactory_.views.Recetas;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.io.IOException;

public class MenuPrincipalController {
    public Button botonRecetas;
    public Button botonPedidos;
    public Button botonCuenta;

    public void abrirRecetas(ActionEvent actionEvent) throws IOException {
        Recetas.show();
    }

    public void abrirPedidos(ActionEvent actionEvent) throws IOException {
        Pedidos.show();
    }

    public void abrirCuenta(ActionEvent actionEvent) {
    }
}

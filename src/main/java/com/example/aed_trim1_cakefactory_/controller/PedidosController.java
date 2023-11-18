package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.views.EditarPedido;
import com.example.aed_trim1_cakefactory_.views.NuevoPedido;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import java.io.IOException;

public class PedidosController {
    public TableView tablaPedidos;
    public Button botonCrear;
    public Button botonEditar;

    public void abrirNuevoPedido(ActionEvent actionEvent) throws IOException {
        NuevoPedido.show();
    }

    public void abrirEditarPedido(ActionEvent actionEvent) throws IOException {
        EditarPedido.show();
    }
}

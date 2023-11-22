package com.example.aed_trim1_cakefactory_.controller;

import com.example.aed_trim1_cakefactory_.AppMain;
import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;
import com.example.aed_trim1_cakefactory_.modelo.DataUp;
import com.example.aed_trim1_cakefactory_.modelo.Utiles;
import com.example.aed_trim1_cakefactory_.modelo.crud.Actualizar;
import com.example.aed_trim1_cakefactory_.modelo.crud.Consulta;
import com.example.aed_trim1_cakefactory_.modelo.crud.Delete;
import com.example.aed_trim1_cakefactory_.modelo.crud.MapaConsultas;
import com.example.aed_trim1_cakefactory_.views.EditarPedido;
import com.example.aed_trim1_cakefactory_.views.LogIn;
import com.example.aed_trim1_cakefactory_.views.NuevoPedido;
import com.example.aed_trim1_cakefactory_.views.Pedidos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class EditarPedidoController {
    public Button botonEditar;
    public ChoiceBox choiceCliente;
    public ChoiceBox choiceReceta;
    public DatePicker dateFecha;
    public Button botonBorrar;
    public Button botonCerrarSesion;

    public void initialize() throws SQLException, IOException, ClassNotFoundException {

        ArrayList<String> clientes = Consulta.resultSetToList(Objects.requireNonNull(Consulta.consultarNombreCliente(ConexionDB.getConector().getConexion())));
        ArrayList<String> recetas = Consulta.resultSetToList(Objects.requireNonNull(Consulta.consultarNombreReceta(ConexionDB.getConector().getConexion())));

        choiceCliente.setItems(FXCollections.observableList(clientes));
        choiceReceta.setItems(FXCollections.observableList(recetas));

        choiceCliente.setValue(PedidosController.nombreClienteText);
        choiceReceta.setValue(PedidosController.nombreRecetaText);
        int year = Integer.parseInt(PedidosController.fechaText.substring(0,4));
        int mes = Integer.parseInt(PedidosController.fechaText.substring(5,7));
        int dia = Integer.parseInt(PedidosController.fechaText.substring(8,10));
        dateFecha.setValue(LocalDate.of(year, mes, dia));
    }
    public void editarPedido(ActionEvent actionEvent) throws SQLException, IOException {
        String nombreCliente = choiceCliente.getSelectionModel().getSelectedItem().toString();
        String nombreReceta = choiceReceta.getSelectionModel().getSelectedItem().toString();
        LocalDate fecha = dateFecha.getValue();
        Actualizar.pedido(nombreCliente, nombreReceta, fecha, PedidosController.id);

        EditarPedido.getStageEditarPedido().close();
        Pedidos.getStagePedidos().close();
        Pedidos.show();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pedido actualizado");
        alert.setHeaderText("Se ha actualizado el pedido con los siguientes datos:");
        alert.setContentText("Cliente: " + nombreCliente + " Receta: " + nombreReceta + " Fecha: " + fecha);
        alert.show();

    }

    public void borrarPedido(ActionEvent actionEvent) {
        try {
            System.out.println(PedidosController.id);
            Delete.eliminarRegistros("pedido",PedidosController.id);

            EditarPedido.getStageEditarPedido().close();
            Pedidos.getStagePedidos().close();
            Pedidos.show();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pedido borrado correctamente");
            alert.setHeaderText("Se ha borrado el pedido indicado");
            alert.show();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selección nula");
            alert.setHeaderText("No se ha borrado ningún registro");
            alert.setContentText("Esto puede suceder si el registro ha sido borrado previamente");
            alert.show();
        }
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        Utiles.cerrarSesion();
    }
}

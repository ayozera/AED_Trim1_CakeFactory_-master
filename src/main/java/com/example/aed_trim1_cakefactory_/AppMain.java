package com.example.aed_trim1_cakefactory_;

import com.example.aed_trim1_cakefactory_.modelo.crud.MapaConsultas;
import com.example.aed_trim1_cakefactory_.views.LogIn;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.aed_trim1_cakefactory_.modelo.entidades.Credencial;
import com.example.aed_trim1_cakefactory_.modelo.DataUp;

public class AppMain extends Application {

    public static List<Stage> ventanas = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        LogIn.show();
    }

    public static void main(String[] args) throws IOException {
/*
        String ruta = "src/main/files/tartasCreativas.bin";
        File ficheroInicial = new File(ruta);

        String rutaConsultas = "src/main/files/mapaConsultas.bin";
        File ficheroInicialConsultas = new File(rutaConsultas);
*/

/*        if (!ficheroInicial.exists()) {
            Credencial admin = new Credencial("admin", "admin", true);
            ArrayList<Credencial> cargaInicial = new ArrayList<>();
            cargaInicial.add(admin);
            DataUp.guardarBin(ruta, cargaInicial);
        }

        if (!ficheroInicialConsultas.exists()) {
            HashMap<String, String> valores = new HashMap<>();
            valores.put("consultarPedido", "select p.id, c.nombre, r.nombre, p.fecha, c.direccion, c.email, c.telefono " +
                    "from clientes as c " +
                    "inner join pedido as p " +
                    "ON c.id=p.cliente_id " +
                    "inner join receta as r " +
                    "ON p.tarta_id=r.id " +
                    "order by p.fecha;");
            valores.put("consultarReceta", "SELECT r.id, r.nombre, sum(ri.cantidad*i.precio) as precio " +
                    "FROM `receta` as r " +
                    "INNER JOIN receta_ingrediente as ri " +
                    "on r.id=ri.receta_id " +
                    "INNER JOIN ingredientes as i " +
                    "on ri.ingrediente_id=i.id " +
                    "group by r.id, r.nombre;");
            MapaConsultas consultas = new MapaConsultas(valores);
            DataUp.guardarMapaConsultas(consultas, rutaConsultas);
        }*/


        launch();
    }
}
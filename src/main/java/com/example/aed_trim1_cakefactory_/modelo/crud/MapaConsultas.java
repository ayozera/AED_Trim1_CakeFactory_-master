package com.example.aed_trim1_cakefactory_.modelo.crud;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class MapaConsultas implements Serializable {
    HashMap<String, String> mapa = new HashMap<>();

    public MapaConsultas() {
    }

    public MapaConsultas(HashMap<String, String> mapa) {
        this.mapa = mapa;
    }

    public ResultSet consultar(Connection conexion, String clave) {
        try {
            String sentencia = mapa.get(clave);

            Statement estamento = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return estamento.executeQuery(sentencia);

        } catch (SQLException e) {
            System.out.println("[!] El servidor no ha admitido los parámetros de la consulta");
        }
        return null;
    }

    public void add(MapaConsultas elemento){
        this.add(elemento);
    }
}

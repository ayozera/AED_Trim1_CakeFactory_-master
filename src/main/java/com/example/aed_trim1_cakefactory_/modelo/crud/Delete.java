package com.example.aed_trim1_cakefactory_.modelo.crud;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void eliminarRegistros(String nombreTabla, String id) throws SQLException {

        try (PreparedStatement statement = ConexionDB.getConector().getConexion().prepareStatement("DELETE FROM " + nombreTabla + " WHERE id = ?")) {
            statement.setObject(1, id);
        }
    }
}
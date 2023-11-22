package com.example.aed_trim1_cakefactory_.modelo.crud;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Actualizar {
    public static void pedido(String idCliente, String idReceta, LocalDate fecha,String id) throws SQLException {

        try (PreparedStatement statement = ConexionDB.getConector().getConexion().prepareStatement("UPDATE `pedido` " +
                "SET `cliente_id`=(SELECT id FROM clientes WHERE nombre = ? )," +
                "`tarta_id`=(SELECT id FROM receta WHERE nombre = ? )," +
                "`fecha`= ? " +
                "WHERE `id`= ? "))
        {
            statement.setObject(1, idCliente);
            statement.setObject(2, idReceta);
            statement.setObject(3, fecha.toString());
            statement.setObject(4, id);
            statement.executeUpdate();
        }
    }
}

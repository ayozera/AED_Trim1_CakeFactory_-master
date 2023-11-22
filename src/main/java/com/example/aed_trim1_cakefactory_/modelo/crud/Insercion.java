package com.example.aed_trim1_cakefactory_.modelo.crud;

import com.example.aed_trim1_cakefactory_.modelo.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Insercion {
    public static void pedido(String nombreCliente, String nombreTarta, LocalDate fecha) throws SQLException {

        try (PreparedStatement statement = ConexionDB.getConector().getConexion().prepareStatement("INSERT INTO `pedido`" +
                "(`cliente_id`, `tarta_id`, `fecha`) " +
                "VALUES ((SELECT id FROM clientes WHERE nombre = ?), " +
                "(SELECT id FROM receta WHERE nombre = ?), " +
                "?);")) {
            statement.setObject(1, nombreCliente);
            statement.setObject(2, nombreTarta);
            String fechaCadena = fecha.toString();
            statement.setObject(3, fechaCadena);
            statement.executeUpdate();
        }
    }
}

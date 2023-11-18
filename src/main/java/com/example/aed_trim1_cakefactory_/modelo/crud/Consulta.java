package com.example.aed_trim1_cakefactory_.modelo.crud;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Ayoze Rodríguez Álvarez
 */
public class Consulta {
    public static ResultSet consultarPedido(Connection conexion) {
        try {
            String sentencia = "select c.nombre, r.nombre, p.fecha, c.direccion, c.email, c.telefono " +
                    "from clientes as c " +
                    "inner join pedido as p " +
                    "ON c.id=p.cliente_id " +
                    "inner join receta as r " +
                    "ON p.tarta_id=r.id " +
                    "order by p.fecha;";

            Statement estamento = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return estamento.executeQuery(sentencia);

        } catch (SQLException e) {
            System.out.println("[!] El servidor no ha admitido los parámetros de la consulta");
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String> obtenerCampos(String nombreTabla, Connection conexion) throws SQLException {
        DatabaseMetaData meta = conexion.getMetaData();
        ResultSet resultado = meta.getColumns(null, null, nombreTabla, null);

        ArrayList<String> nombreCampos = new ArrayList<>();
        while(resultado.next()) {
            nombreCampos.add(resultado.getString("COLUMN_NAME"));
        }

        return nombreCampos;
    }

    public static String listarCampos(ArrayList<String> nombreCampos) {
        String listaCampos = "";
        for (int i = 0; i < nombreCampos.size() - 1; i++) {
            if (!nombreCampos.get(i).equalsIgnoreCase("id") ) {
                listaCampos += nombreCampos.get(i) + ", ";
            }
        }
        listaCampos += nombreCampos.get(nombreCampos.size() - 1);
        return listaCampos;
    }


}


package com.example.aed_trim1_cakefactory_.modelo.crud;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static com.example.aed_trim1_cakefactory_.modelo.DataUp.cargarMapaConsultas;


/**
 *
 * @author Ayoze Rodríguez Álvarez
 */
public class Consulta {

/*    public static MapaConsultas mapaConsultas;

    static {
        try {
            mapaConsultas = cargarMapaConsultas("src/main/files/mapaConsultas.bin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static ResultSet consultarPedido(Connection conexion) {
        try {
            String sentencia = "select p.id, c.nombre, r.nombre, p.fecha, c.direccion, c.email, c.telefono " +
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

    public static ResultSet consultarReceta(Connection conexion) {
        try {
            String sentencia = "SELECT r.id, r.nombre, sum(ri.cantidad*i.precio) as precio " +
                    "FROM `receta` as r " +
                    "INNER JOIN receta_ingrediente as ri " +
                    "on r.id=ri.receta_id " +
                    "INNER JOIN ingredientes as i " +
                    "on ri.ingrediente_id=i.id " +
                    "group by r.id, r.nombre;";

            Statement estamento = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return estamento.executeQuery(sentencia);

        } catch (SQLException e) {
            System.out.println("[!] El servidor no ha admitido los parámetros de la consulta");
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet consultarIngredientes(Connection conexion, String id) {
        try {
            String sentencia = "SELECT i.nombre, i.cantidad, i.unidadMedida, i.precio " +
                    "FROM `receta` as r " +
                    "INNER JOIN receta_ingrediente as ri " +
                    "on r.id=ri.receta_id " +
                    "INNER JOIN ingredientes as i " +
                    "on ri.ingrediente_id=i.id " +
                    "where r.id = " + id + ";";

            Statement estamento = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return estamento.executeQuery(sentencia);

        } catch (SQLException e) {
            System.out.println("[!] El servidor no ha admitido los parámetros de la consulta");
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet consultarNombreCliente(Connection conexion) {
        try {
            String sentencia = "SELECT nombre FROM `clientes`;";

            Statement estamento = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return estamento.executeQuery(sentencia);

        } catch (SQLException e) {
            System.out.println("[!] El servidor no ha admitido los parámetros de la consulta");
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet consultarNombreReceta(Connection conexion) {
        try {
            String sentencia = "SELECT nombre FROM `receta`;";

            Statement estamento = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return estamento.executeQuery(sentencia);

        } catch (SQLException e) {
            System.out.println("[!] El servidor no ha admitido los parámetros de la consulta");
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet consultarNombreIngrediente(Connection conexion) {
        try {
            String sentencia = "SELECT nombre FROM `ingredientes`;";

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

    public static String[][] resultSetToTable(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        rs.last();
        int numeroFilas = rs.getRow();
        String[][] tabla = new String[numeroFilas][metaData.getColumnCount()];

        rs.first();
        int i = 0;
        do {
            for (int j = 1; j < tabla[0].length + 1; j++) {
                tabla[i][j - 1] = rs.getString(j);
            }
            i++;
        } while (rs.next());


        return tabla;
    }

    public static ArrayList<String> resultSetToList(ResultSet rs) throws SQLException {
        ArrayList<String> lista = new ArrayList<>();
        rs.first();
        do {
            lista.add(rs.getString(1));
        } while (rs.next());
        return lista;
    }
}


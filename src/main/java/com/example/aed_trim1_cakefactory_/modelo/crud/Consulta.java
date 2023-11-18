package com.example.aed_trim1_cakefactory_.modelo.crud;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Ayoze Rodríguez Álvarez
 */
public class Consulta {
    public static void consultar(String nombreTabla, Connection conexion) {
        try {
            String[] nombreCampos = obtenerCampos(nombreTabla, conexion);
            String listaCampos = listarCampos(nombreCampos);

            String sentencia = String.format("SELECT %s FROM %s", listaCampos, nombreTabla);

            Statement estamento = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultado = estamento.executeQuery(sentencia);


        } catch (SQLException e) {
            System.out.println("[!] El servidor no ha admitido los parámetros de la consulta");
            e.printStackTrace();
        }
    }

    public static String[] obtenerCampos(String nombreTabla, Connection conexion) throws SQLException {
        DatabaseMetaData meta = conexion.getMetaData();
        ResultSet resultado = meta.getColumns(null, null, nombreTabla, null);

        ArrayList<String> nombreCampos = new ArrayList<>();
        while(resultado.next()) {
            nombreCampos.add(resultado.getString("COLUMN_NAME"));
        }

        String[] salida = new String[nombreCampos.size()];
        for (int i = 0; i < salida.length; i++) {
            salida[i] = nombreCampos.get(i);
        }
        return salida;
    }

    public static String listarCampos(String[] nombreCampos) {
        String listaCampos = "";
        for (int i = 0; i < nombreCampos.length - 1; i++) {
            listaCampos += nombreCampos[i] + ", ";
        }
        listaCampos += nombreCampos[nombreCampos.length - 1];
        return listaCampos;
    }
    

}


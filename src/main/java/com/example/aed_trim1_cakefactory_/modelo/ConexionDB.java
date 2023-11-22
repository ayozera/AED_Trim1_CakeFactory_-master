package com.example.aed_trim1_cakefactory_.modelo;

import com.example.aed_trim1_cakefactory_.modelo.excepciones.ConexionFallidaException;

import java.sql.SQLException;

public class ConexionDB {

    private static Conector conector;
    public static boolean establecerConexionPredeterminada(String nombre, String clave) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conector = new Conector(nombre, clave);
            if (!conector.comprobarConexion()) {
                throw new ConexionFallidaException("No se ha podido establecer conexión");
            }
            return true;
        } catch (ConexionFallidaException ex) {
            System.out.println("[!] Atención. " + ex.getMessage());
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[!] Atención. Ha ocurrido un error con la base de datos. Por favor, intentelo de nuevo.");
            return false;
        } catch (ClassNotFoundException e) {
            System.out.println("clase no encontrada");
            return false;
        }
    }

    public static Conector getConector() {
        return conector;
    }
}

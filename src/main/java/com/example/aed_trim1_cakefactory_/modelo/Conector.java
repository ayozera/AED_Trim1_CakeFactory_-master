package com.example.aed_trim1_cakefactory_.modelo;

import java.sql.*;

public class Conector {

    //"encrypt=true;loginTimeout=90;integratedSecurity=true;" Para mejorar la seguridad y activar un cierre automático de sesión
//"?autoReconnect=true&useSSL=false" Para probar más rápido los tests de conexión
    private String urlDriver = "jdbc:mysql://localhost:3306/aed_ara_jml";
    private String usuario = "admin";
    private String password = "admin";
    private Connection conexion;

    public Conector() throws SQLException {
        conexion = DriverManager.getConnection(urlDriver, usuario, password);
    }

    public Conector(String usuario, String password) throws SQLException {
        this.usuario = usuario;
        this.password = password;
        conexion = DriverManager.getConnection(urlDriver, usuario, password);
    }

    public boolean comprobarConexion() {
        try {
            Connection con = DriverManager.getConnection(urlDriver, usuario, password);
            if (con != null) {
                System.out.println("[i] Exito al conectar con el servidor");

            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public String getUrlDriver() {
        return urlDriver;
    }

    public String getUsuario() {
        return usuario;
    }

    public Connection getConexion() {
        return conexion;
    }
}
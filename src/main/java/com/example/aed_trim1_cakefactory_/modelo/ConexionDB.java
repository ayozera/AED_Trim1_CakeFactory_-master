package com.example.aed_trim1_cakefactory_.modelo;

import java.sql.*;
public class ConexionDB {

//"encrypt=true;loginTimeout=90;integratedSecurity=true;" Para mejorar la seguridad y activar un cierre automático de sesión
//"?autoReconnect=true&useSSL=false" Para probar más rápido los tests de conexión
private String urlDriver = "jdbc:mysql://192.168.221.136:3306";
private String usuario = "root";
private String password = "";
private Connection conexion;

public ConexionDB() throws SQLException {
        conexion = DriverManager.getConnection(urlDriver, usuario, password);
        }

public ConexionDB(String urlDriver, String usuario, String password) throws SQLException {
        this.urlDriver = urlDriver;
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
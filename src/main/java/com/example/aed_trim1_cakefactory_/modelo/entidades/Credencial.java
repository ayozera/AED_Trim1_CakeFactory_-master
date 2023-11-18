package com.example.aed_trim1_cakefactory_.modelo.entidades;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author rodal
 */
public class Credencial implements Serializable{

    private String nombre;
    private String contrasenya;
    private boolean admin;
    private String password_db;

    public Credencial(String nombre, String contrasenya, boolean admin) {
        try {
            this.nombre = nombre;
            this.contrasenya = contrasenya;
            this.admin = admin;
            this.password_db = generarClave();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException();
        }
    }

    private String generarClave() throws NoSuchAlgorithmException {
        String menu = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&()*+,-./:;<=>?@[]^_{|}~";
        char[] alfabeto = menu.toCharArray();
        SecureRandom semilla = SecureRandom.getInstance("SHA1PRNG");
        String clave = "";
        for (int i = 0; i < 23; i++) {
            clave = clave.concat(String.valueOf(alfabeto[semilla.nextInt(alfabeto.length)]));
        }
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getPassword_db() {
        return password_db;
    }

}

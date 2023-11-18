package com.example.aed_trim1_cakefactory_.modelo.entidades;

import com.example.aed_trim1_cakefactory_.modelo.excepciones.UsuarioNoValidoException;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;


/**
 *
 * @author rodal
 */
public class Usuario {

    private final File CREDENCIALES = new File("src/main/files/tartasCreativas.bin");
    private boolean admin;
    private String nombre;
    private String password_db;

    public Usuario(String nombre, String password) throws IOException, UsuarioNoValidoException {
        if (!validar(nombre, password)) {
            throw new UsuarioNoValidoException("");
        }
    }

    private boolean validar(String nombre, String password) throws FileNotFoundException, IOException {
        LinkedList<Credencial> autentificadores = new LinkedList<>();
        try (ObjectInputStream obj_OIS = new ObjectInputStream(new FileInputStream(CREDENCIALES))) {
            Object elemento;
            while ((elemento = obj_OIS.readObject()) != null) {
                autentificadores.add((Credencial)elemento);
            }
        } catch(EOFException | ClassNotFoundException e) {
            //Se ha terminado de leer el archivo
        }
        boolean salida = false;
        for (Credencial llave : autentificadores) {
            if (llave.getNombre().equalsIgnoreCase(nombre)
                    && llave.getContrasenya().equals(password)) {
                salida = true;
                this.admin = llave.isAdmin();
                this.nombre = llave.getNombre();
                this.password_db = llave.getPassword_db();
            }
        }
        return salida;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword_db() {
        return password_db;
    }

}
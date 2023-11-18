package com.example.aed_trim1_cakefactory_.modelo;

import com.example.aed_trim1_cakefactory_.modelo.entidades.Credencial;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author rodal
 */
public class DataUp {

    public static void guardarBin(String ruta, ArrayList<Credencial> credenciales)
            throws FileNotFoundException, IOException {

        File fichero = new File(ruta);
        try (ObjectOutputStream obj_OOS = new ObjectOutputStream(new FileOutputStream(fichero))) {
            for (Credencial credencial : credenciales) {
                obj_OOS.writeObject(credencial);
            }
            obj_OOS.flush();
        }
    }

    public static ArrayList<Credencial> cargarBin(String ruta)
            throws FileNotFoundException, IOException, ClassNotFoundException {

        ArrayList<Credencial> credenciales = new ArrayList<>();

        try (ObjectInputStream obj_OIS = new ObjectInputStream(new FileInputStream(ruta))) {
            Object elemento;
            while ((elemento = obj_OIS.readObject()) != null) {
                credenciales.add((Credencial)elemento);
            }
        } catch(EOFException e ) {
            //Se ha terminado de leer el archivo
        }
        return credenciales;
    }
}

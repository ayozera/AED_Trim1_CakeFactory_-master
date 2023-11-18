package com.example.aed_trim1_cakefactory_.modelo.entidades;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodal
 */
public class Receta {

    private List<Ingrediente> ingredientes;
    private File elaboracion;

    public Receta(ArrayList<Ingrediente> ingredientes, File elaboracion) {
        this.elaboracion = elaboracion;
    }
}


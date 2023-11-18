package com.example.aed_trim1_cakefactory_.modelo.entidades;

/**
 *
 * @author rodal
 */
public class Ingrediente {

    private String nombre;
    private int cantidad;
    private String unidadMedida;
    private double precio;

    public Ingrediente(String nombre, int cantidad, String unidadMedida, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

}
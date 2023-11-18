package com.example.aed_trim1_cakefactory_.modelo.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodal
 */
public class Pedido {

    private Cliente cliente;
    private Receta tarta;
    private LocalDate fecha;

    public Pedido(Cliente cliente, Receta tarta, LocalDate fecha) {
        this.cliente = cliente;
        this.tarta = tarta;
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}

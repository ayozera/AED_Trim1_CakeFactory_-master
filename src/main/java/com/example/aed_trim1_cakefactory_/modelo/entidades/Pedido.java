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
    private List<Receta> tarta = new ArrayList<>();
    private LocalDate fecha;

    public Pedido(Cliente cliente, ArrayList<Receta> tarta, LocalDate fecha) {
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

    public List<Receta> getTarta() {
        return tarta;
    }

    public void setTarta(List<Receta> tarta) {
        this.tarta = tarta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}

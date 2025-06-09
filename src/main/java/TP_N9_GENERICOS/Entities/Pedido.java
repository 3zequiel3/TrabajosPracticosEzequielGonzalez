package TP_N9_GENERICOS.Entities;

import TP_N9_GENERICOS.Interfaces.Identificable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Comparable<Pedido>, Identificable<Integer> {
    private int id;
    private List<Producto<?>> productos = new ArrayList<>();
    private LocalDate fecha;

    public Pedido(int id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public void agregarProducto(Producto<?> producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto<?> p : productos) total += p.getPrecio();
        return total;
    }

    public LocalDate getFecha() { return fecha; }

    @Override
    public int compareTo(Pedido otro) {
        // Ordena por total (mayor total primero)
        return Double.compare(otro.calcularTotal(), this.calcularTotal());
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", fecha=" + fecha + ", total=" + calcularTotal() + ", productos=" + productos + "]";
    }

    // Implementación de Identificable<Integer>/ /
    @Override
     public Integer getID() {
        return id;
    }
    @Override
    public boolean tieneMismoID(Integer id) {
        return this.id == id;
    }
}

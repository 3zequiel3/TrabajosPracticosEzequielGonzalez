package TP_N10_ACCESO_BD.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDate fecha;
    private List<ItemPedido> items;
    private double total;

    public Pedido() {}

    public Pedido(LocalDate fecha, List<ItemPedido> items) {
        this.fecha = fecha;
        this.items = items;
        this.total = items.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    // Getters y Setters
    public int getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public List<ItemPedido> getItems() { return items; }
    public double getTotal() { return total; }
    public void setId(int id) { this.id = id; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setItems(List<ItemPedido> items) { this.items = items; }
    public void setTotal(double total) { this.total = total; }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", fecha=" + fecha + ", items=" + items + ", total=" + total + "}";
    }
}
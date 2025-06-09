package TP_N9_GENERICOS.Entities;

import java.util.ArrayList;
import java.util.List;

public class Carrito<T extends Producto>{
    private List<T> productos = new ArrayList<>();
    public void agregarProducto(T producto) {
        this.productos.add(producto);
    }
    public void eliminarProducto(T producto) {
        this.productos.remove(producto);
    }
    public double obtenerTotal(){
        double total = 0;
        for (T producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
    public void mostrarProductos() {
        for (T producto : productos) {
            System.out.println(producto);
        }
    }
}

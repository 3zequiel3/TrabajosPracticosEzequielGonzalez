package TP_N9_GENERICOS;

import TP_N9_GENERICOS.Entities.*;
import TP_N9_GENERICOS.Entities.ComparadorPedidosPorFecha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Kata 1
        Producto<String> prod1 = new Producto<>("SKU123", "Mouse", 2500.0);
        Producto<Integer> prod2 = new Producto<>(101, "Teclado", 3500.0);
        Producto<String> prod3 = new Producto<>("SKU999", "Monitor", 30000.0);

        List<Producto<?>> listaProductos = List.of(prod1, prod2, prod3);
        for (Producto<?> p : listaProductos) {
            System.out.println(p);
        }

        // Kata 2
        Carrito<Producto<?>> carrito = new Carrito<>();
        carrito.agregarProducto(prod1);
        carrito.agregarProducto(prod2);
        carrito.mostrarProductos();
        System.out.println("Total del carrito: " + carrito.obtenerTotal());
        carrito.eliminarProducto(prod1);
        carrito.mostrarProductos();

        // Kata 3
        Pedido pedido1 = new Pedido(1, LocalDate.of(2024, 6, 6));
        Pedido pedido2 = new Pedido(2, LocalDate.of(2024, 5, 20));
        Pedido pedido3 = new Pedido(3, LocalDate.of(2024, 6, 9));
        pedido1.agregarProducto(prod1);
        pedido1.agregarProducto(prod2);
        pedido2.agregarProducto(prod3);
        pedido3.agregarProducto(prod1);

        List<Pedido> pedidos = new ArrayList<>(List.of(pedido1, pedido2, pedido3));
        System.out.println("Pedidos ordenados por total (desc):");
        Collections.sort(pedidos);
        for (Pedido p : pedidos) System.out.println(p);

        System.out.println("Pedidos ordenados por fecha (asc):");
        pedidos.sort(new ComparadorPedidosPorFecha());
        for (Pedido p : pedidos) System.out.println(p);

        //Kata 4
        Buscador<Pedido, Integer> buscador = new Buscador<>();
        Pedido encontrado = buscador.buscar(pedidos, 2);
        if (encontrado != null) {
            System.out.println("Pedido encontrado: " + encontrado);
        } else {
            System.out.println("No se encontró el pedido con ese ID.");
        }


    }
}

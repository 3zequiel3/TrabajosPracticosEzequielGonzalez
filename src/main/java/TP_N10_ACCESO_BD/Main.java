package TP_N10_ACCESO_BD;
import TP_N10_ACCESO_BD.models.*;
import TP_N10_ACCESO_BD.services.*;

import java.util.*;
import java.time.*;


public class Main {
    public static void main(String[] args) {
        CategoriaServiceImpl categoriaService = new CategoriaServiceImpl();
        ProductoServiceImpl productoService = new ProductoServiceImpl();
        PedidoServiceImpl pedidoService = new PedidoServiceImpl();

        // --- CRUD Categoría ---
        System.out.println("=== CRUD de Categorías ===");
        Categoria cat1 = new Categoria("Electrónica", "Dispositivos electrónicos");
        Categoria cat2 = new Categoria("Libros", "Libros de todas las temáticas");
        categoriaService.crear(cat1);
        categoriaService.crear(cat2);

        System.out.println("Categorías en DB:");
        categoriaService.listar().forEach(System.out::println);

        // --- CRUD Producto ---
        System.out.println("\n=== CRUD de Productos ===");
        Categoria catElectro = categoriaService.listar().stream()
                .filter(c -> c.getNombre().equals("Electrónica"))
                .findFirst().orElse(null);
        Categoria catLibros = categoriaService.listar().stream()
                .filter(c -> c.getNombre().equals("Libros"))
                .findFirst().orElse(null);

        Producto p1 = new Producto("Notebook", "Laptop 16GB RAM", 300000, 5, catElectro);
        Producto p2 = new Producto("Auriculares", "Bluetooth", 12000, 10, catElectro);
        Producto p3 = new Producto("Cien años de soledad", "Gabriel García Márquez", 9000, 7, catLibros);

        productoService.crear(p1);
        productoService.crear(p2);
        productoService.crear(p3);

        System.out.println("Productos en DB:");
        productoService.listar().forEach(System.out::println);

        // --- Simulación Pedido ---
        System.out.println("\n=== Creación de Pedido ===");
        List<Producto> productos = productoService.listar();

        // Tomar productos existentes (Asegúrate que hay stock suficiente)
        Producto prodPedido1 = productos.get(0); // Notebook
        Producto prodPedido2 = productos.get(1); // Auriculares

        ItemPedido item1 = new ItemPedido(prodPedido1, 2);
        ItemPedido item2 = new ItemPedido(prodPedido2, 3);

        List<ItemPedido> itemsPedido = new ArrayList<>();
        itemsPedido.add(item1);
        itemsPedido.add(item2);

        Pedido pedido = new Pedido(LocalDate.now(), itemsPedido);

        if (pedidoService.crearPedido(pedido)) {
            System.out.println("Pedido creado exitosamente con ID: " + pedido.getId());
            pedidoService.mostrarDetallePedido(pedido.getId());
        } else {
            System.out.println("No se pudo crear el pedido (verifique stock y datos).");
        }

        // --- Mostrar todos los pedidos con detalles ---
        System.out.println("\n=== Listado de Pedidos con Detalles ===");
        for (Pedido ped : pedidoService.listar()) {
            pedidoService.mostrarDetallePedido(ped.getId());
            System.out.println("----------------------");
        }
    }
}
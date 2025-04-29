package TP_N6_COLECCIONES;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //KATA 1
        Inventario inventarioEze = new Inventario();
        cargarInventario(inventarioEze);
//      inventarioEze.ListarProductos();


        //KATA 2
        inventarioEze.AgregarProducto(new Producto("A004", "Yerba Mate", 1500.00, 80, CategoriaProducto.ALIMENTOS));
        inventarioEze.AgregarProducto(new Producto("E004", "Tablet", 90000.00, 12, CategoriaProducto.ELECTRONICA));
        inventarioEze.AgregarProducto(new Producto("R004", "Zapatillas", 20000.00, 50, CategoriaProducto.ROPA));
        inventarioEze.AgregarProducto(new Producto("H004", "Cafetera", 18000.00, 15, CategoriaProducto.HOGAR));

//      inventarioEze.BuscarProducto("H004").mostrarInfo();
        var electronica = inventarioEze.filtrarPorCategoria("ELECTRONICA");
//        for (Producto producto : electronica) {
//            producto.mostrarInfo();
//        }

        inventarioEze.EliminarProducto("E004");
//      inventarioEze.ListarProductos();

        //KATA 3
        inventarioEze.AgregarProducto(new Producto("E005", "Televisor", 500.0, 10, CategoriaProducto.ELECTRONICA));
        inventarioEze.AgregarProducto(new Producto("R005", "Camiseta", 20.0, 50, CategoriaProducto.ROPA));
        inventarioEze.AgregarProducto(new Producto("A005", "Cereal", 5.0, 30, CategoriaProducto.ALIMENTOS));
        inventarioEze.AgregarProducto(new Producto("H005", "Silla", 100.0, 15, CategoriaProducto.HOGAR));
        inventarioEze.AgregarProducto(new Producto("E006", "Laptop", 1200.0, 8, CategoriaProducto.ELECTRONICA));

        System.out.println("Total de Stock: "+ inventarioEze.ObtenerTotalStock());
        System.out.println("Prod. con + Stock: " + inventarioEze.ObtenerProductoConMayorStock());
        ArrayList <Producto> rango = inventarioEze.filtrarProductosPorPrecio(1000,3000);
        for (Producto p : rango) {
            p.mostrarInfo();
        }
        inventarioEze.mostrarCategoriasDisponibles();
    }
    public static void cargarInventario(Inventario inventario){

        //KATA 1
        // Productos de ALIMENTOS
        inventario.AgregarProducto(new Producto("A001", "Pan", 250.00, 100, CategoriaProducto.ALIMENTOS));
        inventario.AgregarProducto(new Producto("A002", "Leche", 350.00, 50, CategoriaProducto.ALIMENTOS));
        inventario.AgregarProducto(new Producto("A003", "Queso", 1200.00, 20, CategoriaProducto.ALIMENTOS));
        // Productos de ELECTRONICA
        inventario.AgregarProducto(new Producto("E001", "Smartphone", 120000.00, 15, CategoriaProducto.ELECTRONICA));
        inventario.AgregarProducto(new Producto("E002", "Notebook", 350000.00, 10, CategoriaProducto.ELECTRONICA));
        inventario.AgregarProducto(new Producto("E003", "Auriculares", 15000.00, 30, CategoriaProducto.ELECTRONICA));
        // Productos de ROPA
        inventario.AgregarProducto(new Producto("R001", "Camisa", 8000.00, 40, CategoriaProducto.ROPA));
        inventario.AgregarProducto(new Producto("R002", "Pantalón", 12000.00, 35, CategoriaProducto.ROPA));
        inventario.AgregarProducto(new Producto("R003", "Campera", 25000.00, 25, CategoriaProducto.ROPA));
        // Productos de HOGAR
        inventario.AgregarProducto(new Producto("H001", "Silla", 10000.00, 20, CategoriaProducto.HOGAR));
        inventario.AgregarProducto(new Producto("H002", "Mesa", 20000.00, 10, CategoriaProducto.HOGAR));
        inventario.AgregarProducto(new Producto("H003", "Lámpara", 5000.00, 50, CategoriaProducto.HOGAR));

    }
}

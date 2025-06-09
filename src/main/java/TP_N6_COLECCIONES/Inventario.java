package main.java.TP_N6_COLECCIONES;

import java.util.ArrayList;
import java.util.Comparator;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario(){
        this.productos = new ArrayList<>();
    }

    public void mostrarCategoriasDisponibles() {
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.println(cat.name() + ":" + cat.getDescripcion());
        }
    }

    public int ObtenerTotalStock(){
        var totalStock = 0;
        for (Producto producto : productos){
            totalStock += producto.getCantidad();
        }
        return totalStock;
    }

    public Producto ObtenerProductoConMayorStock(){
        Producto producto = null;
        int cantidadMax = Integer.MIN_VALUE;
        for (Producto p : this.productos){
            if (p.getCantidad() > cantidadMax){
                producto = p;
                cantidadMax = p.getCantidad();
            }
        }
        return producto;
    }

    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max) {
        ArrayList<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : this.productos){
            if (producto.getPrecio() >= min && producto.getPrecio() <= max){
                productosFiltrados.add(producto);
            }
        }
        productosFiltrados.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return Double.compare(o2.getPrecio(), o1.getPrecio());
        }
        }
        );
        return productosFiltrados;
    }

    public void AgregarProducto(Producto producto){
        this.productos.add(producto);
    }

    public Producto BuscarProducto(String id){
        int i = 0;
        Producto productoEncontrado = null;
        while(i < productos.size() && !this.productos.get(i).getId().equals(id)) {
            i++;
        }
        if(i<productos.size()){
            productoEncontrado = this.productos.get(i);
        }
        return productoEncontrado;
    }

    public Producto EliminarProducto(String id){
        Producto prodEliminar = BuscarProducto(id);
        if(prodEliminar != null){
            this.productos.remove(prodEliminar);
        }
        return prodEliminar;
    }

    public Producto actualizarCantidad(String ID, int nuevaCantidad){
        Producto prodActualizar = BuscarProducto(ID);
        if(prodActualizar != null){
            prodActualizar.setCantidad(nuevaCantidad);
        }
        return prodActualizar;
    }

    public ArrayList<Producto> filtrarPorCategoria(String categoria){
        ArrayList<Producto> productos = new ArrayList<>();
        for (Producto producto : this.productos) {
            if(producto.getCategoria().name().equals(categoria)){
                productos.add(producto);
            }
        }
        return productos;
    }

    public void ListarProductos(){
        for(Producto producto: this.productos){
            producto.mostrarInfo();
        }
    }
}

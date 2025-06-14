package TP_N8_INTERFACES.Entities;

import TP_N8_INTERFACES.Interfaces.Pagable;


public class Producto  implements Pagable {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto() {
    }
    public Producto(String nombre,double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 1;
    }
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        if(this.cantidad>1){
            total = this.precio*this.cantidad;
        }else{
            total = this.precio;
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder producto = new StringBuilder("Nombre: %s - Precio: %.2f - Cantidad: %d || Total : %.2f".formatted(this.nombre, this.precio, this.cantidad,calcularTotal()));
        var detalleProducto = producto.toString();
        return detalleProducto;
    }
}

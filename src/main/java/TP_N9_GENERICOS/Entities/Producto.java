package TP_N9_GENERICOS.Entities;

public class Producto <T>{
    private T id;
    private String nombre;
    private double precio;

    //Constructores

    public Producto() {
    }

    public Producto(T id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public T getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

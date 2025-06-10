package TP_N10_ACCESO_BD.models;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private Categoria categoria;

    public Producto() {}

    public Producto(int id, String nombre, String descripcion, double precio, int cantidad, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public Producto(String nombre, String descripcion, double precio, int cantidad, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public Categoria getCategoria() { return categoria; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', descripcion='" + descripcion + "', precio=" + precio + ", cantidad=" + cantidad + ", categoria=" + categoria + "}";
    }
}
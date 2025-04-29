package TP_N6_COLECCIONES;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;


    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getId() {
        return this.id;
    }
    public double getPrecio() {
        return this.precio;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public CategoriaProducto getCategoria() {
        return this.categoria;
    }

    public void mostrarInfo(){
        System.out.printf("""
                \n[\tProducto:
                Nombre: %s
                ID: %s
                Precio: %.2f
                Cantidad: %d
                Categoria: %s]
                """,this.id,this.nombre,this.precio,this.cantidad,this.categoria);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", categoria=" + categoria +
                '}';
    }
}

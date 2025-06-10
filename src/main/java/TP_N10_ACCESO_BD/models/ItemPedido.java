package TP_N10_ACCESO_BD.models;

public class ItemPedido {
    private int id;
    private Producto producto;
    private int cantidad;
    private double subtotal;

    public ItemPedido() {}

    public ItemPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.getPrecio() * cantidad;
    }

    public ItemPedido(int id, Producto producto, int cantidad, double subtotal) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Getters y Setters
    public int getId() { return id; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }
    public void setId(int id) { this.id = id; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    @Override
    public String toString() {
        return "ItemPedido{id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "}";
    }
}
package TP_N8_INTERFACES.Entities;

import TP_N8_INTERFACES.Enums.EstadoPedido;
import TP_N8_INTERFACES.Interfaces.Notificable;
import TP_N8_INTERFACES.Interfaces.Pagable;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable{
    private Cliente cliente;
    private List<Producto> productos;
    private EstadoPedido estadoPedido;

    public Pedido() {
        this.productos = new ArrayList<>();
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public String getNombreCliente() {
        return cliente.getNombre();
    }
    public Pedido(List<Producto> productos) {
        this.productos = new ArrayList<>();
    }

    public void crearPedido(){
        System.out.println("Creando Pedido");
    }
    public List<Producto> getProductos() {
        return this.productos;
    }

    public void añadirProductos(Producto producto) {
        this.productos.add(producto);
    }
    public void cambiarEstado(EstadoPedido estadoPedido) {
        if(estadoPedido == null){
            this.estadoPedido = EstadoPedido.EN_DESPACHO;
            this.cliente.setNotificacion(EstadoPedido.EN_DESPACHO.getMensaje());
        }else if (estadoPedido == EstadoPedido.EN_DESPACHO) {
            this.estadoPedido = EstadoPedido.ENVIADO;
            this.cliente.setNotificacion(EstadoPedido.ENVIADO.getMensaje());
        }else if (estadoPedido == EstadoPedido.ENVIADO) {
            this.estadoPedido = EstadoPedido.RECIBIDO;
            this.cliente.setNotificacion(EstadoPedido.RECIBIDO.getMensaje());
        }else if (estadoPedido == EstadoPedido.RECIBIDO) {
            this.cliente.setNotificacion("Su pedido ya ha sido enviado y recibido...");
        }
    }
    public String mostrarEstado() {
        String mensaje = estadoPedido.getMensaje();
        return mensaje;
    }

    @Override
    public String toString() {
        StringBuilder menu = new StringBuilder("""
                \tPedido del Cliente 
                %s
                Productos:
                
                """.formatted(cliente.getNombre()));
        for (Producto producto : this.productos) {
            menu.append("\t").append(producto.toString()).append("\n");
        }
        return menu.toString();
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularTotal();
        }
        return total;
    }
}

package TP_N8_INTERFACES.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ecommerce{
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private Map<String,Integer> cupones = new HashMap<>();

    public Ecommerce() {
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Ecommerce(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Map<String, Integer> getCupones() {
        return cupones;
    }

    private boolean existeCupon(String cupon){
        return cupones.containsKey(cupon);
    }

    public void añadirCupon(String codigo, int descuento){
        if(existeCupon(codigo)){
            System.out.println("Ese cupon ya existe");
        }else{
            if(descuento>0 && descuento<=100){
                cupones.put(codigo,descuento);
            }
        }
    }


    public void añadirPedidos(Pedido pedido) {
        if(this.pedidos != null){
            this.pedidos.add(pedido);
        }
    }

    public void añadirProducto(Producto producto) {
        if(producto != null){
            this.productos.add(producto);
        }
    }
}

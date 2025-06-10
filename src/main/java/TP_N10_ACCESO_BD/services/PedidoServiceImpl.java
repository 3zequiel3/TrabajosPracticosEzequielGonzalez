package TP_N10_ACCESO_BD.services;

import TP_N10_ACCESO_BD.dao.PedidoDAOImpl;
import TP_N10_ACCESO_BD.dao.ProductoDAOImpl;
import TP_N10_ACCESO_BD.models.ItemPedido;
import TP_N10_ACCESO_BD.models.Pedido;
import TP_N10_ACCESO_BD.models.Producto;

import java.util.List;

public class PedidoServiceImpl implements GenericService<Pedido> {
    private final PedidoDAOImpl dao = new PedidoDAOImpl();
    private final ProductoDAOImpl productoDao = new ProductoDAOImpl();

    @Override
    public boolean crear(Pedido pedido) {
        // Usar crearPedido para validaciones extra
        return crearPedido(pedido);
    }

    @Override
    public Pedido leer(int id) { return dao.leer(id); }

    @Override
    public boolean actualizar(Pedido pedido) { return dao.actualizar(pedido); }

    @Override
    public boolean eliminar(int id) { return dao.eliminar(id); }

    @Override
    public List<Pedido> listar() { return dao.listar(); }

    // Lógica de negocio
    public boolean crearPedido(Pedido pedido) {
        if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
            System.out.println("El pedido debe tener al menos un ítem.");
            return false;
        }
        for (ItemPedido item : pedido.getItems()) {
            if (item.getCantidad() <= 0) {
                System.out.println("Cantidad del ítem debe ser mayor a cero.");
                return false;
            }
            Producto prod = productoDao.leer(item.getProducto().getId());
            if (prod == null) {
                System.out.println("Producto no existe: " + item.getProducto().getId());
                return false;
            }
            if (prod.getCantidad() < item.getCantidad()) {
                System.out.println("Stock insuficiente para el producto: " + prod.getNombre());
                return false;
            }
        }
        // Descontar stock
        for (ItemPedido item : pedido.getItems()) {
            Producto prod = productoDao.leer(item.getProducto().getId());
            prod.setCantidad(prod.getCantidad() - item.getCantidad());
            productoDao.actualizar(prod);
        }
        return dao.crear(pedido);
    }

    public void mostrarDetallePedido(int pedidoId) {
        Pedido pedido = dao.leer(pedidoId);
        if (pedido == null) {
            System.out.println("Pedido no encontrado");
            return;
        }
        System.out.println("Detalle del Pedido #" + pedido.getId());
        for (ItemPedido item : pedido.getItems()) {
            System.out.println("- Producto: " + item.getProducto().getNombre() +
                    ", Categoría: " + item.getProducto().getCategoria().getNombre() +
                    ", Cantidad: " + item.getCantidad() +
                    ", Subtotal: $" + item.getSubtotal());
        }
        System.out.println("Total del pedido: $" + pedido.getTotal());
    }
}
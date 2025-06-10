package TP_N10_ACCESO_BD.dao;

import TP_N10_ACCESO_BD.config.Data;
import TP_N10_ACCESO_BD.models.Categoria;
import TP_N10_ACCESO_BD.models.ItemPedido;
import TP_N10_ACCESO_BD.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAOImpl implements GenericDAO<ItemPedido> {

    @Override
    public boolean crear(ItemPedido item) {
        String sql = "INSERT INTO items_pedido (pedido_id, producto_id, cantidad, subtotal) VALUES (?, ?, ?, ?)";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, item.getProducto().getId());
            ps.setInt(2, item.getProducto().getId());
            ps.setInt(3, item.getCantidad());
            ps.setDouble(4, item.getSubtotal());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) item.setId(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error creando item_pedido: " + e.getMessage());
        }
        return false;
    }

    @Override
    public ItemPedido leer(int id) {
        String sql = "SELECT i.*, p.nombre as pnombre, p.descripcion as pdesc, p.precio, p.cantidad as pstock, c.id as cid, c.nombre as cnombre, c.descripcion as cdesc " +
                "FROM items_pedido i " +
                "JOIN productos p ON i.producto_id = p.id " +
                "JOIN categorias c ON p.id_categoria = c.id " +
                "WHERE i.id = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Categoria cat = new Categoria(
                            rs.getInt("cid"),
                            rs.getString("cnombre"),
                            rs.getString("cdesc")
                    );
                    Producto prod = new Producto(
                            rs.getInt("producto_id"),
                            rs.getString("pnombre"),
                            rs.getString("pdesc"),
                            rs.getDouble("precio"),
                            rs.getInt("pstock"),
                            cat
                    );
                    ItemPedido item = new ItemPedido(
                            rs.getInt("id"),
                            prod,
                            rs.getInt("cantidad"),
                            rs.getDouble("subtotal")
                    );
                    item.getProducto().setId(rs.getInt("pedido_id"));
                    return item;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error leyendo item_pedido: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(ItemPedido item) {
        String sql = "UPDATE items_pedido SET cantidad=?, subtotal=? WHERE id=?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, item.getCantidad());
            ps.setDouble(2, item.getSubtotal());
            ps.setInt(3, item.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error actualizando item_pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM items_pedido WHERE id = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error eliminando item_pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<ItemPedido> listar() {
        List<ItemPedido> lista = new ArrayList<>();
        String sql = "SELECT i.*, p.nombre as pnombre, p.descripcion as pdesc, p.precio, p.cantidad as pstock, c.id as cid, c.nombre as cnombre, c.descripcion as cdesc " +
                "FROM items_pedido i " +
                "JOIN productos p ON i.producto_id = p.id " +
                "JOIN categorias c ON p.id_categoria = c.id";
        try (Connection conn = Data.getDataSource().getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Categoria cat = new Categoria(
                        rs.getInt("cid"),
                        rs.getString("cnombre"),
                        rs.getString("cdesc")
                );
                Producto prod = new Producto(
                        rs.getInt("producto_id"),
                        rs.getString("pnombre"),
                        rs.getString("pdesc"),
                        rs.getDouble("precio"),
                        rs.getInt("pstock"),
                        cat
                );
                ItemPedido item = new ItemPedido(
                        rs.getInt("id"),
                        prod,
                        rs.getInt("cantidad"),
                        rs.getDouble("subtotal")
                );
                item.getProducto().setId(rs.getInt("pedido_id"));
                lista.add(item);
            }
        } catch (SQLException e) {
            System.err.println("Error listando items_pedido: " + e.getMessage());
        }
        return lista;
    }

    public List<ItemPedido> listarPorPedido(int pedidoId) {
        List<ItemPedido> lista = new ArrayList<>();
        String sql = "SELECT i.*, p.nombre as pnombre, p.descripcion as pdesc, p.precio, p.cantidad as pstock, c.id as cid, c.nombre as cnombre, c.descripcion as cdesc " +
                "FROM items_pedido i " +
                "JOIN productos p ON i.producto_id = p.id " +
                "JOIN categorias c ON p.id_categoria = c.id " +
                "WHERE i.pedido_id = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Categoria cat = new Categoria(
                            rs.getInt("cid"),
                            rs.getString("cnombre"),
                            rs.getString("cdesc")
                    );
                    Producto prod = new Producto(
                            rs.getInt("producto_id"),
                            rs.getString("pnombre"),
                            rs.getString("pdesc"),
                            rs.getDouble("precio"),
                            rs.getInt("pstock"),
                            cat
                    );
                    ItemPedido item = new ItemPedido(
                            rs.getInt("id"),
                            prod,
                            rs.getInt("cantidad"),
                            rs.getDouble("subtotal")
                    );
                    item.getProducto().setId(rs.getInt("pedido_id"));
                    lista.add(item);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error listando items_pedido por pedido: " + e.getMessage());
        }
        return lista;
    }
}
package TP_N10_ACCESO_BD.dao;

import TP_N10_ACCESO_BD.config.Data;
import TP_N10_ACCESO_BD.models.ItemPedido;
import TP_N10_ACCESO_BD.models.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImpl implements GenericDAO<Pedido> {

    private final ItemPedidoDAOImpl itemDao = new ItemPedidoDAOImpl();

    @Override
    public boolean crear(Pedido pedido) {
        String sql = "INSERT INTO pedidos (fecha, total) VALUES (?, ?)";
        Connection conn = null;
        try {
            conn = Data.getDataSource().getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDate(1, Date.valueOf(pedido.getFecha()));
                ps.setDouble(2, pedido.getTotal());
                int filas = ps.executeUpdate();
                if (filas > 0) {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) pedido.setId(rs.getInt(1));
                    }
                    // Insertar items
                    for (ItemPedido item : pedido.getItems()) {
                        item.getProducto().setId(pedido.getId());
                        String itemSql = "INSERT INTO items_pedido (pedido_id, producto_id, cantidad, subtotal) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement psi = conn.prepareStatement(itemSql)) {
                            psi.setInt(1, item.getProducto().getId());
                            psi.setInt(2, item.getProducto().getId());
                            psi.setInt(3, item.getCantidad());
                            psi.setDouble(4, item.getSubtotal());
                            psi.executeUpdate();
                        }
                    }
                    conn.commit();
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error creando pedido: " + e.getMessage());
            if (conn != null) try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (conn != null) try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Pedido leer(int id) {
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setId(rs.getInt("id"));
                    pedido.setFecha(rs.getDate("fecha").toLocalDate());
                    pedido.setTotal(rs.getDouble("total"));
                    pedido.setItems(itemDao.listarPorPedido(pedido.getId()));
                    return pedido;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error leyendo pedido: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Pedido pedido) {
        String sql = "UPDATE pedidos SET fecha=?, total=? WHERE id=?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(pedido.getFecha()));
            ps.setDouble(2, pedido.getTotal());
            ps.setInt(3, pedido.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error actualizando pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error eliminando pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Pedido> listar() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        try (Connection conn = Data.getDataSource().getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setFecha(rs.getDate("fecha").toLocalDate());
                pedido.setTotal(rs.getDouble("total"));
                pedido.setItems(itemDao.listarPorPedido(pedido.getId()));
                lista.add(pedido);
            }
        } catch (SQLException e) {
            System.err.println("Error listando pedidos: " + e.getMessage());
        }
        return lista;
    }
}
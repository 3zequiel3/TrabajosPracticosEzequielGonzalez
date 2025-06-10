package TP_N10_ACCESO_BD.dao;

import TP_N10_ACCESO_BD.config.Data;
import TP_N10_ACCESO_BD.models.Categoria;
import TP_N10_ACCESO_BD.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements GenericDAO<Producto> {

    @Override
    public boolean crear(Producto p) {
        String sql = "INSERT INTO productos (nombre, descripcion, precio, cantidad, id_categoria) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.setInt(5, p.getCategoria().getId());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) p.setId(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error creando producto: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Producto leer(int id) {
        String sql = "SELECT p.*, c.id as cid, c.nombre as cnombre, c.descripcion as cdesc FROM productos p JOIN categorias c ON p.id_categoria = c.id WHERE p.id = ?";
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
                    return new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getDouble("precio"),
                            rs.getInt("cantidad"),
                            cat
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error leyendo producto: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Producto p) {
        String sql = "UPDATE productos SET nombre=?, descripcion=?, precio=?, cantidad=?, id_categoria=? WHERE id=?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.setInt(5, p.getCategoria().getId());
            ps.setInt(6, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error actualizando producto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error eliminando producto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.id as cid, c.nombre as cnombre, c.descripcion as cdesc FROM productos p JOIN categorias c ON p.id_categoria = c.id";
        try (Connection conn = Data.getDataSource().getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Categoria cat = new Categoria(
                        rs.getInt("cid"),
                        rs.getString("cnombre"),
                        rs.getString("cdesc")
                );
                lista.add(new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad"),
                        cat
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error listando productos: " + e.getMessage());
        }
        return lista;
    }

    public List<Producto> listarPorCategoria(int idCategoria) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.id as cid, c.nombre as cnombre, c.descripcion as cdesc FROM productos p JOIN categorias c ON p.id_categoria = c.id WHERE p.id_categoria = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Categoria cat = new Categoria(
                            rs.getInt("cid"),
                            rs.getString("cnombre"),
                            rs.getString("cdesc")
                    );
                    lista.add(new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getDouble("precio"),
                            rs.getInt("cantidad"),
                            cat
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error listando productos por categoria: " + e.getMessage());
        }
        return lista;
    }

    public boolean existeCategoria(int idCategoria) {
        String sql = "SELECT 1 FROM categorias WHERE id = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Error comprobando existencia de categoria: " + e.getMessage());
        }
        return false;
    }
}
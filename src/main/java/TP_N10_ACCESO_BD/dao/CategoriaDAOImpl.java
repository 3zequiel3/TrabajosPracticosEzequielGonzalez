package TP_N10_ACCESO_BD.dao;

import TP_N10_ACCESO_BD.config.Data;
import TP_N10_ACCESO_BD.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements GenericDAO<Categoria> {

    @Override
    public boolean crear(Categoria c) {
        String sql = "INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error creando categoria: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Categoria leer(int id) {
        String sql = "SELECT * FROM categorias WHERE id = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Categoria(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error leyendo categoria: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Categoria c) {
        String sql = "UPDATE categorias SET nombre=?, descripcion=? WHERE id=?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error actualizando categoria: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error eliminando categoria: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Connection conn = Data.getDataSource().getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Categoria(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion")));
            }
        } catch (SQLException e) {
            System.err.println("Error listando categorias: " + e.getMessage());
        }
        return lista;
    }

    public boolean existeNombre(String nombre) {
        String sql = "SELECT 1 FROM categorias WHERE nombre = ?";
        try (Connection conn = Data.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Error comprobando nombre de categoria: " + e.getMessage());
            return false;
        }
    }
}
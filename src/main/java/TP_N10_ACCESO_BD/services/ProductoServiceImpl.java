package TP_N10_ACCESO_BD.services;

import TP_N10_ACCESO_BD.dao.CategoriaDAOImpl;
import TP_N10_ACCESO_BD.dao.ProductoDAOImpl;
import TP_N10_ACCESO_BD.models.Producto;

import java.util.List;

public class ProductoServiceImpl implements GenericService<Producto> {
    private final ProductoDAOImpl dao = new ProductoDAOImpl();
    private final CategoriaDAOImpl categoriaDao = new CategoriaDAOImpl();

    @Override
    public boolean crear(Producto p) {
        if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return false;
        }
        if (p.getPrecio() <= 0) {
            System.out.println("El precio debe ser mayor a cero.");
            return false;
        }
        if (p.getCantidad() <= 0) {
            System.out.println("La cantidad debe ser mayor a cero.");
            return false;
        }
        if (p.getCategoria() == null || !categoriaDao.leer(p.getCategoria().getId()).getNombre().equals(p.getCategoria().getNombre())) {
            System.out.println("La categoría no existe.");
            return false;
        }
        return dao.crear(p);
    }

    @Override
    public Producto leer(int id) { return dao.leer(id); }

    @Override
    public boolean actualizar(Producto p) {
        if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return false;
        }
        if (p.getPrecio() <= 0) {
            System.out.println("El precio debe ser mayor a cero.");
            return false;
        }
        if (p.getCantidad() <= 0) {
            System.out.println("La cantidad debe ser mayor a cero.");
            return false;
        }
        if (p.getCategoria() == null || !categoriaDao.leer(p.getCategoria().getId()).getNombre().equals(p.getCategoria().getNombre())) {
            System.out.println("La categoría no existe.");
            return false;
        }
        return dao.actualizar(p);
    }

    @Override
    public boolean eliminar(int id) { return dao.eliminar(id); }

    @Override
    public List<Producto> listar() { return dao.listar(); }

    public List<Producto> listarPorCategoria(int idCategoria) { return dao.listarPorCategoria(idCategoria); }
}
package TP_N10_ACCESO_BD.services;


import TP_N10_ACCESO_BD.dao.CategoriaDAOImpl;
import TP_N10_ACCESO_BD.models.Categoria;

import java.util.List;

public class CategoriaServiceImpl implements GenericService<Categoria> {
    private final CategoriaDAOImpl dao = new CategoriaDAOImpl();

    @Override
    public boolean crear(Categoria c) {
        if (c.getNombre() == null || c.getNombre().trim().isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return false;
        }
        if (dao.existeNombre(c.getNombre())) {
            System.out.println("Ya existe una categoría con ese nombre.");
            return false;
        }
        return dao.crear(c);
    }

    @Override
    public Categoria leer(int id) { return dao.leer(id); }

    @Override
    public boolean actualizar(Categoria c) {
        if (c.getNombre() == null || c.getNombre().trim().isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return false;
        }
        return dao.actualizar(c);
    }

    @Override
    public boolean eliminar(int id) { return dao.eliminar(id); }

    @Override
    public List<Categoria> listar() { return dao.listar(); }
}
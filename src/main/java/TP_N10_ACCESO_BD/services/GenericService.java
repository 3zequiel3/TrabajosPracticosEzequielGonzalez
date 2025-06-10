package TP_N10_ACCESO_BD.services;

import java.util.List;

public interface GenericService<T> {
    boolean crear(T t);
    T leer(int id);
    boolean actualizar(T t);
    boolean eliminar(int id);
    List<T> listar();
}
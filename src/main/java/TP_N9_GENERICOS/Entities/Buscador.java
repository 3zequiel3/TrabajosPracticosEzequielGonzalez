package TP_N9_GENERICOS.Entities;

import TP_N9_GENERICOS.Interfaces.Identificable;

import java.util.Collection;

public class Buscador<T extends Identificable<K>, K> {
    public T buscar(Collection<? extends T> elementos, K id) {
        for (T elem : elementos) {
            if (elem.tieneMismoID(id)) {
                return elem;
            }
        }
        return null;
    }
}


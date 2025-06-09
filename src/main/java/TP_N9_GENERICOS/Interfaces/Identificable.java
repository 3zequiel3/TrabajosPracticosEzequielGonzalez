package TP_N9_GENERICOS.Interfaces;

public interface Identificable<K> {
    K getID();
    boolean tieneMismoID(K id);
}

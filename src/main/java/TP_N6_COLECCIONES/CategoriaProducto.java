package main.java.TP_N6_COLECCIONES;

public enum CategoriaProducto {
    ALIMENTOS("Alimentos comestibles"),
    ELECTRONICA("Dispositivos Electronicos"),
    ROPA("Prendas para vestir"),
    HOGAR("Articulos para el hogar");



    private final String descripcion;


    CategoriaProducto(String descripcion){
        this.descripcion = descripcion;
    }


    public String getDescripcion(){
        return this.descripcion;
    }
}

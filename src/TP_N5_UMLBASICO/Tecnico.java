package TP_N5_UMLBASICO;

public class Tecnico {
    private static int contador = 1;
    private int id;
    private String nombre;
    private String especialidad;

    public Tecnico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.id = contador++;
    }

    public void agregarTecnico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    public String pasarNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return "Tecnico : " + this.nombre + " | Especialidad: " + this.especialidad;
    }
}

package TP_N7_HERENCIA_POLIMORFISMO;

public abstract class Empleado {
    private int DNI;
    private String nombre;
    private String apellido;
    private int anioIngreso;

    public Empleado(int DNI, String nombre, String apellido, int anioIngreso) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioIngreso = anioIngreso;
    }
    public String nombreCompleto() {
        return this.nombre +" "+ this.apellido;
    }
    public int antiguedadEnAnios() {
        return 2025-anioIngreso;
    }
    public abstract double getSalario();
}

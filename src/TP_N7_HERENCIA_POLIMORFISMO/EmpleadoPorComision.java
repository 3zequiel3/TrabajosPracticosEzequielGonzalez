package TP_N7_HERENCIA_POLIMORFISMO;

public class EmpleadoPorComision extends Empleado{
    private final int MONTO_POR_CLIENTE = 500;
    private final double SALARIO_MIN= 30000;

    private int cantidadClientes;

    public EmpleadoPorComision(int DNI, String nombre, String apellido, int anioIngreso, int cantidadClientes) {
        super(DNI, nombre, apellido, anioIngreso);
        this.cantidadClientes = cantidadClientes;
    }

    public int getCantidadClientes() {
        return this.cantidadClientes;
    }

    @Override
    public double getSalario() {
        double salarioTotal = this.SALARIO_MIN;
        if (cantidadClientes !=0 && cantidadClientes > 1) {
            double salarioComision = this.cantidadClientes * this.MONTO_POR_CLIENTE;
            if(salarioComision>salarioTotal){
                salarioTotal = salarioComision;
            }
        }
        return salarioTotal;
    }

}

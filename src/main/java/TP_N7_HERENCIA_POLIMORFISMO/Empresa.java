package main.java.TP_N7_HERENCIA_POLIMORFISMO;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados;
    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarSalario() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.nombreCompleto()+": $" + empleado.getSalario());
        }
    }
    public Empleado empleadoConMasClientes() {
        double max = Double.MIN_VALUE;
        Empleado conMasClientes = null;
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoPorComision) {
                EmpleadoPorComision emp = (EmpleadoPorComision) empleado;
                double cant = emp.getCantidadClientes();
                if (cant>max) {
                    max = cant;
                    conMasClientes = empleado;
                }
            }
        }
        return conMasClientes;
    }
}

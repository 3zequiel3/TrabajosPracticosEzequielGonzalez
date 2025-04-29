package TP_N7_HERENCIA_POLIMORFISMO;

public class Principal {
    public static void main(String[] args) {
        Empresa emp = new Empresa();

        emp.agregarEmpleado(new EmpleadoPorComision(4578,"Fake","Name", 2016,500));
        emp.agregarEmpleado(new EmpleadoPorComision(4678, "Fake","Name", 2024,150));

        emp.agregarEmpleado(new EmpleadoSalarioFijo(8524,"Fake","Name",2022));
        emp.agregarEmpleado(new EmpleadoSalarioFijo(8681,"Fake","Name",2008));
        emp.mostrarSalario();
        System.out.println("El empleado con mas clientes es: "+emp.empleadoConMasClientes().nombreCompleto());
    }
}

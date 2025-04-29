package TP_N7;

public class Principal {
    public static void main(String[] args) {
        Empresa emp = new Empresa();

        emp.agregarEmpleado(new EmpleadoPorComision(4578,"Ezequiel","Gonzalez", 2016,500));
        emp.agregarEmpleado(new EmpleadoPorComision(4678, "Luca","Trione", 2024,150));

        emp.agregarEmpleado(new EmpleadoSalarioFijo(8524,"Joaquin","Monasa",2022));
        emp.agregarEmpleado(new EmpleadoSalarioFijo(8681,"Enzo","Cercola",2008));
        emp.mostrarSalario();
        System.out.println("El empleado con mas clientes es: "+emp.empleadoConMasClientes().nombreCompleto());
    }
}

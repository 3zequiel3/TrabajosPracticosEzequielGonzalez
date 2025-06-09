package main.java.TP_N7_HERENCIA_POLIMORFISMO;

public class EmpleadoSalarioFijo extends Empleado{
    private final double SUELDO_BASICO = 50000;

    public EmpleadoSalarioFijo(int DNI, String nombre, String apellido, int anioIngreso) {
        super(DNI, nombre, apellido, anioIngreso);
    }


    public double getPorAdicional(){
        int antiguedad = antiguedadEnAnios();
        double porc = 0;
        if (antiguedad >= 2 && antiguedad <= 5){
            porc = 0.05;
        } else if (antiguedad>5) {
            porc = 0.10;
        }
        return porc;
    }

    @Override
    public double getSalario() {
        return SUELDO_BASICO +(this.getPorAdicional()*this.SUELDO_BASICO);
    }
}

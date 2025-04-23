package TP_N4;
class Empleado{
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados;
    private static int contadorId;

    //Constructores
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;

        if (id >= Empleado.contadorId) {
            Empleado.contadorId = id + 1;
        }

        Empleado.totalEmpleados++;
    }

    public Empleado(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.id = Empleado.contadorId++;
        this.salario = 1500.00;
        Empleado.totalEmpleados++;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double actualizarSalario( double porcentaje) {
        if (porcentaje >0) {
            double porcentajeFinal = (porcentaje / 100) * this.salario;
            this.salario += porcentajeFinal;
            System.out.println("Salario actualizado en un " + porcentaje +"%" + " para el empleado " + this.nombre);
        }else{
            System.out.println("El porcentaje no puede ser menor que 0");
        }
        System.out.print("El suelto queda en : ");
        return + this.salario;
    };

    public double actualizarSalario(int cantidad) {
        if (cantidad>0) {
            this.salario += cantidad;
            System.out.println("Salario actualizado en  " +cantidad + " para el empleado " + this.nombre);

        }else{
            System.out.println("La cantidad no puede ser menor que 0");
        }
        System.out.print("El suelto queda en : ");
        return this.salario;
    }

    public static int mostrarTotalEmpleados(){
      return Empleado.totalEmpleados;
    };

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                '}';
    }

}
public class Ejercicio1 {
    public static void main(String[] args) {
        // 1)
        Empleado empleado1 = new Empleado(1,"Ezequiel","Programador",1500);
        Empleado empleado2 = new Empleado("Maria","Ingeniera en software");
        System.out.println(empleado1);
        System.out.println(empleado2);

        // 2)
        System.out.println(empleado1.actualizarSalario(1500));
        System.out.println(empleado2.actualizarSalario(40.0));
        System.out.println(empleado1);
        System.out.println(empleado2);

        //3
        System.out.println(empleado1.mostrarTotalEmpleados());
    }
}

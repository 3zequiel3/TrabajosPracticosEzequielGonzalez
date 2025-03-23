package TP_N3;

import java.util.Scanner;

class Estudiante {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void mostrarInfo(){
        System.out.println("Apellido del estudiante: "+apellido+"\n Nombre del estudiante: " + nombre+"\n Curso:"+curso+"\n Calificacion: "+calificacion);
    }

    public void subirCalificacion(double puntos){
        if(this.calificacion+puntos<=10){
            this.calificacion+=puntos;
        }
        else if (this.calificacion + puntos<=0){
            this.calificacion = 0.0;
        }else{
            this.calificacion = 10.0;
        }
    }

    public void bajarCalificacion(double puntos){
        if(this.calificacion-puntos>=0 && this.calificacion+puntos<=10){
            this.calificacion-=puntos;
        }else{
            this.calificacion = 0.0;
        }
    }

}
public class Ejercicio1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiante estudiante1 = new Estudiante();
        mostrarMenu();
        int opcion = scanner.nextInt();
        try {
            opciones(opcion, estudiante1);
        }catch(Exception e){
            System.out.println("Se ha producido un error de tipo: "+e.getMessage());
        }

    }

    public static void mostrarMenu(){
        System.out.println("""
                Que deseas hacer?:
                1.Mostrar Informacion
                2.Subir Informacion
                3.Bajar Calificacion
                4.Subir Calificacion
                """);
    }
    public static void opciones(int opcion, Estudiante estudiante1){
        Scanner scanner = new Scanner(System.in);
        switch(opcion){
            case 1-> estudiante1.mostrarInfo();
            case 2->{
                try {
                    System.out.print("\tDime el nombre del estudiante: ");
                    var nombre = scanner.nextLine();
                    System.out.println(" ");
                    System.out.print("\tDime el apellido del estudiante: ");
                    var apellido = scanner.nextLine();
                    System.out.println(" ");
                    System.out.print("\tDime el curso: ");
                    var curso = scanner.nextLine();
                    System.out.println(" ");
                    System.out.print("\tDime el calificacion: ");
                    var calificacion = scanner.nextDouble();
                    System.out.println(" ");
                    estudiante1.setNombre(nombre);
                    estudiante1.setApellido(apellido);
                    estudiante1.setCurso(curso);
                    estudiante1.setCalificacion(calificacion);
                    System.out.println(" ");
                } catch (Exception e) {
                    System.out.println("Se ha producido un error de tipo: "+e.getMessage());
                }

            }
            case 3->{
                try {
                    var puntos = scanner.nextDouble();
                    System.out.print("Cuantos puntos le bajaras al estudiante: ");
                    estudiante1.bajarCalificacion(puntos);
                    System.out.println(" ");
                }catch(Exception e){
                    System.out.println("Se ha producido un error de tipo: "+ e.getMessage());
                }

            }
            case 4->{
                try {
                    var puntos = scanner.nextDouble();
                    System.out.print("Cuantos puntos le subiras al estudiante: ");
                    estudiante1.subirCalificacion(puntos);
                    System.out.println(" ");
                }catch(Exception e){
                    System.out.println("Se ha producido un error de tipo: "+ e.getMessage());
                }

            }
            default -> System.out.println("Ingresa una opcion valida");
        }

    }

}
package TP_N3;

import java.util.Scanner;

class Mascota{
    private String nombre = "Desconocido";
    private String especie = "Desconocido";
    private int edad = 0;

    public Mascota() {
    }
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void mostrarInfo(){
        System.out.printf("""
                Nombre: %s
                Especie: %s
                Edad: %d""", nombre, especie, edad);
    }
    public void cumplirAnios(){
        this.edad+=1;
    }
    //Getter y Setter

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mascota mascota = new Mascota();

        boolean condicion = false;

        try{
            while(!condicion){
                mostrarMenu();
                var opcion = opciones(scanner, mascota);
                if (opcion == 4){
                    condicion = true;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
    public static void mostrarMenu(){
        System.out.println("""
                \n
                Menu de Mascotas:
                1.Ingresar Mascota
                2.Mostrar Mascota
                3.Cumplir años de la mascota
                4.Salir""");
    }
    public static int opciones(Scanner scanner, Mascota mascota) {
        int opcion;
        System.out.println("Elije tu opcion: ");
        opcion = scanner.nextInt();
        switch(opcion){
            case 1-> {
                ingresarMascota(mascota,scanner);
            }
            case 2-> {
                mostrarMascota(mascota);
            }
            case 3-> {
                cumpleaniosMascota(mascota);
            }
            case 4-> {
                System.out.println("Saliendo...");
                return opcion;
            }
            default -> System.out.println("Opcion no valida");
        }
        return opcion;
    }
    public static void ingresarMascota(Mascota mascota,Scanner scanner) {
        System.out.println("\tIngresar datos de la mascota");
        scanner.nextLine();
        System.out.println("Ingrese el nombre: ");
        var nombre = scanner.nextLine();
        mascota.setNombre(nombre);
        System.out.println("Ingrese la especie: ");
        var especie = scanner.nextLine();
        mascota.setEspecie(especie);
        System.out.println("Ingrese la edad: ");
        var edad = scanner.nextInt();


        mascota.setEdad(edad);
    }
    public static void mostrarMascota(Mascota mascota) {
        mascota.mostrarInfo();
    }
    public static void cumpleaniosMascota(Mascota mascota) {
        System.out.printf("Feliz cumpleaños %s", mascota.getNombre());
        mascota.cumplirAnios();
    }
}

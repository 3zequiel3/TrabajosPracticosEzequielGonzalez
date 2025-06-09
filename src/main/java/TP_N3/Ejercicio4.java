package main.java.TP_N3;

import java.util.ArrayList;
import java.util.Scanner;

class Gallina{
    private static int contador = 0;
    private int idGallina;
    private int edad;
    private int huevosPuestos;

    public Gallina() {
        this.idGallina = ++contador;
    }
    public Gallina(int edad, int huevosPuestos) {
        this.idGallina = ++contador;
        this.edad = edad;
        this.huevosPuestos = huevosPuestos;
    }

    public int getIdGallina() {
        return idGallina;
    }


    //Metodos
    public void ponerHuevo(){
        this.huevosPuestos++;
    }
    public void envejecer(){
        this.edad++;
    }
    public void mostrarEstado(){
        System.out.printf("""
                -------------------
                Estado:
                ID: %d
                Edad: %d
                Huevos Puestos: %d
                -------------------
                \n""",idGallina,edad,huevosPuestos);
    }
}


public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayList<Gallina> gallinas= new ArrayList<>();
        try {
            boolean condicion=false;
            while(!condicion){
                menu();
                var opcion = opciones(scanner,gallinas);
                if (opcion == 4){
                    condicion=true;
                }
            }


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
    public static void menu() {
        System.out.println("""
                \n
                \tMenu de la Granja:
                1.Crear una gallina
                2.Mostrar las gallinas
                3.Acciones de la gallina
                4.Salir""");
    }
    public static int opciones(Scanner scanner,ArrayList<Gallina> gallinas) {
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1->{
                Gallina gallinanueva = new Gallina();
                gallinas.add(gallinanueva);
            }
            case 2->{
                if (gallinas.isEmpty()) {
                    System.out.println("No hay gallinas");
                }else{
                    for (Gallina gallina : gallinas) {
                        gallina.mostrarEstado();
                    }
                }
            }
            case 3->{
                accionesGallina(gallinas,scanner);
            }
            case 4->{
                System.out.printf("Saliendo......");
            }
            default -> System.out.println("Opcion no valida");
        }
        return opcion;
    }
    public static void accionesGallina(ArrayList<Gallina> gallinas, Scanner scanner) {
        System.out.println("Ingresa el ID de la gallina:");
        int idBusqueda = scanner.nextInt();
        Gallina gallinaSeleccionada = buscarGallina(gallinas,idBusqueda);
        if (gallinaSeleccionada != null) {
            System.out.printf("Acciones realizadas para la gallina con ID: %d",gallinaSeleccionada.getIdGallina());
            System.out.printf("""
                    Que acciones deseas realizar para la gallina %d?
                    1.Poner Huevos
                    2.Envejecer""");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1->{
                    gallinaSeleccionada.ponerHuevo();
                }
                case 2->{
                    gallinaSeleccionada.envejecer();
                }
                default -> System.out.println("Opcion no valida");
            }
        }else {
            System.out.println("No se encontro una gallina con ese ID");
        }
    }
    public static Gallina buscarGallina(ArrayList<Gallina> gallinas, int idBusqueda) {
        for(Gallina gallina : gallinas) {
            if(gallina.getIdGallina() == idBusqueda) {
                System.out.println("Gallina encontrada....");
                System.out.println("Realizando acciones....");
                return gallina;
            }
        }
        return null;
    }
}

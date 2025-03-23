package TP_N3;

import java.util.Scanner;

class Libro{
    private String titulo = "Desconocido";
    private String autor = "Desconocido";
    private int anioPublicacion = 0;

    public Libro() {
    }
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion >= 1900 && anioPublicacion <= 2100) {
            this.anioPublicacion = anioPublicacion;
        }else {
            System.out.println("Ingresa una fecha valida");
        }
    }
}
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Libro libro = new Libro();
        boolean condition = false;
        try {
            while (!condition) {
                menu();
                int opcion = opciones(scanner,libro);
                if(opcion == 3){
                    condition = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al ingresar el libro" + e.getMessage());
        }
        scanner.close();
    }

    public static int opciones(Scanner scanner, Libro libro) {
        int opcion = 0;
        System.out.println("Ingrese la opcion: ");
        opcion = scanner.nextInt();
        try {
            switch (opcion) {
                case 1 -> {
                    mostrarLibro(libro);
                }
                case 2 ->{
                    ingresarLibro(scanner,libro);
                }
                case 3 -> {
                    System.out.println("Saliendo....");
                }
                default -> {
                    System.out.println("Elije una opcion valida...");
                }
            }
        }catch (Exception e) {
            System.out.println("Error al ingresar el libro" + e.getMessage());
        }

        return opcion;
    }

    private static void ingresarLibro(Scanner scanner, Libro libro) {
        try {
            System.out.println("Ingresar Libro");
            scanner.nextLine();
            System.out.println("Ingrese el nombre: ");
            libro.setTitulo(scanner.nextLine());
            System.out.println("Ingrese el autor: ");
            libro.setAutor(scanner.nextLine());
            System.out.println("Ingrese el año de publicacion: [debe ser superior al año 1900]");
            libro.setAnioPublicacion(Integer.parseInt(scanner.nextLine()));
        }catch (Exception e) {
            System.out.println("Error al ingresar el libro" + e.getMessage());
        }
    }

    private static void mostrarLibro(Libro libro) {
        var nombre = libro.getTitulo();
        var autor = libro.getAutor();
        var anioPublicacion = libro.getAnioPublicacion();

        System.out.printf("""
                Libro:
                Titulo: %s
                Autor: %s
                Año Publicacion: %d""",nombre,autor,anioPublicacion);
    }

    private static void menu() {
        System.out.println("""
                \n
                \tMenu Libro
                1.Mostrar Libro
                2.Ingresar Libro
                3.Salir
                """);
    }
}

package TP_N2;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var nota = 0;
        var condicion = false;
        do {
            try {
                System.out.println("Ingrese una nota (0-10):");
                nota = Integer.parseInt(sc.nextLine());
                if(nota<0 || nota>10){
                    throw new IllegalArgumentException("Error: Nota inválida. Ingrese una nota entre 0 y 10.\n");
                }
                System.out.println("Nota guardada correctamente.\n");
                condicion = true;
            }catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
                sc.next();
            }
        }while (!condicion);


        sc.close();

    }
}

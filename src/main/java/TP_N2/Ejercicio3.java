package main.java.TP_N2;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        if (edad <= 12){
            System.out.println("Eres un niño");
        } else if (edad >= 12 && edad < 18) {
            System.out.println("Eres un adolecente");
        } else if (edad >= 18 && edad < 59) {
            System.out.println("Eres un adulto");
        }else if (edad >= 60){
            System.out.println("Eres un Adulto mayor");
        }
        sc.close();
    }
}

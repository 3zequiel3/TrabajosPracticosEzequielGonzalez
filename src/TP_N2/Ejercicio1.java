package TP_N2;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el año: ");
        var year = Integer.parseInt(scanner.nextLine());
        if (year>1000){
            if ((year % 4 == 0 && year % 100 != 0) ||year % 400 == 0){
                System.out.printf("El año %d es bisiesto",year);
            }
            else{
                System.out.printf("El año %d no es bisiesto", year);
            }
        }
        scanner.close();
    }
}

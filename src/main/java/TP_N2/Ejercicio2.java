package main.java.TP_N2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        var num1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el segundo numero: ");
        var num2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el tercer numero: ");
        var num3 = Integer.parseInt(scanner.nextLine());

        if(num1>num2 && num1>num3){
            System.out.printf("El numero %d es es el mayor",num1);
        }else if(num2>num1 && num2>num3){
            System.out.printf("El numero %d es es el mayor",num2);
        }else{
            System.out.printf("El numero %d es es el mayor",num3);
        }
        scanner.close();
    }
}

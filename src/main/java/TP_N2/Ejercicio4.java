package main.java.TP_N2;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el precio del producto: ");
        var precio = Double.parseDouble(sc.nextLine());
        System.out.println("Ingrese la categoria del producto (A,B,C): ");
        var categoria = String.valueOf(sc.nextLine());
        var desc = 0.0;
        double precioFinal = 0;
        switch (categoria) {
            case "A" ->{
                desc = 10;
                precioFinal = precio-(precio*desc);
                break;
            }
            case "B" ->{
                desc = 15;
                precioFinal = precio-(precio*desc);
                break;
            }
            case "C" ->{
                desc = 20;
                precioFinal = precio-(precio*desc);
                break;
            }
            default ->{
                System.out.println("Ingrese una categoria valida");
            }
        }
        System.out.printf("Precio Final: %.2f",precioFinal);
        sc.close();
    }
}

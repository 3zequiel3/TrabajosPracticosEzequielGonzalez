package TP_N2;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        var precioBase = 0.0;
        var impuesto = 0.0;
        var descuento = 0.0;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el precio base del producto: ");
            precioBase = Double.parseDouble(sc.nextLine());
            System.out.println("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
            impuesto = Double.parseDouble(sc.nextLine());
            System.out.println("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
            descuento = Double.parseDouble(sc.nextLine());

            var total = calcularFinal(precioBase, impuesto, descuento);
            System.out.println("El precio final del producto es: "+total);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
    private static double calcularFinal(double precioBase, double impuesto, double descuento){
        var total = 0.0;
        total = (precioBase+(precioBase*(impuesto/100)))-(precioBase*(descuento/100));
        return total;
    }
}

package TP_N2;

import java.util.Scanner;

public class Ejercicio11 {
    public static final double DESCUENTO_ESPECIAL = 0.10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el precio del producto: ");
            double precio = Double.parseDouble(sc.nextLine());
            var descEspecial = calcularDescuentoEspecial(precio);
            System.out.println("El descuento especial aplicado es de: " + descEspecial);
            var total = precio - descEspecial;
            System.out.println("El precio final con descuento es de: " + total);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        sc.close();
    }

    private static double calcularDescuentoEspecial(double precio) {
        double desc = 0.0;
        try {
            desc = precio * DESCUENTO_ESPECIAL;
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return desc;
    }
}

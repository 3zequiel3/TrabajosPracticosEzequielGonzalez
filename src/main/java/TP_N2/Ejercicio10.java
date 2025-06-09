package main.java.TP_N2;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el stock actual del producto: ");
            var stock = Integer.parseInt(sc.nextLine());
            System.out.println("Ingrese la cantidad vendida: ");
            var cantidadVendida = Integer.parseInt(sc.nextLine());
            System.out.println("Ingrese la cantidad recibida del producto: ");
            var cantidadRecibida = Integer.parseInt(sc.nextLine());

            var nuevoStock = actualizarStock(stock, cantidadVendida, cantidadRecibida);

            System.out.println("El nuevo stock es: " + nuevoStock);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
    private static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida){
        int nuevoStock = 0;
        try {
            nuevoStock = (stockActual - cantidadVendida) + cantidadRecibida;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return nuevoStock;
    }
}

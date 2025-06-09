package main.java.TP_N2;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        var peso = 0.0;
        String zonaDeEnvio;
        var precio = 0.0;
        double total;

        double costoEnvio;

        try{
            System.out.println("Ingrese el precio del producto: ");
            precio = Double.parseDouble(sc.nextLine());
            System.out.println("Ingrese el peso del producto en kg: ");
            peso = Double.parseDouble(sc.nextLine());
            System.out.println("Ingrese la zona de envío(Nacional/Internacional): ):");
            zonaDeEnvio = sc.nextLine();

            //Calcular envio

            costoEnvio = calcularCostoEnvio(peso, String.valueOf(zonaDeEnvio.charAt(0)).toUpperCase());
            System.out.println("El costo del envio es de: " + costoEnvio);


            //Calcular Total compra

            total = calcularTotalCompra(precio, costoEnvio);
            System.out.println("El total a pagar es: " + total);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        sc.close();
    }
    private static double calcularCostoEnvio(double peso, String zonaDeEnvio) {
        var costoEnvio = 0.0;
        switch (zonaDeEnvio) {
            case "I"->{
                costoEnvio = peso * 10;
            }
            case "N"->{
                costoEnvio = peso * 5;
            }
        }
        return costoEnvio;
    }
    private static double calcularTotalCompra(double precio, double costoEnvio) {
        return precio + costoEnvio;
    }
}

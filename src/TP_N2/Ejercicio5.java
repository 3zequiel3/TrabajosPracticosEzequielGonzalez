package TP_N2;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPar = 0;
        boolean condicion = false;
        int suma = 0;

        while(!condicion){
            System.out.println("Ingrese un numero par(0 para terminar): ");
            numPar = Integer.parseInt(sc.nextLine());
            if(numPar%2==0){
                suma += numPar;
            }else{
                System.out.println("Error NumImpar. Ingresa un numero par");
            }
            if(numPar== 0){
                condicion = true;
            }
        }
        System.out.println("La suma de numeros pares es: "+suma);
        sc.close();
    }
}

package TP_N2;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el numero " + (i+1) + " :");
            num = Integer.parseInt(sc.nextLine());
            if(num>0){
                positivos+=1;
            }else if(num<0){
                negativos+=1;
            }else {
                ceros+=1;
            }
        }
        System.out.printf("""
                Resultados:
                Positivos: %d
                Negativos: %d
                Ceros: %d%n""", positivos, negativos, ceros);

        sc.close();
    }
}

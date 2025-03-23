package TP_N2;

public class Ejercicio13 {
    public static void main(String[] args) {
        double[]precios= new double[5];
        precios[0]=199.99;
        precios[1]=299.5;
        precios[2]=149.75;
        precios[3]=399.0;
        precios[4]=89.99;

        try {
            System.out.println("Lista de precios Original: ");
            listaDePrecios(precios,0);
            precios[2]=129.99;
            System.out.println("Lista de precios Modificados: ");
            listaDePrecios(precios,0);
        } catch (Exception e) {
            System.out.println("Error en la lectura del programa. Error: " + e.getMessage());
        }
    }
    private static void listaDePrecios( double[]precios, int indice) {
        if (indice == precios.length) {
            return;
        }
        System.out.println("Precio: " +precios[indice]);
        listaDePrecios(precios, indice + 1);
    }
}

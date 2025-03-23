package TP_N3;

import java.util.Scanner;

class NaveEspacial{
    private String nombre;
    private int combustible;
    private final int COMBUSTIBLE_MAX = 100;
    private boolean enMovimiento;

    public NaveEspacial() {
    }
    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
        this.enMovimiento = false;
    }

    public void despegar(){
        if(combustible>=10){
            combustible-=10;
            System.out.printf("El %s ha arrancado. Combustible disponible: %d\n", nombre, combustible);
            enMovimiento = true;
        }else{
            System.out.println("No hay suficiente combustible para despegar\n");
        }
    }
    public void avanzar(int distancia){
       if (enMovimiento && (distancia<this.combustible)){
           System.out.printf("Avanzando %d km.....\n",distancia);
           this.combustible -= distancia;
       }
    }
    public void recargar(int cantidad){
        if(cantidad<=0){
            System.out.println("La cantidad a recargar debe ser mayor que 0");
        }
        int combustibleMax = COMBUSTIBLE_MAX-this.combustible;
        if(cantidad>combustibleMax){
            System.out.printf("No se puede recargar mas de %d de unidades de combustible.Recarga eso\n",combustibleMax);
        }else if(cantidad==combustibleMax){
            this.combustible += cantidad;
            System.out.printf("Se han cargado %d unidades de combustible\n",cantidad);
        }
    }
    public void mostrarEstado(){
        System.out.printf("""
                \tEstado de la nave:
                ------------------
                Nombre: %s
                Combustible: %d
                ------------------
                \n""",this.nombre,this.combustible);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }
    public int getCombustibleMax() {
        return COMBUSTIBLE_MAX;
    }
}
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean condicion = false;
        NaveEspacial nave = new NaveEspacial();
        try {
            while (!condicion) {
                menu(nave);
                var opcion = opciones(scanner,nave);
                if(opcion == 5){
                    condicion = true;
                }
            }
        }catch (Exception e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }

    private static int opciones(Scanner scanner, NaveEspacial nave) {
        System.out.println("Ingresa la opcion a realizar: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1->{
                System.out.println("""
                        Antes del despegue debes ingresar el nombre de la nave
                        y manualmente la cantidad de combustible que tiene:
                        """);
                scanner.nextLine();
                System.out.println("Ingresa el nombre de la nave: ");
                String nombre = scanner.nextLine();
                System.out.println(" ");
                System.out.println("Ingresa la cantidad de combustible");
                int cantidad = scanner.nextInt();
                if(cantidad>nave.getCombustibleMax()){
                    System.out.println("Intentalo nuevamente no puedes ingresar mas de 100 unidades de combustible");
                }else{
                    nave.setNombre(nombre);
                    nave.setCombustible(cantidad);
                    System.out.println("Excelente se ha registrado la nave:");
                    nave.mostrarEstado();
                    System.out.println("Iniciando despegue.....");
                    nave.despegar();
                }

            }
            case 2->{
                System.out.println("Ingresa cuanto quieres avanzar [km]: ");
                var km = scanner.nextInt();
                nave.avanzar(km);
            }
            case 3->{
                System.out.println("Ingresa la cantidad de combustible que recargaras:");
                var combustible = scanner.nextInt();
                nave.recargar(combustible);
            }
            case 4->{
                nave.mostrarEstado();
            }
            case 5->{
                System.out.println("Apagando nave.....");
            }

            default -> System.out.println("Opcion no valida");
        }
        return opcion;
    }

    private static void menu(NaveEspacial nave) {
        if(nave.isEnMovimiento()){
            System.out.println("""
                    1.Despegar
                    2.Avanzar
                    3.Recargar
                    4.Mostrar Estado
                    5.Apagar""");
        }else{
            System.out.println("""
                    \tSala de Control:
                    1.Despegar
                    2.--------
                    3.--------
                    4.--------
                    5.Apagar""");
        }
        
    }
}

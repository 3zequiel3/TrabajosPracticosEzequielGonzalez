package TP_N8_INTERFACES.PaymentMethods;

import TP_N8_INTERFACES.Interfaces.PagoConDescuento;

import java.util.Random;
import java.util.Set;

public class TarjetaDeCredito implements PagoConDescuento {
    private String nombreCliente;
    private String numero;
    private int cuotas;
    private static double saldo = 500000;
    private final static Set<Integer> cantidadCuotas = Set.of(3,6,9,12);

    public TarjetaDeCredito() {
    }

    public TarjetaDeCredito(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        TarjetaDeCredito.saldo = saldo;
    }

    private String getNumero() {
        return numero;
    }
    private void setNumero(String numero) {
        this.numero = numero;
    }
    public void setCuotas(int cuotas){
        this.cuotas = cuotas;
    }
    public Set<Integer> getCantidadCuotas() {
        return cantidadCuotas;
    }
    public void crearNumeroDeTarjeta(String entidad){
        String tipoDeTarjeta = entidad.toLowerCase();
        Random random = new Random();
        try{
            switch(tipoDeTarjeta){
                case "mastercard":
                    long numDeTargeta = random.nextLong(5100000000000000L,5599999999999999L);
                    setNumero(String.valueOf(numDeTargeta));
                    break;
                case "visa":
                    long numTarjetaVisa = random.nextLong(4000000000000000L,4599999999999999L);
                    setNumero(String.valueOf(numTarjetaVisa));
                default:
                    System.out.println("La entidad de tarjeta no es valida");
                    break;
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("La tarjeta de credito ha sido creada con exito");
        }
    }
    @Override
    public void Pagar(double monto, double porcentaje) {
        if(monto<= saldo){
            if(porcentaje>0){
                double descuento = monto * aplicarDescuento(porcentaje);
                procesarPago(monto-descuento);
            }else if(cantidadCuotas.contains(cuotas)){
                double montoCuota = monto/cuotas;
                double interes = 0.15;
                double montoFinal = montoCuota + montoCuota* interes;
                procesarPago(montoFinal);
            }else{
                saldo -= monto;
            }
        }
    }

    @Override
    public void procesarPago(double monto) {
        saldo -= monto;
        System.out.println("Pago realizado con tarjeta de credito");
        System.out.println("Saldo actualizado: "+saldo);
        System.out.println("Monto pagado: "+monto);
        System.out.println("---------------------------------------");
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        return porcentaje / 100;
    }

}

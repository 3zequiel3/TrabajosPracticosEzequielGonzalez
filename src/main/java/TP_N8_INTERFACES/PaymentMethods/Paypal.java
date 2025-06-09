package TP_N8_INTERFACES.PaymentMethods;

import TP_N8_INTERFACES.Interfaces.PagoConDescuento;

public class Paypal implements PagoConDescuento {

    private String email;

    private static double saldo = 500000;

    public Paypal() {
    }

    public Paypal(String email) {
        this.email = email;
    }

    public static double getSaldo() {
        return saldo;
    }
    public String getEmail() {
        return email;
    }
    public void añadirEmail(String email) {
        if(!esEmailValido(email)){
            this.email = email;
        }else{
            System.out.println("El email ingresado no es valido");
        }
    }
    public void setSaldo(double saldo) {
        Paypal.saldo = saldo;
    }
    public static boolean esEmailValido(String email) {
        return email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".");
    }
    @Override
    public void Pagar(double monto,double porcentaje){
        if(monto<= saldo){
            if(porcentaje>0){
                  double descuento = monto * aplicarDescuento(porcentaje);
                  procesarPago(monto-descuento);
             }else{
                 saldo -= monto;
             }
        }
    }

    @Override
    public void procesarPago(double monto) {
        saldo -= monto;
        System.out.println("Pago realizado con Paypal");
        System.out.println("Saldo actualizado: "+ saldo);
        System.out.println("Monto pagado: "+ monto);
        System.out.println("---------------------------------------");
    }
    @Override
    public double aplicarDescuento(double porcentaje) {
        return porcentaje /=100;
    }

}

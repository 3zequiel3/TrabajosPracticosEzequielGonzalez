package TP_N8_INTERFACES.Entities;

import TP_N8_INTERFACES.Enums.EstadoPedido;
import TP_N8_INTERFACES.Interfaces.Notificable;
import TP_N8_INTERFACES.PaymentMethods.TarjetaDeCredito;

public class Cliente implements Notificable {
    private String nombre;
    private String email;
    private MetodosDePago metodosDePago;
    private String notificacion;

    public Cliente() {
    }
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.metodosDePago = new MetodosDePago();
    }

    @Override
    public void notificar() {
        System.out.println(this.notificacion);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public MetodosDePago getMetodosDePago() {
        return this.metodosDePago;
    }
    public void agregarTarjeta(TarjetaDeCredito tarjeta){
        this.metodosDePago.agregarTarjeta(tarjeta);
    }
    public void agregarPaypal(TP_N8_INTERFACES.PaymentMethods.Paypal paypal){
        this.metodosDePago.agregarPaypal(paypal);
    }
}

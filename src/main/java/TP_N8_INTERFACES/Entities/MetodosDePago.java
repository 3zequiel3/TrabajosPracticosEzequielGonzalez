package TP_N8_INTERFACES.Entities;

import TP_N8_INTERFACES.PaymentMethods.Paypal;
import TP_N8_INTERFACES.PaymentMethods.TarjetaDeCredito;

import java.util.ArrayList;
import java.util.List;

public class MetodosDePago {
    private List<TarjetaDeCredito> tarjetas;
    private List<Paypal> paypals;

    public MetodosDePago(){
        this.paypals = new ArrayList<>();
        this.tarjetas = new ArrayList<>();
    }

    public void agregarTarjeta(TarjetaDeCredito tarjeta){
        this.tarjetas.add(tarjeta);
    }
    public void agregarPaypal(Paypal paypal){
        this.paypals.add(paypal);
    }
    public List<TarjetaDeCredito> getTarjetas() {
        return tarjetas;
    }
    public List<Paypal> getPaypals() {
        return paypals;
    }

}

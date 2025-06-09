package TP_N8_INTERFACES.Enums;

public enum EstadoPedido {
    EN_DESPACHO("El pedido ha sido despachado"),
    ENVIADO("Su pedido ha sido enviado"),
    RECIBIDO("Has recibido tu pedido");

    private final String mensaje;

    EstadoPedido(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}

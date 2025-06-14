package main.java.TP_N5_UMLBASICO;

public enum EstadoTicket {
    ABIERTO(1),
    EN_PROCESO(2),
    CERRADO(3);
    private int prioridad;
    EstadoTicket(int prioridad) {
        this.prioridad = prioridad;
    }
    public int getPrioridad() {
        return prioridad;
    }
}

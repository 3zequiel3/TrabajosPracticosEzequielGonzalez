package TP_N5;

import java.util.ArrayList;
import java.util.Comparator;

public class SistemaSoporte {
    private static int contadorTickets = 0;
    private ArrayList<TicketSoporte> tickets = new ArrayList<TicketSoporte>();
    TicketSoporte ticket;

    public void crearTicketSoporte(String descripcion, Usuario cliente) {
        this.contadorTickets++;
        this.ticket = new TicketSoporte(descripcion, cliente);
        tickets.add(ticket);
    }

    public void asignarTecnico(int IdTicket, Tecnico tecnico) {
        for (TicketSoporte ticket : tickets) {
            if(ticket.pasarId() == IdTicket){
                ticket.asignarTecnico(tecnico.pasarNombre());
                break;
            }
        }
    }
    public void cerrarTicketSoporte(int IdTicket) {
        for (TicketSoporte ticket : tickets) {
            if(ticket.pasarId() == IdTicket){
                ticket.cerrarTicket();
            }
        }
    }
    public void enprocesoTicketSoporte(int IdTicket) {
        for (TicketSoporte ticket : tickets) {
            if(ticket.pasarId() == IdTicket){
                ticket.enProceso();
            }
        }
    }

    public void mostrarTickets() {
        tickets.sort(Comparator.comparingInt(TicketSoporte::prioridadEstado));
        for (TicketSoporte ticket : tickets) {
            System.out.println(ticket);
        }
    };
    public static int cantidadTickets() {
        return contadorTickets;
    }
    @Override
    public String toString() {
        return tickets.toString();
    }
}

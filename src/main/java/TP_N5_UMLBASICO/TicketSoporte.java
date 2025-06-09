package main.java.TP_N5_UMLBASICO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TicketSoporte {
    private static int contador = 1;
    private int id;
    private String descripcion;
    private EstadoTicket estado;
    private LocalDate fecha;
    private Usuario usuario;
    private String tecnico;

    public TicketSoporte( String descripcion) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
        this.estado = EstadoTicket.ABIERTO;
        this.tecnico = "";
    }
    public TicketSoporte( String descripcion, Usuario usuario) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
        this.estado = EstadoTicket.ABIERTO;
        this.usuario = usuario;
        this.tecnico = "Sin asignar";
    }
    public void cerrarTicket(){
        this.estado = EstadoTicket.CERRADO;
    }
    public void enProceso(){
        this.estado = EstadoTicket.EN_PROCESO;
    }
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var fechaFormateada = this.fecha.format(formato);
        var detalles = """
                \tTicket:
                -Ticket ID: %s
                -Descripcion: %s
                -Estado: %s
                -Fecha: %s
                -Tecnico: %s\n""".formatted(this.id, this.descripcion, this.estado, fechaFormateada,this.tecnico);
        if (usuario != null){
            detalles += """
                    -Usuario: %s\n""".formatted(this.usuario.darNombreCompleto());
        }
        return detalles;
    }
    public void asignarTecnico(String tecnico){
        this.tecnico = tecnico;
    };
    public int pasarId(){
        return this.id;
    }
    public int prioridadEstado(){
        return estado.getPrioridad();
    }

}

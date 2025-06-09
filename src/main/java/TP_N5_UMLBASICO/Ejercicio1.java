package main.java.TP_N5_UMLBASICO;

public class Ejercicio1 {
    public static void main(String[] args) {
        SistemaSoporte s = new SistemaSoporte();
        Usuario cliente1 = new Usuario("Ezequiel Gonzalez", "fakemail@gmail.com");
        Usuario cliente2= new Usuario("Jessica Moretti","fakemail@gmail.com");

        Tecnico celulares = new Tecnico("Celulares","Electronico");
        Tecnico computadoras = new Tecnico("Computadoras","Computadoras");
        Tecnico elecDomesticos = new Tecnico("Electrodomesticos","Electromecanico");
        Tecnico mecanico = new Tecnico("Mecanico","Mecanico");

        s.crearTicketSoporte("Se rompio mi pc",cliente1);
        s.asignarTecnico(1,computadoras);
        s.crearTicketSoporte("Se rompio mi auto",cliente2);
        s.asignarTecnico(2,mecanico);
        s.crearTicketSoporte("Se rompio mi lavadora",cliente1);
        s.asignarTecnico(3,elecDomesticos);
        s.mostrarTickets();
        s.enprocesoTicketSoporte(3);
        s.cerrarTicketSoporte(2);
        s.mostrarTickets();

    }
}

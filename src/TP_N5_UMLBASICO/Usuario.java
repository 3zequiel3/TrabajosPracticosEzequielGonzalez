package TP_N5_UMLBASICO;

public class Usuario {
    private static int contador = 0;
    private int id;
    private String nombreCompleto;
    private String email;

    public Usuario(String nombreCompleto, String email) {
        this.id = contador++;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }
    public String darNombreCompleto() {
        return this.nombreCompleto;
    }

    @Override
    public String toString() {
        return "Usuario: " + this.id + " | Nombre: " + this.nombreCompleto + " | Email: " + this.email;
    }
}

package TP_N8_INTERFACES;

import TP_N8_INTERFACES.Entities.*;
import TP_N8_INTERFACES.Enums.EstadoPedido;
import TP_N8_INTERFACES.PaymentMethods.Paypal;
import TP_N8_INTERFACES.PaymentMethods.TarjetaDeCredito;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ecommerce e = null;
        Pedido p = null;
        Producto producto = null;
        TarjetaDeCredito t = null;
        Paypal paypal = null;
        Cliente cliente = null;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("");
            int opcion = 0;
            do {
                var menu = menu(e, p, producto);
                System.out.println(menu);
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1 -> {
                        if (e == null) {
                            e = iniciarEcommerce();
                            System.out.println("E-commerce creado correctamente");
                            System.out.println("Deseas agregar cupones? (Si/No): ");
                            String entrada = sc.nextLine();
                            char opcionCu = entrada.toLowerCase().charAt(0);
                            boolean cent = false;
                            if (opcionCu == 's') {
                                while (!cent) {
                                    agregarCupon(e, sc);
                                    System.out.println("Deseas agregar otro? (Si/No): ");
                                    char opcionCuS = sc.nextLine().toLowerCase().charAt(0);
                                    if (opcionCuS == 'n') {
                                        cent = true;
                                    }
                                }
                            } else {
                                System.out.println("Sin Cupones");
                            }
                        } else {
                            if (cliente == null) {
                                System.out.println("Primero debe crear un cliente.");
                                break;
                            }

                            p = iniciarPedido(cliente);

                            if (e.getProductos().isEmpty()) {
                                System.out.println("No hay productos en el e-commerce. Cree productos primero.");
                                break;
                            }

                            boolean seguirAgregando = true;

                            while (seguirAgregando) {
                                System.out.println("Ingrese el nombre del producto a agregar:");
                                String nombre = sc.nextLine();
                                boolean encontrado = false;

                                for (Producto pro : e.getProductos()) {
                                    if (pro.getNombre().equalsIgnoreCase(nombre)) {
                                        System.out.println("Producto encontrado");
                                        System.out.println("Ingrese la cantidad: ");
                                        int cantidad = sc.nextInt();
                                        sc.nextLine(); // limpiar buffer
                                        Producto productoPedido = new Producto(pro.getNombre(), pro.getPrecio());
                                        productoPedido.setCantidad(cantidad);
                                        p.añadirProductos(productoPedido);
                                        encontrado = true;
                                        break;
                                    }
                                }

                                if (!encontrado) {
                                    System.out.println("Producto no encontrado.");
                                }

                                System.out.println("Desea agregar otro producto? (Si/No): ");
                                String respuesta = sc.nextLine().toLowerCase();
                                seguirAgregando = respuesta.startsWith("s");
                            }

                            if (p.getProductos().isEmpty()) {
                                throw new RuntimeException("Error: No hay productos en el pedido. Ingrese un producto antes de continuar.");
                            } else {
                                System.out.println("Pedido armado correctamente.");
                            }
                        }
                    }
                    case 2 -> cliente = crearCliente(sc);
                    case 3 -> {
                        if (cliente != null && p != null) {
                            MetodosDePago metodoDePago = cliente.getMetodosDePago();
                            System.out.println(metodoDePago());
                            int opcionPago = sc.nextInt();
                            sc.nextLine();
                            switch (opcionPago) {
                                case 1 -> {
                                    if (metodoDePago.getTarjetas().isEmpty()) {
                                        t = crearTarjeta(sc);
                                        System.out.println("Tarjeta creada correctamente");
                                        metodoDePago.agregarTarjeta(t);
                                    }
                                    if (!metodoDePago.getTarjetas().isEmpty()) {
                                        System.out.println("Tienes un cupon de Descuento?: (Si/No):)");
                                        char opcionCupon = sc.nextLine().toLowerCase().charAt(0);
                                        if (opcionCupon == 's') {
                                            String codigoDeDescuento = sc.nextLine();
                                            if (e == null) throw new IllegalStateException("Ecommerce no creado");
                                            if (e.getCupones().containsKey(codigoDeDescuento)) {
                                                System.out.println("Cupon aplicado");
                                                var porcentaje = e.getCupones().getOrDefault(codigoDeDescuento, 0);
                                                pagar(p.calcularTotal(), porcentaje, t, sc);
                                            }
                                        } else {
                                            pagar(p.calcularTotal(), 0, t, sc);
                                        }
                                        p.cambiarEstado(EstadoPedido.EN_DESPACHO);
                                        cliente.notificar();
                                        p.cambiarEstado(EstadoPedido.ENVIADO);
                                        cliente.notificar();
                                    }
                                }
                                case 2 -> {
                                    if (metodoDePago.getPaypals().isEmpty()) {
                                        paypal = crearPaypal(sc);
                                        cliente.agregarPaypal(paypal);
                                        System.out.println("Cuenta PayPal agregada correctamente");
                                    }
                                    if (!metodoDePago.getPaypals().isEmpty()) {
                                        System.out.println("Tienes un cupon de Descuento?:");
                                        String codigoDeDescuento = sc.nextLine();
                                        if (e.getCupones().containsKey(codigoDeDescuento)) {
                                            System.out.println("Cupon aplicado");
                                            var porcentaje = e.getCupones().getOrDefault(codigoDeDescuento, 0);
                                            pagar(p.calcularTotal(), porcentaje, paypal);
                                        } else {
                                            pagar(p.calcularTotal(), 0, paypal);
                                        }
                                        p.cambiarEstado(EstadoPedido.EN_DESPACHO);
                                        cliente.notificar();
                                        p.cambiarEstado(EstadoPedido.ENVIADO);
                                        cliente.notificar();
                                    }
                                }
                                default -> throw new RuntimeException("Selecciona un metodo de pago valido: 1.Tarjeta 2.Paypal");
                            }
                        }
                    }
                    case 4 -> {
                        producto = crearProducto(sc);
                        if (producto != null && e != null) {
                            e.añadirProducto(producto);
                            System.out.println("Producto agregado al e-commerce.");
                        } else if (e == null) {
                            System.out.println("Primero debes crear el e-commerce.");
                        }                    }
                    default -> throw new IllegalStateException("Unexpected value: " + opcion);
                }
            } while (opcion != 5);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void pagar(double monto, double porcentaje, TarjetaDeCredito tarjetaDeCredito, Scanner sc) {
        System.out.println("Se hara en cuotas? (Si/No): ");
        char opcion = sc.nextLine().toLowerCase().charAt(0);
        if (opcion == 'n') {
            tarjetaDeCredito.Pagar(monto, porcentaje);
        } else {
            System.out.println("""
                    Elije la cantidad:
                    \t-3
                    \t-6
                    \t-9
                    \t-12""");
            int cuotas = sc.nextInt();
            sc.nextLine();
            if (tarjetaDeCredito.getCantidadCuotas().contains(cuotas)) {
                tarjetaDeCredito.setCuotas(cuotas);
                tarjetaDeCredito.Pagar(monto, porcentaje);
            }
        }
    }

    private static void pagar(double monto, double porcentaje, Paypal paypal) {
        paypal.Pagar(monto, porcentaje);
    }

    public static String menu(Ecommerce e, Pedido p, Producto producto) {
        if (e == null) {
            return """
                1. Crear E-commerce
                5. Salir""";
        } else {
            return """
                1. Iniciar Pedido
                2. Crear Cliente;
                3. Pagar pedido
                4. Crear Producto
                5. Salir""";
        }
    }

    public static String metodoDePago() {
        return """
                Selecciona el metodo de Pago:
                1.Tarjeta
                2.Paypal""";
    }

    public static MetodosDePago iniciarMetodoDePago() {
        return new MetodosDePago();
    }

    public static TarjetaDeCredito crearTarjeta(Scanner sc) {
        System.out.println("Ingrese su Nombre Completo");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el tipo de tarjeta a ingresar");
        System.out.println("""
                Visa
                Mastercard""");
        String tipoTarjeta = sc.nextLine();
        if (tipoTarjeta.equalsIgnoreCase("Visa") || tipoTarjeta.equalsIgnoreCase("Mastercard")) {
            TarjetaDeCredito t = new TarjetaDeCredito(nombre);
            t.crearNumeroDeTarjeta(tipoTarjeta);
            return t;
        } else {
            System.out.println("Ingresa un tipo de tarjeta valido");
            return null;
        }
    }

    public static Paypal crearPaypal(Scanner sc) {
        Paypal paypal = new Paypal();
        System.out.println("Ingresa tu email:");
        String email = sc.nextLine();
        paypal.añadirEmail(email);
        return paypal;
    }

    public static Ecommerce iniciarEcommerce() {
        return new Ecommerce();
    }

    public static Cliente crearCliente(Scanner sc) {
        System.out.println("Ingresa tu nombre completo:");
        String nombre = sc.nextLine();
        System.out.println("Ingresa tu email: ");
        String email = sc.nextLine();
        Cliente c = new Cliente(nombre, email);
        System.out.println("Cliente creado correctamente");
        System.out.println("Nombre del cliente: " + c.getNombre());
        System.out.println("Email del cliente: " + c.getEmail());
        return c;
    }

    public static Pedido iniciarPedido(Cliente cliente) {
        return new Pedido(cliente);
    }

    public static Producto crearProducto(Scanner sc) {
        try {
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el precio del producto: ");
            double precio = Double.parseDouble(sc.nextLine());
            Producto p = new Producto(nombre, precio);
            System.out.println("Producto creado correctamente");
            System.out.println("Nombre del producto: " + p.getNombre());
            return p;
        } catch (NumberFormatException nfe) {
            System.out.println("Error: El precio debe ser un numero");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void agregarCupon(Ecommerce e, Scanner sc) {
        System.out.println("Ingrese el codigo del cupon: ");
        String codigo = sc.nextLine();
        System.out.println("Ingrese el porcentaje del cupon: ");
        int porcentaje = sc.nextInt();
        sc.nextLine();
        e.añadirCupon(codigo, porcentaje);
        System.out.println("Cupon agregado correctamente");
    }
}

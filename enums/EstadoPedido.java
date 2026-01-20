package Proyectos_finales.TiendaOnlineDeConsola.enums;

public enum EstadoPedido {

    // Valores de la enum
    PENDIENTE("El pedido ha sido creado y está esperando pago"),
    PAGADO("El pago ha sido confirmado correctamente"),
    ENVIADO("El pedido a sido enviado al transportista"),
    ENTREGADO("El pedido ha sido entregado al cliente");

    // Variables de instancia -> enum
    private final String mensaje;

    // Constructor private
    EstadoPedido(String mensaje) {
        this.mensaje = mensaje;
    }

    // Getter
    public String getMensaje() {
        return mensaje;
    }
}

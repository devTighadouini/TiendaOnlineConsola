package Proyectos_finales.TiendaOnlineDeConsola.enums;

public enum TipoProducto {

    // Valores de posibles de la enum
    ELECTRONICA(0.21, "ELEC"),
    ROPA(0.21, "TEXT"),
    ALIMENTACION(0.21, "ALIM"),
    HOGAR(0.21, "HOG");

    // Variables de instancia -> enum
    private final String mensaje;
    private final double ivaProducto;

    // Constructor private
    TipoProducto(double ivaProducto, String mensaje) {
        this.ivaProducto = ivaProducto;
        this.mensaje = mensaje;
    }

    // Getter's
    public String getMensaje() {
        return mensaje;
    }

    public double getIvaProducto() {
        return ivaProducto;
    }
}

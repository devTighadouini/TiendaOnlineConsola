package Proyectos_finales.TiendaOnlineDeConsola.Exceptions;

public class ProductoInvalidoException extends RuntimeException {

    // Constructor - Exception
    // Uncheked personalizada
    public ProductoInvalidoException(String message) {
        super(message);
    }

    public ProductoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

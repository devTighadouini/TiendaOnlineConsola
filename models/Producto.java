package Proyectos_finales.TiendaOnlineDeConsola.models;
import Proyectos_finales.TiendaOnlineDeConsola.enums.TipoProducto;

public abstract class Producto {

    // Atributos
    private String codigo, nombre;
    private double precioBase;
    private TipoProducto tipoProducto;

    // Constructor
    public Producto(String codigo, String nombre, double precioBase, TipoProducto tipoProducto) {
        setCodigo(codigo);
        setNombre(nombre);
        setPrecioBase(precioBase);
        setTipoProducto(tipoProducto);
    }

    // Getter's y Setter's
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo.isBlank()) throw new IllegalArgumentException("Atributo código en blanco no válido.");

        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isBlank()) throw new IllegalArgumentException("Atributo nombre en blanco no válido.");
        if (nombre.length() < 3) throw new IllegalArgumentException("Nombre con cantidad de caracteres menor de 3, no válido.");
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0 ) throw new IllegalArgumentException("Precio base no válido.");
        this.precioBase = precioBase;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        if (tipoProducto == null ) throw new IllegalArgumentException("Tipo de producto no puede ser nulo, no válido.");
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "Código: " + getCodigo() + "; \n" +
                "Nombre-Producto: " + getNombre() + "; \n" +
                "Precio-Base: " + getPrecioBase() + "; \n" +
                "Tipo: " + getTipoProducto() + "; \n";
    }

    public boolean esValido() {
        return getNombre() != null && !getNombre().isBlank() && getPrecioBase() > 0;
    }

    // Mtd Abstractos
    public abstract double calcularPrecioFinal();
    public abstract void mostrarInfo();
}

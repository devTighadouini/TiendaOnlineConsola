package Proyectos_finales.TiendaOnlineDeConsola.models;

import Proyectos_finales.TiendaOnlineDeConsola.enums.TipoProducto;
import Proyectos_finales.TiendaOnlineDeConsola.interfaces.Vendible;

public class Jersey extends Producto implements Vendible {

    // Atributos
    private String color, marca;

    // Constructor
    public Jersey(String color, String marca, String codigo, String nombre, double precioBase, TipoProducto tipoProducto) {
        super(codigo, nombre, precioBase, tipoProducto);
        setColor(color);
        setMarca(marca);
    }

    // Getter's y Setter's
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.isBlank()) throw new IllegalArgumentException("Color no puede estar vacío, no válido.");
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (color.isBlank()) throw new IllegalArgumentException("Marca no puede estar vacío, no válido.");
        this.marca = marca;
    }

    @Override
    public double calcularPrecioFinal() {
        // Precio base + IVA tipo de producto
        return (getPrecioBase() * this.getTipoProducto().getIvaProducto()) + getPrecioBase();
    }

    @Override
    public void mostrarInfo() {
        System.out.println(this.toString());
    }

    @Override
    public boolean estaDisponible() {
        return true;
    }
}

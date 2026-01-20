package Proyectos_finales.TiendaOnlineDeConsola.models;

import Proyectos_finales.TiendaOnlineDeConsola.enums.TipoProducto;
import Proyectos_finales.TiendaOnlineDeConsola.interfaces.Vendible;

public class Television extends Producto implements Vendible {

    // Atributos
    private int pulgadas;

    // Constructor
    public Television(int pulgadas, String codigo, String nombre, double precioBase, TipoProducto tipoProducto) {
        super(codigo, nombre, precioBase, tipoProducto);
        setPulgadas(pulgadas);

    }

    // Getter y Setter
    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        if (pulgadas <= 24) throw new IllegalArgumentException("Televisión con pulgadas no comerciable, no válido.");
        this.pulgadas = pulgadas;
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

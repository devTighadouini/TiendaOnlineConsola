package Proyectos_finales.TiendaOnlineDeConsola.models;

import Proyectos_finales.TiendaOnlineDeConsola.enums.TipoProducto;
import Proyectos_finales.TiendaOnlineDeConsola.interfaces.Vendible;

public class Sillon extends Producto implements Vendible {

    // Atributos
    private int cantPatas;

    // Constructor
    public Sillon(int cantPatas, String codigo, String nombre, double precioBase, TipoProducto tipoProducto) {
        super(codigo, nombre, precioBase, tipoProducto);
        setCantPatas(cantPatas);
    }

    // Getter y Setter
    public int getCantPatas(){
        return cantPatas;
    }

    public void setCantPatas(int cantPatas){
        if (cantPatas <= 0 ) throw new IllegalArgumentException("Cantidad de patas del sillon, no válido.");
        this.cantPatas = cantPatas;
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

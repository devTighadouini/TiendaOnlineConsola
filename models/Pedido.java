package Proyectos_finales.TiendaOnlineDeConsola.models;

import Proyectos_finales.TiendaOnlineDeConsola.enums.EstadoPedido;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    // Atributos
    private String id, cliente;
    private EstadoPedido estado;
    private List<Producto> productoList;

    // Constructor
    public Pedido(String id, String cliente) {
        setId(id);
        setCliente(cliente);
        this.estado = EstadoPedido.PENDIENTE;
        this.productoList = new ArrayList<>(); // Inicializamos la lista vacía
    }

    // Getter's y Setter's
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.isBlank()) throw new IllegalArgumentException("ID cliente no válido");
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if (cliente.isBlank()) throw new IllegalArgumentException("Nombre cliente no válido");
        this.cliente = cliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    // Métodos propios
    public void agragarProduto(Producto p) {

        /*
            Comprobamos de que el tipo de producto no sea null y con
            nuestra función añadida a PRODUCTO, comprobamos también que nos devuelva un "true"
        */
        // Si no es un producto vacío, se añadira a nuestra lista de productos correctamente
        if (p != null && p.esValido()) this.productoList.add(p);

        // Caso contrario y que llegue a cumplir alguna condición no válida lanzaremos nuestra Excepción de advertencía
        // para que no se rompa nuestro programa.
        else throw new IllegalArgumentException("Producto no válido o vacío.");
    }

    public double calcularTotal() {
        // VAR para realizar el cálculo de la suma de la compra
        double precioPedido = 0;

        // ForEach para acceder al precio total de cada producto que se encuentre en el pedido
        for (Producto producto : this.productoList) {

            // Sumamos precio total, cada producto
            precioPedido += producto.calcularPrecioFinal();
        }

        // Devolvemos la suma total del pedido
        return precioPedido ;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        // No hace falta realizar la comprobación dentro de este mtd debido a que se tiene como parámetro del tipo de ENUM
        this.estado = nuevoEstado;
    }

    public void resumen() {
        double subtotal = 0;

        // Cabecera
        System.out.println("FACTURA nº: " + getId());
        System.out.println("Cliente: " + getCliente());
        System.out.println("Estado Pedido: " + getEstado());
        System.out.println("Productos " + "-".repeat(20));

        // Listado de productos
        for (Producto aux : getProductoList()) {
            System.out.println(aux.toString());
            subtotal += aux.getPrecioBase(); // Acumulamos el subtotal aquí mismo
        }

        // Cálculos
        double iva = subtotal * 0.21;
        double total = subtotal + iva;

        // Pie de factura con formato de 2 decimales (%.2f)
        System.out.println("-".repeat(30));
        System.out.printf("SUBTOTAL: %.2f€%n", subtotal);
        System.out.printf("IVA (21%%): %.2f€%n", iva);
        System.out.println("-".repeat(30));
        System.out.printf("TOTAL:    %.2f€%n", total);
        System.out.println("-".repeat(30));
    }



}

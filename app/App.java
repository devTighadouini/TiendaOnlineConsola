package Proyectos_finales.TiendaOnlineDeConsola.app;

import Proyectos_finales.TiendaOnlineDeConsola.enums.EstadoPedido;
import Proyectos_finales.TiendaOnlineDeConsola.enums.TipoProducto;
import Proyectos_finales.TiendaOnlineDeConsola.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    /*
    *   Catálogo: 6 productos diferentes tipos
    *   Pedidos: 2 mínimo
    *   Añadir varios productos a cada pedido
    *   Cambiar al menos el estado de uno de los pedidos
    *   Mostrar ->
    *       - Catálogo (mostrarInfo())
    *       - Resumen de cada pedido
    *   Mostrar todos los valores posibles del enum con su IVA
    *
    *
    *
    */
    // Main - App
    public static void main(String [] args) {
        // Catálogo
        List<Producto> catalogo = new ArrayList<>(Arrays.asList(
                new Sillon(4,"S1", "Sillon Comodo", 63.5, TipoProducto.HOGAR),
                new Television(58, "T1", "Samsung", 337.5, TipoProducto.ELECTRONICA),
                new Jersey("Rojo", "Stone-Island", "J1", "Stone-Island", 56, TipoProducto.ROPA),
                new Sillon(5,"S3", "Sillon Escritorio", 107, TipoProducto.HOGAR),
                new Television(120, "T11", "LG-Tecnologi", 579.8, TipoProducto.ELECTRONICA),
                new Jersey("Verde", "Nike x Nocta", "J1", "Nike x Nocta", 195, TipoProducto.ROPA)
        ));

        // Pedidos - 2
        Pedido pedido_1 = new Pedido("ID_1", "Ilias");
        Pedido pedido_2 = new Pedido("ID_2", "Lucas");

        // Añadimos los productos de nuestro catálogo
        pedido_1.agragarProduto(catalogo.get(4));
        pedido_1.agragarProduto(catalogo.get(1));
        pedido_1.agragarProduto(catalogo.get(5));
        pedido_1.cambiarEstado(EstadoPedido.PAGADO);

        for (int i = 0; i < 3; i++) {
            pedido_2.agragarProduto(catalogo.get(i));
        }

        // Mostrar
        System.out.println(catalogo.toString());
        pedido_1.resumen();







    }
}

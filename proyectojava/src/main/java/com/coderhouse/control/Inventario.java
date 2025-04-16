package com.coderhouse.control;

import com.coderhouse.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
        // Productos iniciales en la dietética
        productos.add(new Producto(1, "Proteína en polvo", 5000, 10));
        productos.add(new Producto(2, "Semillas de chía", 1000, 20));
        productos.add(new Producto(3, "Avena integral", 3000, 50));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }
}
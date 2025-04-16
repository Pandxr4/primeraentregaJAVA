package com.coderhouse.control;

import com.coderhouse.modelo.Producto;

public class GestorVentas {

    public double registrarVenta(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            producto.setStock(producto.getStock() - cantidad);
            return producto.getPrecio() * cantidad;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock para la venta.");
        }
    }
}
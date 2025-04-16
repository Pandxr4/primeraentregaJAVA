package com.coderhouse;

import com.coderhouse.control.Inventario;
import com.coderhouse.control.GestorVentas;
import com.coderhouse.modelo.Producto;

import java.util.List;
import java.util.Scanner;

public class PrimeraPreentregaSahid {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        GestorVentas gestorVentas = new GestorVentas();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }
            switch (opcion) {
                case 1:
                    listarProductos(inventario);
                    break;
                case 2:
                    registrarVenta(scanner, inventario, gestorVentas);
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== Menú principal Pandxr4 Co. =====");
        System.out.println("1. Lista de productos");
        System.out.println("2. Realizar venta");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void listarProductos(Inventario inventario) {
        System.out.println("\n--- Inventario de productos ---");
        List<Producto> productos = inventario.getProductos();
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    private static void registrarVenta(Scanner scanner, Inventario inventario, GestorVentas gestorVentas) {
        System.out.println("\n--- Registrar nueva venta ---");
        System.out.print("Ingrese el ID del producto: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        Producto producto = inventario.buscarProducto(id);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad;
        try {
            cantidad = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Cantidad inválida.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a cero.");
            return;
        }

        if (producto.getStock() < cantidad) {
            System.out.println("No hay suficiente stock para esta venta.");
            return;
        }

        double totalVenta = gestorVentas.registrarVenta(producto, cantidad);
        System.out.println("Venta realizada exitosamente. Total: $" + totalVenta);
    }
}
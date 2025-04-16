package com.coderhouse.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String producto;        
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal totalLinea;   
    
  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura;
    
    
    public DetalleFactura() {
    }
    
    // Constructor con parámetros
    public DetalleFactura(String producto, int cantidad, BigDecimal precioUnitario,
                          BigDecimal totalLinea, Factura factura) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalLinea = totalLinea;
        this.factura = factura;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public String getProducto() {
        return producto;
    }
    
    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public BigDecimal getTotalLinea() {
        return totalLinea;
    }
    
    public void setTotalLinea(BigDecimal totalLinea) {
        this.totalLinea = totalLinea;
    }
    
    public Factura getFactura() {
        return factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    @Override
    public String toString() {
        return "DetalleFactura{" +
                "id=" + id +
                ", producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", totalLinea=" + totalLinea +
                '}';
    }
}
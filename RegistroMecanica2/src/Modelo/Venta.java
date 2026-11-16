
package Modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venta {
    
    private int codigo;
    private LocalDateTime fecha;
    private String nombreCliente;
    private BigDecimal montoTotal;
    
    
    public Venta() {
    }
    
    // Constructor con parámetros
    public Venta(int codigo, LocalDateTime fecha,
                 String nombreCliente, BigDecimal montoTotal) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.montoTotal = montoTotal;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }
}

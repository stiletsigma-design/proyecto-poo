package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servicio {

    private int codigo;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String telefono;
    private double pago;
    private String descripcion;
    private LocalDateTime fecha;

    public Servicio() {
    }

    // Para GUARDAR: el código y la fecha los genera MySQL
    public Servicio(String nombre, String apPaterno, String apMaterno,
                    String telefono, double pago, String descripcion) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono = telefono;
        this.pago = pago;
        this.descripcion = descripcion;
    }

    // Para LEER de la base de datos (trae todo)
    public Servicio(int codigo, String nombre, String apPaterno, String apMaterno,
                    String telefono, double pago, String descripcion, LocalDateTime fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono = telefono;
        this.pago = pago;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    // Fecha y hora lista para mostrar en la tabla: 05/10/2026 09:15:00
    public String getFechaFormateada() {
        if (fecha == null) {
            return "";
        }
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}

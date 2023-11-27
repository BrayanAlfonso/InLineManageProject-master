package model;

import java.sql.Date;

public class ReporteVentaVo {
    private int idDetalleVenta;
    private int idProducto;
    private int idVenta;
    private Float precioProducto;
    private int cantidad;
    private Date fechaVenta;
    private int idUsuario;

    
    public ReporteVentaVo() {
    }


    public ReporteVentaVo(int idDetalleVenta, int idProducto, int idVenta, Float precioProducto, int cantidad,
            Date fechaVenta, int idUsuario) {
        this.idDetalleVenta = idDetalleVenta;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.idUsuario = idUsuario;
    }


    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }


    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }


    public int getIdProducto() {
        return idProducto;
    }


    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


    public int getIdVenta() {
        return idVenta;
    }


    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }


    public Float getPrecioProducto() {
        return precioProducto;
    }


    public void setPrecioProducto(Float precioProducto) {
        this.precioProducto = precioProducto;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public Date getFechaVenta() {
        return fechaVenta;
    }


    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public int getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    
}

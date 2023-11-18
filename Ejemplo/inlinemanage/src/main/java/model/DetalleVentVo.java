package model;

public class DetalleVentVo {
    private int idDetalleVenta;
    private int idProducto;
    private int idVenta;
    private int idUsuario;
    private Float precioProducto;
    private int cantidad;

    public DetalleVentVo() {
    }

    public DetalleVentVo(int idDetalleVenta, int idProducto, int idVenta, int idUsuario, Float precioProducto,
            int cantidad) {
        this.idDetalleVenta = idDetalleVenta;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.idUsuario = idUsuario;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    

}

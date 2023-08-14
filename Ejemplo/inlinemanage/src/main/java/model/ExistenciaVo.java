package model;


public class ExistenciaVo {
    
    private int idExistencia;
    private int cantidadUnidad;
    private Float precioEntrada;
    private int idProducto;
    private int idEntradaProd;
    

    public ExistenciaVo(){

    }


    public ExistenciaVo(int idExistencia, int cantidadUnidad, Float precioEntrada, int idProducto, int idEntradaProd) {
        this.idExistencia = idExistencia;
        this.cantidadUnidad = cantidadUnidad;
        this.precioEntrada = precioEntrada;
        this.idProducto = idProducto;
        this.idEntradaProd = idEntradaProd;
    }


    public int getIdExistencia() {
        return idExistencia;
    }


    public void setIdExistencia(int idExistencia) {
        this.idExistencia = idExistencia;
    }


    public int getCantidadUnidad() {
        return cantidadUnidad;
    }


    public void setCantidadUnidad(int cantidadUnidad) {
        this.cantidadUnidad = cantidadUnidad;
    }


    public Float getPrecioEntrada() {
        return precioEntrada;
    }


    public void setPrecioEntrada(Float precioEntrada) {
        this.precioEntrada = precioEntrada;
    }


    public int getIdProducto() {
        return idProducto;
    }


    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


    public int getIdEntradaProd() {
        return idEntradaProd;
    }


    public void setIdEntradaProd(int idEntradaProd) {
        this.idEntradaProd = idEntradaProd;
    }


}

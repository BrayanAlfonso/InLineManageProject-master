
package model;

public class ProductoVo {

    private int idProducto;
    private int numSerial;
    private String nombreProducto;
    private int precioProducto;
    private String descripcion; 
    private int idCategoria;
    private int idExistencia;

    
    public ProductoVo() {
    }


    public ProductoVo(int idProducto, int numSerial, String nombreProducto, int precioProducto, String descripcion,
            int idCategoria, int idExistencia) {
        this.idProducto = idProducto;
        this.numSerial = numSerial;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.idExistencia = idExistencia;
    }


    public int getIdProducto() {
        return idProducto;
    }


    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


    public int getNumSerial() {
        return numSerial;
    }


    public void setNumSerial(int numSerial) {
        this.numSerial = numSerial;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }


    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }


    public int getPrecioProducto() {
        return precioProducto;
    }


    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getIdCategoria() {
        return idCategoria;
    }


    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }


    public int getIdExistencia() {
        return idExistencia;
    }


    public void setIdExistencia(int idExistencia) {
        this.idExistencia = idExistencia;
    }


    
}
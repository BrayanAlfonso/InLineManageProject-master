
package model;

public class ProductoVo {

    private int idProducto;
    private int unidadesDisponibles;
    private String nombreProducto; 
    private float precioVenta; 
    private String descripcion;
    private String serial;
    private int garantiaEntradaMeses;
    private int garantiaVentaMeses;
    private int idCategoria;
    
    public ProductoVo() {
    }

    public ProductoVo(int idProducto, int unidadesDisponibles, String nombreProducto, float precioVenta,
            String descripcion, String serial, int garantiaEntradaMeses, int garantiaVentaMeses, int idCategoria) {
        this.idProducto = idProducto;
        this.unidadesDisponibles = unidadesDisponibles;
        this.nombreProducto = nombreProducto;
        this.precioVenta = precioVenta;
        this.descripcion = descripcion;
        this.serial = serial;
        this.garantiaEntradaMeses = garantiaEntradaMeses;
        this.garantiaVentaMeses = garantiaVentaMeses;
        this.idCategoria = idCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getGarantiaEntradaMeses() {
        return garantiaEntradaMeses;
    }

    public void setGarantiaEntradaMeses(int garantiaEntradaMeses) {
        this.garantiaEntradaMeses = garantiaEntradaMeses;
    }

    public int getGarantiaVentaMeses() {
        return garantiaVentaMeses;
    }

    public void setGarantiaVentaMeses(int garantiaVentaMeses) {
        this.garantiaVentaMeses = garantiaVentaMeses;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    
    
    
    

    

}
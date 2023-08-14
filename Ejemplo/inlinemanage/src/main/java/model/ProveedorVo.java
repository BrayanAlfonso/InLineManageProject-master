package model;

public class ProveedorVo {
    
    private int idProveedor;
    private String nombreProveedor;
    private String direccionProveedor;

    public ProveedorVo(){
    }

    public ProveedorVo(int idProveedor, String nombreProveedor, String direccionProveedor){
        this.idProveedor=idProveedor;
        this.nombreProveedor=nombreProveedor;
        this.direccionProveedor=direccionProveedor;
    }

    public int getIdProveedor(){
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor(){
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccionProveedor(){
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    @Override
    public String toString() {
        return "ProveedorVo [idProveedor=" + idProveedor + 
        ", nombreProveedor=" + nombreProveedor + 
        ", direccionProveedor=" + direccionProveedor + "]";
    }
    
}

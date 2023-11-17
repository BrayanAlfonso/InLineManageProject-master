package model;
import java.sql.Date;

public class EntradaVo {
    private int idEntradaProd;
    private Date fechaIngreso;
    private int idProveedor;
    public EntradaVo() {
    }
    public EntradaVo(int idEntradaProd, Date fechaIngreso, int idProveedor) {
        this.idEntradaProd = idEntradaProd;
        this.fechaIngreso = fechaIngreso;
        this.idProveedor = idProveedor;
    }
    public int getIdEntradaProd() {
        return idEntradaProd;
    }
    public void setIdEntradaProd(int idEntradaProd) {
        this.idEntradaProd = idEntradaProd;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public int getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }


}

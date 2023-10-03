package model;

import java.sql.Date;

public class VentaVo {
    private int idVenta;
    private Date fechaVenta;
    private int idUsuario;
    public VentaVo() {
    }
    public VentaVo(int idVenta, Date fechaVenta, int idUsuario) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.idUsuario = idUsuario;
    }
    public int getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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

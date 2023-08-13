package model;

import java.sql.Date;

public class ExistenciaVo {
    
    private int numSerial;
    private int idCategoria;
    private Date fechaGarantia;
    private String observaciones;
    private int idEntradaProd;
    private int idExistencia;

    public ExistenciaVo(){

    }    

    public ExistenciaVo(int numSerial, int idCategoria, Date fechaGarantia, String observaciones, int idEntradaProd, int idExistencia) {
        this.numSerial = numSerial;
        this.idCategoria = idCategoria;
        this.fechaGarantia = fechaGarantia;
        this.observaciones = observaciones;
        this.idEntradaProd = idEntradaProd;
        this.idExistencia = idExistencia;
    }

    public int getNumSerial() {
        return numSerial;
    }

    public void setNumSerial(int numSerial) {
        this.numSerial = numSerial;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Date getFechaGarantia() {
        return fechaGarantia;
    }

    public void setFechaGarantia(Date fechaGarantia) {
        this.fechaGarantia = fechaGarantia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdEntradaProd() {
        return idEntradaProd;
    }

    public void setIdEntradaProd(int idEntradaProd) {
        this.idEntradaProd = idEntradaProd;
    }

    public int getIdExistencia() {
        return idExistencia;
    }

    public void setIdExistencia(int idExistencia) {
        this.idExistencia = idExistencia;
    }

    

}

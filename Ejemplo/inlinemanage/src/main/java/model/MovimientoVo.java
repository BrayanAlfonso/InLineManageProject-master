package model;

import java.sql.Timestamp;

public class MovimientoVo{
    public int idMovimiento;
    public Timestamp fecha_hora;
    public String accion;

    
    public MovimientoVo() {
    }


    public MovimientoVo(int idMovimiento, Timestamp fecha_hora, String accion) {
        this.idMovimiento = idMovimiento;
        this.fecha_hora = fecha_hora;
        this.accion = accion;
    }


    public int getIdMovimiento() {
        return idMovimiento;
    }


    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }


    public Timestamp getFecha_hora() {
        return fecha_hora;
    }


    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }


    public String getAccion() {
        return accion;
    }


    public void setAccion(String accion) {
        this.accion = accion;
    }





    
}

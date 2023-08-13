package model;

import java.math.BigInteger;

public class UsuarioVo {
    //!NOTA En las clases Vo almacenamos los datos que nos llegan de las vistas y la base de datos. Como una pequeña ram intermediaria.
    
    //SECCION Atributos
    private int idUsuario;
    private String tipoDoc;
    private int numeroDoc;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private int idRol;



    //?SECCION Getters & Setters    
    
    public UsuarioVo() {
    }



    public UsuarioVo(int idUsuario, String tipoDoc, int numeroDoc, String nombre, String apellido, String correo,
            String contraseña, int idRol) {
        this.idUsuario = idUsuario;
        this.tipoDoc = tipoDoc;
        this.numeroDoc = numeroDoc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.idRol = idRol;
    }



    public int getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }



    public String getTipoDoc() {
        return tipoDoc;
    }



    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }



    public int getNumeroDoc() {
        return numeroDoc;
    }



    public void setNumeroDoc(int numeroDoc) {
        this.numeroDoc = numeroDoc;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getApellido() {
        return apellido;
    }



    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public String getCorreo() {
        return correo;
    }



    public void setCorreo(String correo) {
        this.correo = correo;
    }



    public String getContraseña() {
        return contraseña;
    }



    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



    public int getIdRol() {
        return idRol;
    }



    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }



    @Override
    public String toString() {
        return "UsuarioVo [idUsuario=" + idUsuario + ", tipoDoc=" + tipoDoc + ", numeroDoc=" + numeroDoc + ", nombre="
                + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contraseña=" + contraseña + ", idRol="
                + idRol + "]";
    }

    

    
}
package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String bbdd ="jdbc:mysql://localhost:3306/InLineManage";
    private static final String usuario = "root";
    private static final String clave = "";
    private static Connection conn;
    

    public static Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(bbdd, usuario, clave);
            System.out.println("la conexion con la base de datos InLineManage ha sido exitosa en la clase conexion");
        } catch (Exception e) {
            System.out.println("La conexion ha fallado en la clase conexion en model");
        }
        return conn;
    }

    public static void main(String[] args) {
        Conexion.conectar();
    }
}

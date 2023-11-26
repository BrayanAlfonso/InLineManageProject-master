package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.sql.Timestamp;

public class MovimientoDao {
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia
        //SECCION: Consultar usuario.
public List<MovimientoVo> listar() throws SQLException {
        List<MovimientoVo> movimiento = new ArrayList<>();
        sql = "select * from movimientos";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                MovimientoVo r = new MovimientoVo();    
                r.setIdMovimiento(rs.getInt("idMovimiento"));
                r.setFecha_hora(rs.getTimestamp("fecha_hora"));
                r.setAccion(rs.getString("accion"));
                movimiento.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
        return movimiento;
    }


    // Método para formatear la fecha y la hora
    public String formatDate(Timestamp timestamp) throws SQLException{
        if (timestamp != null) {
            Date date = new Date(timestamp.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }
        return "";
    }

    
}

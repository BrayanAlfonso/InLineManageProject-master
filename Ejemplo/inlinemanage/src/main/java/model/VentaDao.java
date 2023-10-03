package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDao {
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs;
    String sql=null;
    int r;

    public List<VentaVo> listar() throws SQLException {
        List<VentaVo> ventas = new ArrayList<>();
        String sql = "SELECT * FROM venta " ;
    
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
    
            while (rs.next()) {
                VentaVo ventaVo = new VentaVo();
                ventaVo.setIdVenta(rs.getInt("idVenta"));
                ventaVo.setFechaVenta(rs.getDate("fechaVenta")); // Utiliza getTimestamp para obtener fecha y hora
                ventaVo.setIdUsuario(rs.getInt("idUsuario"));
                ventas.add(ventaVo);
            }
    
            System.out.println("Consulta de ventas exitosa");
        } catch (Exception e) {
            System.out.println("La consulta de ventas tiene un error: " + e.getMessage());
            throw e;
        }
    
        return ventas;
    }
    
}

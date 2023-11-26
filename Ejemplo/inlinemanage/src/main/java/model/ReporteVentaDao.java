package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteVentaDao {
    
    //SECCION: Consultar detalle de venta.
    public List<ReporteVentaVo> listarPorInner() throws SQLException {
        List<ReporteVentaVo> reporteVenta = new ArrayList<>();
        String sql = "select * from reporteVenta" ;
    
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql)) {
    
            while (rs.next()) {
                ReporteVentaVo r = new ReporteVentaVo();

                r.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                r.setIdProducto(rs.getInt("idProducto"));
                r.setIdVenta(rs.getInt("idVenta"));
                r.setPrecioProducto(rs.getFloat("precioProducto"));
                r.setCantidad(rs.getInt("cantidad"));
                r.setFechaVenta(rs.getDate("fechaVenta"));
                r.setIdUsuario(rs.getInt("idUsuario"));
                
                reporteVenta.add(r);
                
            }
    
            System.out.println("Consulta de los reportes de ventas exitosa");
        } catch (Exception e) {
            System.out.println("La consulta de los reportes de ventas tiene un error: " + e.getMessage());
            throw e;
        }
    
        return reporteVenta;
    }

    public List<ReporteVentaVo> listarPorInnerFiltrado(Date fecha) throws SQLException {
        List<ReporteVentaVo> reporteVenta = new ArrayList<>();
        String sql = "select * from reporteVenta where fechaVenta = ?";
    
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setDate(1, fecha);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ReporteVentaVo r = new ReporteVentaVo();
    
                    r.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                    r.setIdProducto(rs.getInt("idProducto"));
                    r.setIdVenta(rs.getInt("idVenta"));
                    r.setPrecioProducto(rs.getFloat("precioProducto"));
                    r.setCantidad(rs.getInt("cantidad"));
                    r.setFechaVenta(rs.getDate("fechaVenta"));
                    r.setIdUsuario(rs.getInt("idUsuario"));
    
                    reporteVenta.add(r);
                }
    
                System.out.println("Consulta de los reportes de ventas exitosa");
            } catch (Exception e) {
                System.out.println("Error al procesar el resultado de la consulta: " + e.getMessage());
                throw e;
            }
        } catch (Exception e) {
            System.out.println("La consulta de los reportes de ventas tiene un error: " + e.getMessage());
            throw e;
        }
    
        return reporteVenta;
    }
    
}

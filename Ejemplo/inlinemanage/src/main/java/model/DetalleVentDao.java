package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentDao {

    Connection con; 
    PreparedStatement ps; 
    ResultSet rs;
    String sql=null;
    int r;

    //SECCION: Registrar detalle de venta
    public int registerDetailVent(DetalleVentVo dtventa) throws SQLException {
        sql = "INSERT INTO detalle_venta (IdProducto,IdVenta,IdUsuario,precioProducto,cantidad) values (?,?,?,?,?)";
        System.out.println(sql);
    
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dtventa.getIdProducto());
            ps.setInt(2, dtventa.getIdVenta());
            ps.setInt(3, dtventa.getIdUsuario());
            ps.setFloat(4, dtventa.getPrecioProducto());
            ps.setInt(5, dtventa.getCantidad());
            
            
            System.out.println(ps);
    
            ps.executeUpdate();
            ps.close();
    
            System.out.println("Se registró los detalles de la venta correctamente");
        } catch (Exception e) {
            System.out.println("No se registraron los detalles de la venta correctamente: " + e.getMessage().toString());
        } finally {
            con.close();
        }
    
        return r;
    }

    //SECCION: Consultar detalle de venta.
    public List<DetalleVentVo> listar() throws SQLException {
        List<DetalleVentVo> dtventa = new ArrayList<>();
        String sql = "SELECT * FROM detalle_venta " ;
    
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql)) {
    
            while (rs.next()) {
                DetalleVentVo r = new DetalleVentVo();
                r.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                r.setIdProducto(rs.getInt("idProducto"));
                r.setIdVenta(rs.getInt("idVenta"));
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setPrecioProducto(rs.getFloat("precioProducto"));
                r.setCantidad(rs.getInt("cantidad"));
                dtventa.add(r);
            }
    
            System.out.println("Consulta de los detalles de ventas exitosa");
        } catch (Exception e) {
            System.out.println("La consulta de los detalles de ventas tiene un error: " + e.getMessage());
            throw e;
        }
    
        return dtventa;
    }

    public DetalleVentVo obtenerVentaPorId(int idDetalleVenta) throws SQLException {
        sql = "SELECT * FROM detalle_venta WHERE idDetalleVenta  = ?";
        DetalleVentVo dtventa = null;
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setInt(1, idDetalleVenta);
    
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dtventa = new DetalleVentVo();
                    dtventa.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                    dtventa.setIdProducto(rs.getInt("idProducto"));
                    dtventa.setIdVenta(rs.getInt("idVenta"));
                    dtventa.setIdUsuario(rs.getInt("idUsuario"));  
                    dtventa.setPrecioProducto(rs.getFloat("precioProducto"));
                    dtventa.setCantidad(rs.getInt("cantidad"));
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener el detalle de la venta: " + e.getMessage());
            }
            return dtventa;
        }
    }


    public List<DetalleVentVo> listarPorIdVenta(int idVenta) throws SQLException {
        sql = "SELECT * FROM detalle_venta WHERE idVenta = ?";
        List<DetalleVentVo> listaDeDetallesDeVenta = new ArrayList<>();
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setInt(1, idVenta);
    
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetalleVentVo dtventa = new DetalleVentVo();
                    dtventa.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                    dtventa.setIdProducto(rs.getInt("idProducto"));
                    dtventa.setIdVenta(rs.getInt("idVenta"));
                    dtventa.setIdUsuario(rs.getInt("idUsuario"));
                    dtventa.setPrecioProducto(rs.getFloat("precioProducto"));
                    dtventa.setCantidad(rs.getInt("cantidad"));
                    listaDeDetallesDeVenta.add(dtventa);
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener detalles de venta: " + e.getMessage());
            }
        }
        return listaDeDetallesDeVenta;
    }
    
}

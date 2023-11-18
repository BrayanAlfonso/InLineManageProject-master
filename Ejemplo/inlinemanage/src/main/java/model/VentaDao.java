package model;

import java.sql.Statement;
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

//SECCION: Registrar venta
public int registerVent(VentaVo venta) throws SQLException {
    sql = "INSERT INTO venta (fechaVenta,IdUsuario) values (?,?)";
    
    try {
        con = Conexion.conectar();
        ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setDate(1, venta.getFechaVenta());
        ps.setInt(2, venta.getIdUsuario());

        ps.executeUpdate();

        // Obtener el idVenta generado
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (Exception e) {
        System.out.println("No se registró la venta correctamente: " + e.getMessage());
    } finally {
        con.close();
    }

    return 0; // o algún valor que indique un fallo
}


    //SECCION: Consultar venta.
    public List<VentaVo> listar() throws SQLException {
        List<VentaVo> venta = new ArrayList<>();
        String sql = "SELECT * FROM venta " ;
    
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql)) {
    
            while (rs.next()) {
                VentaVo r = new VentaVo();
                r.setIdVenta(rs.getInt("idVenta"));
                r.setFechaVenta(rs.getDate("fechaVenta")); // Utiliza getTimestamp para obtener fecha y hora
                r.setIdUsuario(rs.getInt("idUsuario"));
                venta.add(r);
            }
    
            System.out.println("Consulta de ventas exitosa");
        } catch (Exception e) {
            System.out.println("La consulta de ventas tiene un error: " + e.getMessage());
            throw e;
        }
    
        return venta;
    }

    // //SECCION: Actualizar venta.
    // public int actualizar(VentaVo venta) throws SQLException{

    //     sql="update venta set fechaVenta = ?, set idUsuario = ? where idVenta = ?"; 
    //     System.out.println(sql);

    //     try{
    //         con=Conexion.conectar(); //abrir conexión.
    //         ps=con.prepareStatement(sql); //preparar sentencia.
            
    //         ps.setDate(1, venta.getFechaVenta());
    //         ps.setInt(2, venta.getIdUsuario());
    //         ps.setInt(3, venta.getIdVenta());

    //         System.out.println(ps);
    //         ps.executeUpdate(); //Ejecutar sentencia.
    //         ps.close(); //cerrar sentencia.
    //         System.out.println("Se actualizó el registro de la venta correctamente, revisa la base de datos.");

    //     }catch(Exception e){

    //         System.out.println("VentaDao dice: Error en la actualizacion del registro "+e.getMessage().toString());

    //     }
    //     finally{
    //         con.close();//cerrando conexión
    //     }
    //     return r;
    // }

    public VentaVo obtenerVentaPorId(int idVenta) throws SQLException {
        sql = "SELECT * FROM venta WHERE idVenta  = ?";
        VentaVo venta = null;
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setInt(1, idVenta);
    
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    venta = new VentaVo();
                    venta.setIdVenta(rs.getInt("idVenta"));
                    venta.setFechaVenta(rs.getDate("fechaVenta"));
                    venta.setIdUsuario(rs.getInt("idUsuario"));               
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener la venta: " + e.getMessage());
            }
            return venta;
        }
    }

    // //SECCION: Eliminar Venta
    // public void eliminar(int idVenta) throws SQLException {
    //     sql = "DELETE FROM venta WHERE idVenta = ?";
    //     try (Connection con = Conexion.conectar();
    //             PreparedStatement ps = con.prepareStatement(sql)) {
    //         ps.setInt(1, idVenta);
    //         ps.executeUpdate();
    //     } catch (SQLException e) {
    //         System.out.println("Error al eliminar la venta: " + e.getMessage());
    //         throw e;
    //     }
    // }
}

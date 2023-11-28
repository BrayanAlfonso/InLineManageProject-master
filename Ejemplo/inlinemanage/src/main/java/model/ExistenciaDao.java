package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExistenciaDao {
    
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    //SECCION: Crear existencia.
    public int registerExistence(ExistenciaVo existencia) throws SQLException {
        sql = "INSERT INTO existencia (cantidadUnidad, precioEntrada, idProducto, idEntradaProd) values (?, ?, ?, ?)";
        System.out.println(sql);
    
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, existencia.getCantidadUnidad());
            ps.setFloat(2, existencia.getPrecioEntrada());
            ps.setInt(3, existencia.getIdProducto());
            ps.setInt(4, existencia.getIdEntradaProd());
            
    
            System.out.println(ps);
    
            ps.executeUpdate();
            ps.close();
    
            System.out.println("Se registró la existencia correctamente");
        } catch (Exception e) {
            System.out.println("No se registró la existencia correctamente: " + e.getMessage().toString());
        } finally {
            con.close();
        }
    
        return r;
    }

     //SECCION: Consultar existencia.
     public List<ExistenciaVo> listarExist() throws SQLException {
        List<ExistenciaVo> existencia = new ArrayList<>();
        sql = "select * from existencia";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                ExistenciaVo r = new ExistenciaVo();
                r.setIdExistencia(rs.getInt("idExistencia"));
                r.setCantidadUnidad(rs.getInt("cantidadUnidad"));
                r.setPrecioEntrada(rs.getFloat("precioEntrada"));
                r.setIdProducto(rs.getInt("idProducto"));
                r.setIdEntradaProd(rs.getInt("idEntradaProd"));

                existencia.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return existencia;
    }

    //SECCION: Actualizar existencia.
    public int updateExistence(ExistenciaVo existencia) throws SQLException{

        sql="update existencia set cantidadUnidad = ?, precioEntrada = ?, idProducto = ?, idEntradaProd = ?  where idExistencia = ?"; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
                
            ps.setInt(1, existencia.getCantidadUnidad());
            ps.setFloat(2, existencia.getPrecioEntrada());
            ps.setInt(3,existencia.getIdProducto());
            ps.setInt(4,existencia.getIdEntradaProd());
            ps.setInt(5, existencia.getIdExistencia());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro de la existencia correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("ExistenciaDao dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public ExistenciaVo obtenerExistencePorId(int idExistencia) throws SQLException {
        sql = "SELECT * FROM existencia WHERE idExistencia  = ?";
        ExistenciaVo exist = null;
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setInt(1, idExistencia);
    
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    exist = new ExistenciaVo();
                    exist.setIdExistencia(rs.getInt("idExistencia"));
                    exist.setCantidadUnidad(rs.getInt("cantidadUnidad"));
                    exist.setPrecioEntrada(rs.getFloat("precioEntrada"));
                    exist.setIdProducto(rs.getInt("idProducto"));
                    exist.setIdEntradaProd(rs.getInt("idEntradaprod"));

                }
            } catch (SQLException e) {
                System.out.println("Error al obtener la existencia: " + e.getMessage());
            }
            return exist;
        }
    }

    //SECCION: Eliminar existencia.
    public void deleteExistence(int existId) throws SQLException {
        sql = "DELETE FROM existencia WHERE idExistencia = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, existId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la existencia: " + e.getMessage());
            throw e;
        }
    }


}

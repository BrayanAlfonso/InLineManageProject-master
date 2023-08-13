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
        sql = "INSERT INTO existencia (numSerial, idCategoria, fechaGaramtia, observaciones, idEntradaProd, idExistencia) values (?, ?, ?, ?, ?, ?)";
        System.out.println(sql);
    
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, existencia.getNumSerial());
            ps.setInt(2, existencia.getIdCategoria());
            ps.setDate(3, existencia.getFechaGarantia());
            ps.setString(4, existencia.getObservaciones());
            ps.setInt(5, existencia.getIdEntradaProd());
            ps.setInt(6, existencia.getIdExistencia());
    
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
                r.setNumSerial(rs.getInt("numSerial"));
                r.setIdCategoria(rs.getInt("idCategoria"));
                r.setFechaGarantia(rs.getDate("fechaGarantia"));
                r.setObservaciones(rs.getString("observaciones"));
                r.setIdEntradaProd(rs.getInt("idEntradaProd"));
                r.setIdExistencia(rs.getInt("idExistencia"));

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
    public int actualizarExistence(ExistenciaVo existencia) throws SQLException{

        sql="update existencia set numSerial = ?, idCategoria = ?, fechaGarantia = ?, observaciones = ?, idEntradaProd = ?, idexistencia = ?  where idExistencia = ?"; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
                
            ps.setInt(1,existencia.getNumSerial());
            ps.setInt(2, existencia.getIdCategoria());
            ps.setDate(3, existencia.getFechaGarantia());
            ps.setString(4,existencia.getObservaciones());
            ps.setInt(5,existencia.getIdEntradaProd());
            ps.setInt(6, existencia.getIdExistencia());
            

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
        ExistenciaVo existencia = null;
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setInt(1, idExistencia);
    
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    existencia = new ExistenciaVo();
                    existencia.setNumSerial(rs.getInt("numSerial"));
                    existencia.setIdCategoria(rs.getInt("idCategoria"));
                    existencia.setFechaGarantia(rs.getDate("fechagarantia"));
                    existencia.setObservaciones(rs.getString("observaciones"));
                    existencia.setIdEntradaProd(rs.getInt("idEntradaprod"));
                    existencia.setIdExistencia(rs.getInt("idExistencia"));
                    
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener la existencia: " + e.getMessage());
            }
            return existencia;
        }
    }

    //SECCION: Eliminar existencia.
    public void eliminarExistence(int idExistencia) throws SQLException {
        sql = "DELETE FROM existencia WHERE idExistencia = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idExistencia);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la existencia: " + e.getMessage());
            throw e;
        }
    }


}

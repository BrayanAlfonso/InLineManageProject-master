package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntradaDao {
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    //registro de entrada
     public int registerEntrada(EntradaVo entrada) throws SQLException {
        sql = "INSERT INTO entradaprod (fechaIngreso,idProveedor) values (?,?)";
        System.out.println(sql);
    
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(entrada.getFechaIngreso().getTime()));
            ps.setInt(2, entrada.getIdProveedor());
            
            
            System.out.println(ps);
    
            ps.executeUpdate();
            ps.close();
    
            System.out.println("Se registró la entrada de producto correctamente");
        } catch (Exception e) {
            System.out.println("No se registró la entrada de producto correctamente: " + e.getMessage().toString());
        } finally {
            con.close();
        }
    
        return r;
    }


     //SECCION: Consultar entradas.
    public List<EntradaVo> listar() throws SQLException {
        List<EntradaVo> entrada = new ArrayList<>();
        sql = "select * from entradaprod";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {

                EntradaVo r = new EntradaVo();
                r.setIdEntradaProd(rs.getInt("idEntradaProd"));
                r.setFechaIngreso(rs.getDate("fechaIngreso"));
                r.setIdProveedor(rs.getInt("idProveedor"));

                entrada.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return entrada;
    }

     //SECCION: Actualizar entrada.
     public int actualizar(EntradaVo entrada) throws SQLException{

        sql="update entradaprod set fechaIngreso = ?, idProveedor = ? where idEntradaProd = ?"; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.

            ps.setDate(1, new java.sql.Date(entrada.getFechaIngreso().getTime()));
            ps.setInt(2, entrada.getIdProveedor());
            ps.setInt(3, entrada.getIdEntradaProd());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro de la entrada correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("CategoriaDao dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public EntradaVo obtenerEntradaPorId(int idEntradaProd) throws SQLException {
        sql = "SELECT * FROM entradaprod WHERE idEntradaProd  = ?";
        EntradaVo entrada = null;
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setInt(1, idEntradaProd);
    
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entrada = new EntradaVo();
                    entrada.setIdEntradaProd(rs.getInt("idEntradaProd"));
                    entrada.setFechaIngreso(rs.getDate("fechaIngreso"));
                    entrada.setIdProveedor(rs.getInt("idProveedor"));
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener la entrada: " + e.getMessage());
            }
            return entrada;
        }
    }

    //SECCION: Eliminar entrada.

    public void deleteEntrada(int idEntradaProd) throws SQLException {
        sql = "DELETE FROM entradaprod WHERE idEntradaProd = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idEntradaProd);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la entrada: " + e.getMessage());
            throw e;
        }
    }

}

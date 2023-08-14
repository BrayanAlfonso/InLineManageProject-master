package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public int registerCategory(CategoriaVo categoria) throws SQLException {
        sql = "INSERT INTO categoria (nombreCategoria) values (?)";
        System.out.println(sql);
    
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoria.getNombreCategoria());
            
            
            System.out.println(ps);
    
            ps.executeUpdate();
            ps.close();
    
            System.out.println("Se registró la categoria correctamente");
        } catch (Exception e) {
            System.out.println("No se registró la categoria correctamente: " + e.getMessage().toString());
        } finally {
            con.close();
        }
    
        return r;
    }
    

    //SECCION: Consultar usuario.
    public List<CategoriaVo> listar() throws SQLException {
        List<CategoriaVo> categoria = new ArrayList<>();
        sql = "select * from categoria";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {

                CategoriaVo r = new CategoriaVo();
                r.setIdCategoria(rs.getInt("idCategoria"));
                r.setNombreCategoria(rs.getString("nombreCategoria"));


                categoria.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return categoria;
    }


        //SECCION: Actualizar usuario.
        public int actualizar(CategoriaVo categoria) throws SQLException{

            sql="update categoria set nombreCategoria = ? where idCategoria = ?"; 
            System.out.println(sql);
    
            try{
                con=Conexion.conectar(); //abrir conexión.
                ps=con.prepareStatement(sql); //preparar sentencia.
                
                ps.setString(1, categoria.getNombreCategoria());
                ps.setInt(2, categoria.getIdCategoria());

                System.out.println(ps);
                ps.executeUpdate(); //Ejecutar sentencia.
                ps.close(); //cerrar sentencia.
                System.out.println("Se actualizó el registro de la categoria correctamente, revisa la base de datos.");
    
            }catch(Exception e){
    
                System.out.println("CategoriaDao dice: Error en la actualizacion del registro "+e.getMessage().toString());
    
            }
            finally{
                con.close();//cerrando conexión
            }
            return r;
        }

        public CategoriaVo obtenerCategorytPorId(int idCategoria) throws SQLException {
            sql = "SELECT * FROM categoria WHERE idCategoria  = ?";
            CategoriaVo categoria = null;
            try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
        
                ps.setInt(1, idCategoria);
        
                try(ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        categoria = new CategoriaVo();
                        categoria.setIdCategoria(rs.getInt("idCategoria"));
                        categoria.setNombreCategoria(rs.getString("nombreCategoria"));                  
                    }
                } catch (SQLException e) {
                    System.out.println("Error al obtener la categoria: " + e.getMessage());
                }
                return categoria;
            }
        }

        public void eliminar(int idCategoria) throws SQLException {
            sql = "DELETE FROM categoria WHERE idCategoria = ?";
            try (Connection con = Conexion.conectar();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idCategoria);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al eliminar la categoria: " + e.getMessage());
                throw e;
            }
        }
}

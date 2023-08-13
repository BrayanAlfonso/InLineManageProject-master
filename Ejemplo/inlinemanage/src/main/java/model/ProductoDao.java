
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public int registerProduct(ProductoVo producto) throws SQLException {
        sql = "INSERT INTO producto (numSerial, nombreProducto, precioProducto, descripcion, idCategoria, idExistencia) values (?, ?, ?, ?, ?, ?)";
        System.out.println(sql);
    
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getNumSerial());
            ps.setString(2, producto.getNombreProducto());
            ps.setInt(3, producto.getPrecioProducto());
            ps.setString(4, producto.getDescripcion());
            ps.setInt(5, producto.getIdCategoria());
            ps.setInt(6, producto.getIdExistencia());
    
            System.out.println(ps);
    
            ps.executeUpdate();
            ps.close();
    
            System.out.println("Se registró el producto correctamente");
        } catch (Exception e) {
            System.out.println("No se registró el producto correctamente: " + e.getMessage().toString());
        } finally {
            con.close();
        }
    
        return r;
    }
    

    //SECCION: Consultar usuario.
    public List<ProductoVo> listar() throws SQLException {
        List<ProductoVo> producto = new ArrayList<>();
        sql = "select * from producto";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                ProductoVo r = new ProductoVo();
                r.setIdProducto(rs.getInt("idProducto"));
                r.setNombreProducto(rs.getString("nombreProducto"));
                r.setPrecioProducto(rs.getInt("precioProducto"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setIdCategoria(rs.getInt("idCategoria"));
                r.setIdExistencia(rs.getInt("idExistencia"));

                producto.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return producto;
    }


        //SECCION: Actualizar usuario.
        public int actualizar(ProductoVo producto) throws SQLException{

            sql="update producto set nombreProducto = ?, precioProducto = ?, descripcion = ?, idCategoria = ?, idExistencia = ?, numSerial = ?  where idProducto = ?"; 
            System.out.println(sql);
    
            try{
                con=Conexion.conectar(); //abrir conexión.
                ps=con.prepareStatement(sql); //preparar sentencia.
                    
                ps.setString(1,producto.getNombreProducto());
                ps.setInt(2, producto.getPrecioProducto());
                ps.setString(3, producto.getDescripcion());
                ps.setInt(4,producto.getIdCategoria());
                ps.setInt(5,producto.getIdExistencia());
                ps.setInt(6, producto.getNumSerial());
                ps.setInt(7, producto.getIdProducto());
                

                System.out.println(ps);
                ps.executeUpdate(); //Ejecutar sentencia.
                ps.close(); //cerrar sentencia.
                System.out.println("Se actualizó el registro del producto correctamente, revisa la base de datos.");
    
            }catch(Exception e){
    
                System.out.println("ProductoDao dice: Error en la actualizacion del registro "+e.getMessage().toString());
    
            }
            finally{
                con.close();//cerrando conexión
            }
            return r;
        }

        public ProductoVo obtenerProductPorId(int idProducto) throws SQLException {
            sql = "SELECT * FROM producto WHERE idProducto  = ?";
            ProductoVo producto = null;
            try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
        
                ps.setInt(1, idProducto);
        
                try(ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        producto = new ProductoVo();
                        producto.setIdProducto(rs.getInt("idProducto"));
                        producto.setNombreProducto(rs.getString("nombreProducto"));
                        producto.setPrecioProducto(rs.getInt("precioProducto"));
                        producto.setDescripcion(rs.getString("descripcion"));
                        producto.setIdCategoria(rs.getInt("idCategoria"));
                        producto.setIdExistencia(rs.getInt("idExistencia"));
                        producto.setNumSerial(rs.getInt("numSerial"));
                        
                    }
                } catch (SQLException e) {
                    System.out.println("Error al obtener el producto: " + e.getMessage());
                }
                return producto;
            }
        }

        public void eliminar(int idProducto) throws SQLException {
            sql = "DELETE FROM producto WHERE idProducto = ?";
            try (Connection con = Conexion.conectar();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idProducto);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al eliminar el producto: " + e.getMessage());
                throw e;
            }
        }
}
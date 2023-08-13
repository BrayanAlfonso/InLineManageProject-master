package model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDao {
        //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.

    //SECCION:  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia


    public int registrarProducto(ProductoVo producto) throws SQLException{
        sql="INSERT INTO product (name_product, value_product, id_category) VALUES (?, ?, ?)";
        System.out.println(sql);

        try {
            con=Conexion.conectar();//Hacer una conexion con la base de datos
            ps=con.prepareStatement(sql); //Prepara la sentencia
            ps.setString(1, producto.getName_product());
            ps.setFloat(2,  producto.getValue_product());
            ps.setInt(3, producto.getId_category());
            System.out.println(ps);

            ps.executeUpdate();
            ps.close();

            System.out.println("Se registro el producto correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar el prodducto (ProductoDao)");
        }finally{
            con.close();
        }

        return r;
    }

    
    //SECCION: Consultar producto.
    public List<ProductoVo> listarProducto() throws SQLException {
        List<ProductoVo> producto = new ArrayList<>();
        sql = "select * from product";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                ProductoVo p = new ProductoVo();
                p.setId_product(rs.getInt("id_product"));
                p.setName_product(rs.getString("name_product"));
                p.setValue_product(rs.getFloat("value_product"));
                p.setId_category(rs.getInt("id_category"));
                producto.add(p);
            }
            ps.close();
            System.out.println("consulta de productos exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta de productos no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return producto;
    }
    




    //SECCION: Actualizar producto.
    public int actualizarProducto(ProductoVo Producto) throws SQLException{

        sql="update product set name_product = ?, value_product = ?, id_category = ? where user_id = ?"; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Producto.getName_product());
            ps.setFloat(2, Producto.getValue_product());
            ps.setInt(3, Producto.getId_category());
            ps.setInt(4, Producto.getId_product());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del producto correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("ProductoDao dice: Error en la actualizacion del producto "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }


    public ProductoVo obtenerProductoPorId(int id_product) throws SQLException {
    sql = "SELECT * FROM product WHERE id_product = ?";
    ProductoVo producto = null;
    try(Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id_product);

        try(ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                producto = new ProductoVo();
                producto.setId_product(rs.getInt("id_product"));
                producto.setName_product(rs.getString("name_product"));
                producto.setValue_product(rs.getFloat("value_product"));
                producto.setId_category(rs.getInt("id_category"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto: " + e.getMessage());
        }
        return producto;
    }
}


public void eliminarProducto(int id_product) throws SQLException {
    sql = "DELETE FROM product WHERE id_product = ?";
    try (Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, id_product);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al eliminar el producto: " + e.getMessage());
        throw e;
    }
}
}

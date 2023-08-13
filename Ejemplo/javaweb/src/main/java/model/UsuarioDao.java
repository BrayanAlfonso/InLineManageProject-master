package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UsuarioDao {
    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.

    //SECCION:  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    //SECCION: Registrar usuario.
    public int registrar(UsuarioVo Usuario) throws SQLException{

        sql="INSERT INTO users_tbl (user_firstname, user_lastname, user_email, user_password) values (?,?,?,?)";
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Usuario.getUserFirstName());
            ps.setString(2, Usuario.getUserLastName());
            ps.setString(3, Usuario.getUserEmail());
            ps.setString(4, Usuario.getUserPassword());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se registró el usuario correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("UsuarioDao dice: Error en el regisro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }
    //SECCION: Consultar usuario.
    public List<UsuarioVo> listar() throws SQLException {
        List<UsuarioVo> usuario = new ArrayList<>();
        sql = "select * from users_tbl";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                UsuarioVo r = new UsuarioVo();
                r.setUserId(rs.getInt("user_id"));
                r.setUserFirstName(rs.getString("user_firstname"));
                r.setUserLastName(rs.getString("user_lastname"));
                r.setUserEmail(rs.getString("user_email"));
                r.setUserPassword(rs.getString("user_password"));
                usuario.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return usuario;
    }
    




    //SECCION: Actualizar usuario.
    public int actualizar(UsuarioVo Usuario) throws SQLException{

        sql="update users_tbl set user_firstname = ?, user_lastname = ?, user_email = ?, user_password = ? where user_id = ?"; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Usuario.getUserFirstName());
            ps.setString(2, Usuario.getUserLastName());
            ps.setString(3, Usuario.getUserEmail());
            ps.setString(4, Usuario.getUserPassword());
            ps.setInt(5, Usuario.getUserId());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del usuario correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("UsuarioDao dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public UsuarioVo obtenerUsuario(String nombre, String contrasena) throws SQLException {
        sql = "SELECT * FROM users_tbl WHERE user_firstname = ? AND user_password = ?";
        UsuarioVo usuario = null;
        System.out.println("Actualmente se encuentra en el login.");
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, contrasena);

            try(ResultSet rs = ps.executeQuery();){ 
                if (rs.next()){ 
                usuario=new UsuarioVo();
                usuario.setUserFirstName(rs.getString("user_firstname"));
                usuario.setUserPassword(rs.getString("user_password"));
            // Asignar otras propiedades según corresponda
            
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        } 
            return usuario;
        }

    }

    public UsuarioVo obtenerUsuarioPorId(int userId) throws SQLException {
    sql = "SELECT * FROM users_tbl WHERE user_id = ?";
    UsuarioVo usuario = null;
    try(Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, userId);

        try(ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                usuario = new UsuarioVo();
                usuario.setUserId(rs.getInt("user_id"));
                usuario.setUserFirstName(rs.getString("user_firstname"));
                usuario.setUserLastName(rs.getString("user_lastname"));
                usuario.setUserEmail(rs.getString("user_email"));
                usuario.setUserPassword(rs.getString("user_password"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }
        return usuario;
    }
}


public void eliminar(int userId) throws SQLException {
    sql = "DELETE FROM users_tbl WHERE user_id = ?";
    try (Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, userId);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al eliminar el usuario: " + e.getMessage());
        throw e;
    }
}

}
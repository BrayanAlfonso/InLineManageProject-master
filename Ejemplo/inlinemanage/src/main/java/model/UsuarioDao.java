package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UsuarioDao {
    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.

    //?SECCION:  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia


    //?validacion de login
    public boolean validarLogin(String userName, String password) throws SQLException{
        sql="select 1 from usuario where nombre=? and contraseña=?";
        System.out.println(sql);

        try {
            con=Conexion.conectar();//Hacer una conexion con la base de datos
            ps=con.prepareStatement(sql); //Prepara la sentencia

            ps.setString(1, userName);
            ps.setString(2, password);

            try(ResultSet rs=ps.executeQuery()){
                System.out.println(rs);
                return rs.next();
            }
        } catch (Exception e) {
            System.out.println("Error en la validacion del login en UsuarioDao" +e.getMessage().toString() );
        }finally{
            con.close();
        }

        return false;
        
    }

    public int obtenerIdUsuarioPorNombre(String userName) throws SQLException {
        int idUsuario = -1;  // Valor predeterminado en caso de error
    
        sql = "SELECT idUsuario FROM usuario WHERE nombre=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
    
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idUsuario = rs.getInt("idUsuario");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener idUsuario por nombre en UsuarioDao: " + e.getMessage());
        } finally {
            con.close();
        }
    
        return idUsuario;
    }
    


    //?SECCION: Registrar usuario.

    public int registerUserDao(UsuarioVo user) throws SQLException{
        sql="INSERT INTO usuario (tipoDoc, numeroDoc, nombre, apellido, correo, contraseña, idRol) values(?,?,?,?,?,?,?)";
        System.out.println(sql);

        try {
            con=Conexion.conectar();//Hacer una conexion con la base de datos
            ps=con.prepareStatement(sql); //Prepara la sentencia
            ps.setString(1, user.getTipoDoc());
            ps.setInt(2, user.getNumeroDoc());
            ps.setString(3,user.getNombre());
            ps.setString(4, user.getApellido());
            ps.setString(5, user.getCorreo());
            ps.setString(6, user.getContraseña());
            ps.setInt(7, user.getIdRol());

            System.out.println(ps);

            ps.executeUpdate();
            ps.close();

            System.out.println("Se registro el usaurio correctamente en UsuarioDao");
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario en usuarioDao en el metodo registerUserdao" +e.getMessage().toString() );
        }finally{
            con.close();
        }
        return r;
    }
    
//?Metodo para listar usuaraios

public List<UsuarioVo> listar() throws SQLException{
    List<UsuarioVo> user= new ArrayList<>();

    sql="Select * from usuario limit 9";

    try {
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);

        while(rs.next()){
            UsuarioVo UsuVo=new UsuarioVo();

            UsuVo.setIdUsuario(rs.getInt("idUsuario"));
            UsuVo.setTipoDoc(rs.getString("tipoDoc"));
            UsuVo.setNumeroDoc(rs.getInt("numeroDoc"));
            UsuVo.setNombre(rs.getString("nombre"));
            UsuVo.setApellido(rs.getString("apellido"));
            UsuVo.setCorreo(rs.getString("correo"));
            UsuVo.setContraseña(rs.getString("contraseña"));
            UsuVo.setIdRol(rs.getInt("idRol"));

            user.add(UsuVo);
        }
        ps.close();
        System.out.println("Consulta de usuarios exitosa");

    } catch (Exception e) {
        System.out.println("La consulta de usuarios tiene un error" +e.getMessage().toString());
        throw e;
    }finally{
        con.close();
    }
    return user;
}


public UsuarioVo obtenerUsuarioPorId(int idUsuario) throws SQLException {
    sql = "SELECT * FROM usuario WHERE idUsuario = ?";
    UsuarioVo user = null;
    try(Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idUsuario);

        try(ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                user = new UsuarioVo();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setTipoDoc(rs.getString("tipoDoc"));
                user.setNumeroDoc(rs.getInt("numeroDoc"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setCorreo(rs.getString("correo"));
                user.setContraseña(rs.getString("contraseña"));
                user.setIdRol(rs.getInt("idRol"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }
        return user;
    }
}

    //Actualizar usuario.
    public int updateUserDao(UsuarioVo User) throws SQLException{

        sql="update usuario set tipoDoc=?, numeroDoc=?, nombre=?, apellido=?, correo=?, contraseña=?, idRol=? where idUsuario = ?"; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, User.getTipoDoc());
            ps.setInt(2, User.getNumeroDoc());
            ps.setString(3, User.getNombre());
            ps.setString(4, User.getApellido());
            ps.setString(5, User.getCorreo());
            ps.setString(6, User.getContraseña());
            ps.setInt(7, User.getIdRol());
            ps.setInt(8, User.getIdUsuario());


            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del usuario correctamente.");

        }catch(Exception e){

            System.out.println("Error en la actualizacion del usuario en usuarioDao metodo updateUserDao "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public void deleteUser(int userId) throws SQLException {
        sql = "DELETE FROM usuario WHERE idUsuario = ?";
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
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDao {
    
     //SECCION:  Atributos para realizar acciones en la base de datos.   e
     Connection con; //objeto de conexión
     PreparedStatement ps; //preparar sentencias
     ResultSet rs; // almacenar consutas
     String sql=null;
     int r; //cantidad de filas que devuelve una sentencia

     //Registrar proveedor.

     public int registerSupplier(ProveedorVo prov) throws SQLException{
     sql="INSERT INTO proveedor (nombreProveedor, direccionProveedor) values(?,?)";
     System.out.println(sql);

     try {
         con=Conexion.conectar();//Hacer una conexion con la base de datos
         ps=con.prepareStatement(sql); //Prepara la sentencia
         ps.setString(1, prov.getNombreProveedor());
         ps.setString(2, prov.getDireccionProveedor());

         System.out.println(ps);

         ps.executeUpdate();
         ps.close();

         System.out.println("Se registro el proveedor correctamente en ProveedorDao");
     } catch (Exception e) {
         System.out.println("Error al registrar el proveedor en ProveedorDao en el metodo registerUserdao" +e.getMessage().toString() );
     }finally{
         con.close();
     }
     return r;
 }

 //Metodo para listar proveedores

public List<ProveedorVo> listarProv() throws SQLException{
    List<ProveedorVo> prov= new ArrayList<>();

    sql="Select * from proveedor";

    try {
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);

        while(rs.next()){
            ProveedorVo ProVo=new ProveedorVo();

            ProVo.setIdProveedor(rs.getInt("idProveedor"));
            ProVo.setNombreProveedor(rs.getString("nombreProveedor"));
            ProVo.setDireccionProveedor(rs.getString("direccionProveedor"));

            prov.add(ProVo);
        }
        ps.close();
        System.out.println("Consulta de provedores exitosa");

    } catch (Exception e) {
        System.out.println("La consulta de proveedores tiene un error" +e.getMessage().toString());
        throw e;
    }finally{
        con.close();
    }
    return prov;
}

public ProveedorVo obtenerProveedorPorId(int idProveedor) throws SQLException {
    sql = "SELECT * FROM proveedor WHERE idProveedor = ?";
    ProveedorVo prov = null;
    try(Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idProveedor);

        try(ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                prov = new ProveedorVo();
                prov.setIdProveedor(rs.getInt("idProveedor"));
                prov.setNombreProveedor(rs.getString("nombreProveedor"));
                prov.setDireccionProveedor(rs.getString("direccionProveedor"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el proveedor: " + e.getMessage());
        }
        return prov;
    }
}

//Actualizar proveedor.
public int updateSupplier(ProveedorVo prov) throws SQLException{

    sql="update proveedor set nombreProveedor=?, direccionProveedor=? where idProveedor = ?"; 
    System.out.println(sql);

    try{
        con=Conexion.conectar(); //abrir conexión.
        ps=con.prepareStatement(sql); //preparar sentencia.
        ps.setString(1, prov.getNombreProveedor());
        ps.setString(2, prov.getDireccionProveedor());
        ps.setInt(3, prov.getIdProveedor());


        System.out.println(ps);
        ps.executeUpdate(); //Ejecutar sentencia.
        ps.close(); //cerrar sentencia.
        System.out.println("Se actualizó el registro del proveedor correctamente.");

    }catch(Exception e){

        System.out.println("Error en la actualizacion del proveedor en ProveedorDao metodo updateProvDao "+e.getMessage().toString());

    }
    finally{
        con.close();//cerrando conexión
    }
    return r;
}

//Eliminar proveedor
public void deleteSupplier(int provId) throws SQLException {
    sql = "DELETE FROM proveedor WHERE idProveedor = ?";
    try (Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, provId);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al eliminar el proveedor: " + e.getMessage());
        throw e;
    }
}

}

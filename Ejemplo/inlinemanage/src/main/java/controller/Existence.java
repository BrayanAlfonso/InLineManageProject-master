package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ExistenciaDao;
import model.ExistenciaVo;

public class Existence extends HttpServlet{
    ExistenciaDao ExistDao=new ExistenciaDao();
    ExistenciaVo ExistVo=new ExistenciaVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            case "existence":
                req.getRequestDispatcher("FormsExistence/indexExistence.jsp").forward(req, resp);
            break;
    
            case "registerExistence":
                req.getRequestDispatcher("FormsExistence/registerExistence.jsp").forward(req, resp);
            break;
            //Actualizar la existencia
            case "updateExistence":
            // Obtener el user_id del usuario seleccionado desde la URL
            String existIdStr = req.getParameter("idExistencia");
            int existId = Integer.parseInt(existIdStr);

            try {
                // Obtener el usuario por su id y enviarlo al formulario de actualización
                ExistenciaVo existencia = new ExistenciaDao().obtenerExistencePorId(existId);

                if (existencia != null) {
                    req.setAttribute("Existencia", existencia);
                    req.getRequestDispatcher("FormsExistence/updateExistence.jsp").forward(req, resp);
                } else {
                    // Si no se encuentra el proveedor, redirigir a la página de listado con un mensaje de error
                    List<ExistenciaVo> existencias = new ExistenciaDao().listarExist();
                    req.setAttribute("Proveedores", existencias);
                    req.setAttribute("mensaje", "La existencia seleccionado no existe.");
                    req.getRequestDispatcher("FormsExistence/indexExistence.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener la existencia");
            }
            break;

            //Eliminar el producto
            case "deleteExistence":
            String ExistIdStrDelete = req.getParameter("idExistencia");
                int ExistIdDelete = Integer.parseInt(ExistIdStrDelete);

                try {
                    new ExistenciaDao().deleteExistence(ExistIdDelete);
                    System.out.println("Existencia eliminada correctamente");
                    listExistDelete(req, resp);
                    
                } catch (Exception e) {
                    // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
                    e.printStackTrace();
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener la existencia");
                }
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            //Existencias
            case"registerExistence":
            System.out.println("Se entro al caso 'registerExistence, en el metodo registerExistence()'");
            registerExistenceController(req, resp);
            break;
    
            case"updateExistence":
            System.out.println("Se entro al caso 'updateExistence, en el metodo updateExistence()'");
            updateExistenceController(req, resp);
            break;
        }
    }

        
        //CRUD EXISTENCIAS

    //REGISTRAR EXISTENCIA
    private void registerExistenceController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        if(req.getParameter("cantidadUnidad")!=null){
            String cantidadUnidad=req.getParameter("cantidadUnidad");
            int CantUnidEntParsed=Integer.parseInt(cantidadUnidad);
            ExistVo.setCantidadUnidad(CantUnidEntParsed);
        }
        if(req.getParameter("precioEntrada")!=null){
            String precioEntrada=req.getParameter("precioEntrada");
            Float precioEntParsed=Float.parseFloat(precioEntrada);
            ExistVo.setPrecioEntrada(precioEntParsed);
        }
        if(req.getParameter("idProducto")!=null){
            String idProducto=req.getParameter("idProducto");
            int idProdParsed=Integer.parseInt(idProducto);
            ExistVo.setIdProducto(idProdParsed);
        }
        if(req.getParameter("idEntradaProd")!=null){
            String idEntradaProd=req.getParameter("idEntradaProd");
            int idEntProdParsed=Integer.parseInt(idEntradaProd);
            ExistVo.setIdEntradaProd(idEntProdParsed);
        }
        else{
            System.out.println("Ha habido un error al tratar de registrar los datos de la existencia en el metodo registerExistenceController");
        }
        try {
            ExistDao.registerExistence(ExistVo);
            System.out.println("Registro insertado correctamente en controllerInLine");
            //mensaje
            req.setAttribute("mensaje1", "Existencia Registrada");
            //Redireccionamiento
            req.getRequestDispatcher("FormsExistence/indexExistence.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error al registrar los datos del usaurio en ControllerInline en el metodo registerExistenceController");
        }
    }

    //ACTUALIZAR EXISTENCIA
    private void updateExistenceController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        if(req.getParameter("idExistencia")!=null){
            String idExistencia=req.getParameter("idExistencia");
            int idProdParse=Integer.parseInt(idExistencia);
            ExistVo.setIdExistencia(idProdParse);
        }
        if(req.getParameter("UpdateCantidadUnidad")!=null){
            String UpdateCantidadUnidad=req.getParameter("UpdateCantidadUnidad");
            int UpdateCantidadUnidadParsed=Integer.parseInt(UpdateCantidadUnidad);
            ExistVo.setCantidadUnidad(UpdateCantidadUnidadParsed);
        }
        if(req.getParameter("UpdatePrecioEntrada")!=null){
            String UpdatePrecioEntrada=req.getParameter("UpdatePrecioEntrada");
            Float UpdatePrecioEntradaParsed=Float.parseFloat(UpdatePrecioEntrada);
            ExistVo.setPrecioEntrada(UpdatePrecioEntradaParsed);
        }
        if(req.getParameter("UpdateIdProducto")!=null){
            String UpdateIdProducto=req.getParameter("UpdateIdProducto");
            int UpdateIdProductoParsed=Integer.parseInt(UpdateIdProducto);
            ExistVo.setIdProducto(UpdateIdProductoParsed);
        }
        if(req.getParameter("UpdateIdEntradaProd")!=null){
            String UpdateIdEntradaProd=req.getParameter("UpdateIdEntradaProd");
            int UpdateIdEntradaProdParsed=Integer.parseInt(UpdateIdEntradaProd);
            ExistVo.setIdEntradaProd(UpdateIdEntradaProdParsed);
        }
            
            try {
                ExistDao.updateExistence(ExistVo);
                System.out.println("Existencia actualizada correctamente");
                //mensaje
            req.setAttribute("mensaje1", "Existencia Actualizada");
                //NOTA: Redireccionamiento preventivo.       
                req.getRequestDispatcher("FormsExistence/indexExistence.jsp").forward(req, resp);

            } catch (Exception e) {
                System.out.println("Error en la actualizacion de la existencia "+e.getMessage().toString());
            }
        }

    //ELIMINAR EXISTENCIA
    private void listExistDelete(HttpServletRequest req, HttpServletResponse resp) {
            try {
                List<ExistenciaVo> existencia = ExistDao.listarExist();
                req.setAttribute("Existencia", existencia);
                //mensaje
                req.setAttribute("mensaje1", "Existencia Eliminada");
                req.getRequestDispatcher("FormsExistence/indexExistence.jsp").forward(req, resp);
                System.out.println("Datos listados correctamente despues de la existencia eliminada");
            } catch (Exception e) {
                System.out.println("Hay problemas al listar los datos en el metodo " + e.getMessage().toString());
            }
        }

}

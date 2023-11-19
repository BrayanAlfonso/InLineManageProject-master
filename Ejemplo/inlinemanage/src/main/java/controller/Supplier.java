package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProveedorDao;
import model.ProveedorVo;

public class Supplier extends HttpServlet{
    
    ProveedorDao ProvDao=new ProveedorDao();
    ProveedorVo ProvVo=new ProveedorVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            case "supplier":
                req.getRequestDispatcher("FormsSupplier/indexSupplier.jsp").forward(req, resp);
            break;
            case "registerSupplier":
                req.getRequestDispatcher("FormsSupplier/registerSupplier.jsp").forward(req, resp);
            break;
            
            //Actualizar el proveedor
            case "updateSupplier":
            // Obtener el user_id del usuario seleccionado desde la URL
            String provIdStr = req.getParameter("idProveedor");
            int provId = Integer.parseInt(provIdStr);

            try {
                // Obtener el usuario por su id y enviarlo al formulario de actualización
                ProveedorVo proveedor = new ProveedorDao().obtenerProveedorPorId(provId);

                if (proveedor != null) {
                    req.setAttribute("Proveedor", proveedor);
                    req.getRequestDispatcher("FormsSupplier/updateSupplier.jsp").forward(req, resp);
                } else {
                    // Si no se encuentra el proveedor, redirigir a la página de listado con un mensaje de error
                    List<ProveedorVo> proveedores = new ProveedorDao().listarProv();
                    req.setAttribute("Proveedores", proveedores);
                    req.setAttribute("mensaje", "El proveedor seleccionado no existe.");
                    req.getRequestDispatcher("FormsSupplier/indexSupplier.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el proveedor");
            }
            break;

            // Eliminar el Proveedor
        case "deleteSupplier":
        String provIdStrDelete = req.getParameter("idProveedor");
        int ProvIdDelete = Integer.parseInt(provIdStrDelete);
        System.out.println(ProvIdDelete);

        try {
            new ProveedorDao().deleteSupplier(ProvIdDelete);
            System.out.println("Proveedor eliminado correctamente");
            listProvDelete(req, resp); // Asegúrate de llamar al método listProvDelete para actualizar la lista de proveedores.
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el proveedor");
        }
        break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            //Proveedores
            case"registerSupplier":
                System.out.println("Se entro al caso 'registerExistence, en el metodo registerExistence()'");
                registerSupplierController(req, resp);
            break;

            case"updateSupplier":
                System.out.println("Se entro al caso 'updateExistence, en el metodo updateExistence()'");
                updateSupplierController(req, resp);
            break;
        }
    }

    
    //CRUD PROVEEDORES

//REGISTRAR PROVEEDOR
private void registerSupplierController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    if(req.getParameter("nombreProveedor")!=null){
        ProvVo.setNombreProveedor(req.getParameter("nombreProveedor"));
    }
    if(req.getParameter("direccionProveedor")!=null){
        ProvVo.setDireccionProveedor(req.getParameter("direccionProveedor"));
    }
    else{
        System.out.println("Ha habido un error al tratar de registrar los datos del proveedor en el metodo registerSupplierController");
    }
    try {
        ProvDao.registerSupplier(ProvVo);
        System.out.println("Registro insertado correctamente en controllerInLine");
        //Redireccionamiento
        req.getRequestDispatcher("FormsSupplier/registerSupplier.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Error al registrar los datos del proveedor en ControllerInline en el metodo registerSupplierController");
    }
}

//ACTUALIZAR PROVEEDOR
private void updateSupplierController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    if(req.getParameter("idProveedor")!=null){
        String idProveedor=req.getParameter("idProveedor");
        int idProvParse=Integer.parseInt(idProveedor);
        ProvVo.setIdProveedor(idProvParse);
    }
    if(req.getParameter("UpdateNameSupplier")!=null){
        ProvVo.setNombreProveedor(req.getParameter("UpdateNameSupplier"));
    }
    if(req.getParameter("UpdateAdressSupplier")!=null){
        ProvVo.setDireccionProveedor(req.getParameter("UpdateAdressSupplier"));
    }
        
        try {
            ProvDao.updateSupplier(ProvVo);
            System.out.println("Proveedor actualizado correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("FormsSupplier/indexSupplier.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del proveedor "+e.getMessage().toString());
        }
    }

//ELIMINAR PROVEEDOR
private void listProvDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<ProveedorVo> proveedor = ProvDao.listarProv();
            req.setAttribute("Proveedor", proveedor);
            req.getRequestDispatcher("FormsSupplier/indexSupplier.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente despues del proveedor eliminado");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos en el metodo " + e.getMessage().toString());
        }
    }



}



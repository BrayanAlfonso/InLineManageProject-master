package controller;
import model.EntradaDao;
import model.EntradaVo;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntradaProd extends HttpServlet {
    EntradaDao  EntraDao=new EntradaDao();
    EntradaVo EntraVo = new EntradaVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            case "entrada":
                req.getRequestDispatcher("FormsEntradaProd/indexEntradaProd.jsp").forward(req, resp);
            break;

            case "registerEntrada":
                req.getRequestDispatcher("FormsEntradaProd/registerEntradaProd.jsp").forward(req, resp);
            break;
            //Actualizar entrada de producto

            case "updateEntrada":
            // Obtener el user_id del usuario seleccionado desde la URL
            String entradaProd = req.getParameter("idEntradaProd");
            int idEntrada = Integer.parseInt(entradaProd);

            try {
                // Obtener el usuario por su id y enviarlo al formulario de actualización
                EntradaVo entrada = new EntradaDao().obtenerEntradaPorId(idEntrada);

                if (entrada != null) {
                    req.setAttribute("Entrada", entrada);
                    req.getRequestDispatcher("FormsEntradaProd/updateEntradaProd.jsp").forward(req, resp);
                } else {
                    // Si no se encuentra el proveedor, redirigir a la página de listado con un mensaje de error
                    List<EntradaVo> entradas = new EntradaDao().listar();
                    req.setAttribute("Proveedores", entradas);
                    req.setAttribute("mensaje", "El proveedor seleccionado no existe.");
                    req.getRequestDispatcher("FormsEntradaProd/indexEntradaProd.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el proveedor");
            }
            break;

            //Eliminar una entrada de producto
            case "deleteEntrada":
            String EntradaIdStrDelete = req.getParameter("idEntradaProd");
                int EntradaIdDelete = Integer.parseInt(EntradaIdStrDelete);
                System.out.println(EntradaIdDelete);

                try {
                    new EntradaDao().deleteEntrada(EntradaIdDelete);
                    System.out.println("entrada de producto eliminado correctamente");
                    listEntradaDelete(req, resp);
                    
                } catch (Exception e) {
                    // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
                    e.printStackTrace();
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el proveedor");
                }
            break;
        }

        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar=req.getParameter("enviar");
        switch (enviar) {
            //Entradas
            case"registerEntrada":
                System.out.println("Se entro al caso 'registerEntrada, en el metodo registerEntrada()'");
                registerEntradaController(req, resp);
            break;

            case"updateEntrada":
                System.out.println("Se entro al caso 'updateEntrada, en el metodo updateEntrada()'");
                updateEntradaController(req, resp);
            break;
        }
    }

    
//CRUD Entrada
//REGISTRAR Entrada

private void registerEntradaController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    if(req.getParameter("fechaIngreso")!=null) {
         String fechaString = req.getParameter("fechaIngreso");
        LocalDate fecha = LocalDate.parse(fechaString);
        EntraVo.setFechaIngreso(Date.valueOf(fecha));
    }
    if(req.getParameter("idProveedor")!=null){
        String poveedor=req.getParameter("idProveedor");
        int ProvedorParsed=Integer.parseInt(poveedor);
        EntraVo.setIdProveedor(ProvedorParsed);
    }
    else{
        System.out.println("Ha habido un error al tratar de registrar los datos de la entrada en el metodo registerEntradaController");
    }
    try {
        EntraDao.registerEntrada(EntraVo);
        System.out.println("Registro insertado correctamente en controllerInLine");
        //Redireccionamiento
        req.getRequestDispatcher("FormsEntradaProd/registerEntradaProd.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Error al registrar los datos del usaurio en ControllerInline en el metodo registerEntradaController");
    }
}

    //Actualizar entrada
private void updateEntradaController(HttpServletRequest req, HttpServletResponse resp) {

    if(req.getParameter("idEntradaProd")!=null){
            String idEntradaStr=req.getParameter("idEntradaProd");
            int idEntrada=Integer.parseInt(idEntradaStr);
            EntraVo.setIdEntradaProd(idEntrada);
    }
    if(req.getParameter("UpdateFecha")!=null){
        String fechaString = req.getParameter("UpdateFecha");
        LocalDate fecha = LocalDate.parse(fechaString);
        EntraVo.setFechaIngreso(Date.valueOf(fecha));
    }
    if(req.getParameter("UpdateIdProveedor")!=null){
        String poveedor=req.getParameter("UpdateIdProveedor");
        int ProvedorParsed=Integer.parseInt(poveedor);
        EntraVo.setIdProveedor(ProvedorParsed);
    }
        
        try {
            EntraDao.actualizar(EntraVo);
            System.out.println("entrada actualizada correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("FormsEntradaProd/indexEntradaProd.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del producto "+e.getMessage().toString());
        }
    }
    
    
private void listEntradaDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<EntradaVo> entrada = EntraDao.listar();
            req.setAttribute("entrada",  entrada);
            req.getRequestDispatcher("FormsEntradaProd/indexEntradaProd.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente despues de entrada eliminado");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos en el metodo " + e.getMessage().toString());
        }
    }
    
    
}

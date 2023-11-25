package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoriaDao;
import model.CategoriaVo;

public class Category extends HttpServlet{

    CategoriaDao CateDao=new CategoriaDao();
    CategoriaVo CateVo=new CategoriaVo();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");

        switch (enviar) {
            case "categoria":
            req.getRequestDispatcher("FormsCategory/indexCategoria.jsp").forward(req, resp);
            break;
    
            case "registerCategory":
            req.getRequestDispatcher("FormsCategory/registerCategory.jsp").forward(req, resp);
            break;

                            //Actualizar categoria
        case "updateCategory":
         // Obtener el user_id del usuario seleccionado desde la URL
        String CategoryId = req.getParameter("idCategoria");
        int categoryId = Integer.parseInt(CategoryId);
 
        try {
             // Obtener el usuario por su id y enviarlo al formulario de actualización
            CategoriaVo categoria = new CategoriaDao().obtenerCategorytPorId(categoryId);
 
            if (categoria != null) {
                req.setAttribute("Categoria", categoria);
                req.getRequestDispatcher("FormsCategory/updateCategory.jsp").forward(req, resp);
            } else {
                 // Si no se encuentra el usuario, redirigir a la página de listado con un mensaje de error
                List<CategoriaVo> categorias = new CategoriaDao().listar();
                req.setAttribute("Categoria", categorias);
                req.setAttribute("mensaje", "El producto seleccionado no existe.");
                req.getRequestDispatcher("FormsCategory/indexCategoria.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
             // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el usuario");
        }
        break;

         //Eliminar el producto
        case "deleteCategory":
        String CateIdStrDelete = req.getParameter("idCategoria");
            int CateIdDelete = Integer.parseInt(CateIdStrDelete);

            try {
                new CategoriaDao().eliminar(CateIdDelete);
                System.out.println("Categoria eliminado correctamente");
                listCateDelete(req, resp);
            
            } catch (Exception e) {
                 // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el producto");
            }
        break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            case"registerCategory":
            System.out.println("Acabas de entrar al caso 'registerCate, en el metodo registerCate()'");
            registerCategoryController(req, resp);
            break;
    
            case"updateCategory":
            System.out.println("Se entro al caso de updateCategory");
            updateCategoryController(req, resp);
            break;
        }
    }

 //registro de categoria   
private void registerCategoryController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    if(req.getParameter("nameCategory")!=null){
        CateVo.setNombreCategoria(req.getParameter("nameCategory"));
    }
    else{
        System.out.println("Ha habido un error al tratar de registrar los datos de la categoria en el metodo registerUserController");
    }
    try {
        CateDao.registerCategory(CateVo);
        System.out.println("Registro insertado correctamente en controllerInLine");
        //Redireccionamiento
         req.setAttribute("mensaje1", "Categoria Registrada");
        req.getRequestDispatcher("FormsCategory/indexCategoria.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Error al registrar los datos del usaurio en ControllerInline en el metodo registerUserController");
    }
}

    //Actualizar Categoria
private void updateCategoryController(HttpServletRequest req, HttpServletResponse resp) {

    if(req.getParameter("idCategoria")!=null){
            String idCateStr=req.getParameter("idCategoria");
            int idCategoria=Integer.parseInt(idCateStr);
            CateVo.setIdCategoria(idCategoria);
    }
    if(req.getParameter("UpdateNameCategory")!=null){
    CateVo.setNombreCategoria(req.getParameter("UpdateNameCategory"));
    }
        
        try {
            CateDao.actualizar(CateVo);
            System.out.println("Categoria actualizado correctamente");

            //NOTA: Redireccionamiento preventivo.
            req.setAttribute("mensaje1", "Categoria Actualizada");      
            req.getRequestDispatcher("FormsCategory/indexCategoria.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del producto "+e.getMessage().toString());
        }
    }
    
    
private void listCateDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<CategoriaVo> categoria = CateDao.listar();
            req.setAttribute("Categoria", categoria);
            req.setAttribute("mensaje1", "Categoria Eliminada");
            req.getRequestDispatcher("FormsCategory/indexCategoria.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente despues del categoria eliminado");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos en el metodo " + e.getMessage().toString());
        }
    }


}

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.ProductoDao;
import model.ProductoVo;
import model.UsuarioDao;
import model.UsuarioVo;


public class JavaWeb extends HttpServlet{

    UsuarioVo r=new UsuarioVo(); 
    UsuarioDao rd=new UsuarioDao();

    ProductoVo p=new ProductoVo();
    ProductoDao pd=new ProductoDao();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String enviar = req.getParameter("enviar");
        
    switch (enviar) {
        case "index":
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            break;
        case "register":
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            break;
        case "update":
            try {
                // Obtener la lista de usuarios y enviarla a edit.jsp
                List<UsuarioVo> usuarios = rd.listar();
                req.setAttribute("usuarios", usuarios);
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
            } catch (SQLException e) {
                // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener los usuarios");
            }
            break;

            case "updateUser":
            // Obtener el user_id del usuario seleccionado desde la URL
            String userIdStr = req.getParameter("user_id");
            int userId = Integer.parseInt(userIdStr);

            try {
                // Obtener el usuario por su id y enviarlo al formulario de actualización
                UsuarioVo usuario = new UsuarioDao().obtenerUsuarioPorId(userId);

                if (usuario != null) {
                    req.setAttribute("usuario", usuario);
                    req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
                } else {
                    // Si no se encuentra el usuario, redirigir a la página de listado con un mensaje de error
                    List<UsuarioVo> usuarios = new UsuarioDao().listar();
                    req.setAttribute("usuarios", usuarios);
                    req.setAttribute("mensaje", "El usuario seleccionado no existe.");
                    req.getRequestDispatcher("edit.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el usuario");
            }
            break;

            case "deleteUser":
            String userIdStrDelete = req.getParameter("user_id");
            int userIdToDelete = Integer.parseInt(userIdStrDelete);

            try {
                new UsuarioDao().eliminar(userIdToDelete);
                System.out.println("Usuario eliminado correctamente");
                // Redirige nuevamente a la página de listado de usuarios después de eliminar
                listar(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el usuario");
            }
            break;


            case "registerProduct":
                req.getRequestDispatcher("registerProduct.jsp").forward(req, resp);
            break;

    }
}

    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String enviar=req.getParameter("enviar");
        switch(enviar){
            case "register":
                System.out.println("Acabas de entrar al caso 'add'");
                add(req,resp);
            break;

            case "updateUser": 
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
            break;

            case "login":
                System.out.println("Acabas de entrar al caso 'login'");
                iniciar(req, resp);
            break;

            case "user":
            listar(req, resp);
            break;

            case "registerProduct":
                addProduct(req, resp);
                System.out.println("Acabas de entrar al caso 'registrar producto'");
            break;
        }
    }

    //SECCION: METODOS

    //SECCION: ADD - REGISTER
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("user_name")!=null){
            r.setUserFirstName( req.getParameter("user_name")); 
        }
        if(req.getParameter("user_last_name")!=null){
            r.setUserLastName( req.getParameter("user_last_name")); 
        }
        if(req.getParameter("user_email")!=null){
            r.setUserEmail(req.getParameter("user_email")); 
        }
        if(req.getParameter("user_password")!=null){
            r.setUserPassword(req.getParameter("user_password")); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("register.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }


    
    //SECCION: ADD - REGISTER
    private void addProduct(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("name_product")!=null){
            p.setName_product( req.getParameter("name_product")); 
        }
        if(req.getParameter("value_product")!=null){
            String valueProductStr = req.getParameter("value_product");
            float valueProductFloat = Float.parseFloat(valueProductStr);
            p.setValue_product(valueProductFloat);
        }
        if(req.getParameter("id_category")!=null){
            String idCategoryStr = req.getParameter("id_category");
            int idCategoryInt = Integer.parseInt(idCategoryStr);
            p.setId_category(idCategoryInt);
        }   
        else{
            System.out.println("Error al registrar datos de producto");
        }
        try {
            pd.registrarProducto(p);
            System.out.println("Registro insertado correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("registerProduct.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //SECCION: UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("user_id")!=null){
            r.setUserId (Integer.parseInt(req.getParameter("user_id"))); 
        }
        if(req.getParameter("updateUserName")!=null){
            r.setUserFirstName(req.getParameter("updateUserName")); 
        }
        if(req.getParameter("updateUserLastName")!=null){
            r.setUserLastName(req.getParameter("updateUserLastName")); 
        }
        if(req.getParameter("updateUserEmail")!=null){
            r.setUserEmail(req.getParameter("updateUserEmail")); 
        }
        if(req.getParameter("updateUserPassword")!=null){
            r.setUserPassword(req.getParameter("updateUserPassword")); 
        }
        
        try {
            rd.actualizar(r);
            System.out.println("Registro actualizado correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("edit.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    public void iniciar(HttpServletRequest req, HttpServletResponse resp) {
    System.out.println("Esta actualmente en el login");
        //obtener parametros
        String nombre = req.getParameter("user_name");
        String contrasena = req.getParameter("user_password");
        
        if(nombre.equals("admin") && contrasena.equals("admin")){
            try{
                r = rd.obtenerUsuario(nombre,contrasena);
            if(r!=null){
                HttpSession iniciar = req.getSession();
                iniciar.setAttribute("user_name",r);
                listar(req, resp);
            }else{
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }

        }catch(Exception e) {

            System.out.println("Error en la modificacion"+e.getMessage().toString());

        }
        }else{
            try{
                r = rd.obtenerUsuario(nombre, contrasena);
            if(r!=null){
                HttpSession iniciar = req.getSession();
                iniciar.setAttribute("Usuario",r);
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
            }catch(Exception e) {
                System.out.println("Error en la modificacion"+e.getMessage().toString());

            }
        }
    }

private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<UsuarioVo> usuario = rd.listar();
        req.setAttribute("usuarios", usuario);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
}

}


    


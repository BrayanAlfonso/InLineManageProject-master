package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioDao;
import model.UsuarioVo;

public class User extends HttpServlet{
    UsuarioVo UsuVo= new UsuarioVo();
    UsuarioDao UsuDao=new UsuarioDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            case "user":
                req.getRequestDispatcher("FormsUser/indexUser.jsp").forward(req, resp);
            break;
        

        case "registerUser":
            req.getRequestDispatcher("FormsUser/registerUser.jsp").forward(req, resp);
        break;



        case "updateUser":
        // Obtener el user_id del usuario seleccionado desde la URL
        String userIdStr = req.getParameter("idUsuario");
        int userId = Integer.parseInt(userIdStr);

        try {
            // Obtener el usuario por su id y enviarlo al formulario de actualización
            UsuarioVo usuario = new UsuarioDao().obtenerUsuarioPorId(userId);

            if (usuario != null) {
                req.setAttribute("usuario", usuario);
                req.getRequestDispatcher("FormsUser/updateUser.jsp").forward(req, resp);
            } else {
                // Si no se encuentra el usuario, redirigir a la página de listado con un mensaje de error
                List<UsuarioVo> usuarios = new UsuarioDao().listar();
                req.setAttribute("usuarios", usuarios);
                req.setAttribute("mensaje", "El usuario seleccionado no existe.");
                req.getRequestDispatcher("FormsUser/indexUser.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el usuario");
        }
        break;


        case "deleteUser":
            // Obtener el user_id del usuario seleccionado desde la URL
            String userIdStrDelete = req.getParameter("idUsuario");
            int userIdDelete = Integer.parseInt(userIdStrDelete);

            try {
                new UsuarioDao().deleteUser(userIdDelete);
                System.out.println("Usuario eliminado correctamente");
                listAfterDelete(req, resp);
                
            } catch (Exception e) {
                // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el usuario");

            }
        break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            case "registerUser":
                System.out.println("Acabas de entrar al caso 'registerUser, en el metodo registerUser()'");
                registerUserController(req, resp);
            break;

            case "updateUser":
                System.out.println("Se entro al caso de updateUser");
                updateUserController(req,resp);
            break;
        }
    }

    
private void registerUserController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    if(req.getParameter("documentType")!=null){
        UsuVo.setTipoDoc(req.getParameter("documentType"));
    }
    if(req.getParameter("noDocument")!=null){
        String noDocument=req.getParameter("noDocument");
        Integer noDocumentParsed=Integer.parseInt(noDocument);
        UsuVo.setNumeroDoc(noDocumentParsed);
    }
    if(req.getParameter("name")!=null){
        UsuVo.setNombre(req.getParameter("name"));
    }
    if(req.getParameter("lastName")!=null){
        UsuVo.setApellido(req.getParameter("lastName"));
    }
    if(req.getParameter("email")!=null){
        UsuVo.setCorreo(req.getParameter("email"));
    }
    if(req.getParameter("password")!=null){
        UsuVo.setContraseña(req.getParameter("password"));
    }
    if(req.getParameter("rol")!=null){
        String rol=req.getParameter("rol");
        Integer rolParsedInteger=Integer.parseInt(rol);
        UsuVo.setIdRol(rolParsedInteger);
    }
    else{
        System.out.println("Ha habido un error al tratar de registrar los datos del usuario en el metodo registerUserController");
    }
    try {
        UsuDao.registerUserDao(UsuVo);
        System.out.println("Registro insertado correctamente en controllerInLine");

        //Redireccionamiento
        req.getRequestDispatcher("FormsUser/indexUser.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Error al registrar los datos del usaurio en ControllerInline en el metodo registerUserController");
    }
    
}

    //Actualizar usuario
    private void updateUserController(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("idUsuario")!=null){
            String idUsuarioStr=req.getParameter("idUsuario");
            int idUsuario=Integer.parseInt(idUsuarioStr);
            UsuVo.setIdUsuario(idUsuario);
        }
        if(req.getParameter("UpdateDocumentType")!=null){
            UsuVo.setTipoDoc(req.getParameter("UpdateDocumentType"));
        }
        if(req.getParameter("UpdateNoDocument")!=null){
            String noDocument=req.getParameter("UpdateNoDocument");
            Integer noDocumentParsed=Integer.parseInt(noDocument);
            UsuVo.setNumeroDoc(noDocumentParsed);
        }
        if(req.getParameter("UpdateName")!=null){
            UsuVo.setNombre(req.getParameter("UpdateName"));
        }
        if(req.getParameter("UpdateLastName")!=null){
            UsuVo.setApellido(req.getParameter("UpdateLastName"));
        }
        if(req.getParameter("UpdateEmail")!=null){
            UsuVo.setCorreo(req.getParameter("UpdateEmail"));
        }
        if(req.getParameter("UpdatePassword")!=null){
            UsuVo.setContraseña(req.getParameter("UpdatePassword"));
        }
        if(req.getParameter("UpdateRol")!=null){
            String rol=req.getParameter("UpdateRol");
            Integer rolParsedInteger=Integer.parseInt(rol);
            UsuVo.setIdRol(rolParsedInteger);
        }
        
        try {
            UsuDao.updateUserDao(UsuVo);
            System.out.println("Usuario actualizado correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("FormsUser/indexUser.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del usuario "+e.getMessage().toString());
        }
    }


    //!METODO UNICA Y EXCLUSIVAMENTE PARA REDIRECCION AL MOMENTO DE ELIMINAR UN USUARIO
    private void listAfterDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<UsuarioVo> usuario = UsuDao.listar();
            req.setAttribute("usuarios", usuario);
            req.getRequestDispatcher("FormsUser/indexUser.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente despues del usuario eliminado");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos en el metodo " + e.getMessage().toString());
        }
    }
}

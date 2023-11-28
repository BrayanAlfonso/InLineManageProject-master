import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.UsuarioDao;
import model.UsuarioVo;





public class ControllerInline extends HttpServlet{

    UsuarioVo UsuVo= new UsuarioVo();
    UsuarioDao UsuDao=new UsuarioDao();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String enviar = req.getParameter("enviar");
        
    switch (enviar) {

        case "index":

            req.setAttribute("mensaje", "Inicia sesión");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        break;

        case "main":
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        break;

        case "closeSession":
            System.out.println("Entro al caso closeSession");
            HttpSession session = req.getSession();
            session.removeAttribute("idUsuario");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        break;

    }
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Se entro al metodo DoPost");
    String enviar=req.getParameter("enviar");
    switch(enviar){

        case"index":
        System.out.println("Se entro en el caso index para validar login");
        loginUserController(req, resp);
        break;


}

}

//Validacion y metodo para login
private void loginUserController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = req.getParameter("inputUserName");
    String password = req.getParameter("inputPassword");
    Integer rol = Integer.parseInt(req.getParameter("inputRol"));

    if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty() && rol != null) {
        try {
            if (UsuDao.validarLogin(userName, password, rol) && rol==1) {
                System.out.println("La validación ha sido exitosa!");

                // Obtener el idUsuario y guardarlo en la sesión
                int idUsuario = UsuDao.obtenerIdUsuarioPorDatos(userName, password, rol);
                HttpSession session2 = req.getSession();
                session2.setAttribute("idUsuario", idUsuario);

                req.getRequestDispatcher("main.jsp").forward(req, resp);

            } else if(UsuDao.validarLogin(userName, password, rol) && rol==2){
                // Obtener el idUsuario y guardarlo en la sesión
                int idUsuario = UsuDao.obtenerIdUsuarioPorDatos(userName, password, rol);
                HttpSession session2 = req.getSession();
                session2.setAttribute("idUsuario", idUsuario);

                req.getRequestDispatcher("FormsVentEmployee/indexVentEp.jsp").forward(req, resp);
            }else {
                System.out.println("Usuario y/o contraseña no encontrados");
                req.setAttribute("mensaje", "Usuario y/o contraseña no encontrados:(");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al intentar iniciar sesión");
        }
    } else {
        req.setAttribute("mensaje", "Usuario y/o contraseña no encontrados:(");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
}




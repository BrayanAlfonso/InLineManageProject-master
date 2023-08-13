import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.ExistenciaDao;
import model.ExistenciaVo;
import model.ProductoDao;
import model.ProductoVo;
import model.UsuarioDao;
import model.UsuarioVo;




public class ControllerInline extends HttpServlet{

    UsuarioVo UsuVo= new UsuarioVo();
    UsuarioDao UsuDao=new UsuarioDao();
    ProductoVo ProdVo=new ProductoVo();
    ProductoDao ProdDao=new ProductoDao();
    ExistenciaDao ExistDao=new ExistenciaDao();
    ExistenciaVo ExistVo=new ExistenciaVo();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String enviar = req.getParameter("enviar");
        
    switch (enviar) {

        case "index":
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        break;
        case "user":
            req.getRequestDispatcher("FormsUser/indexUser.jsp").forward(req, resp);
            break;

        case "product":
            req.getRequestDispatcher("FormsProduct/indexProduct.jsp").forward(req, resp);
        break;

        case "existence":
            req.getRequestDispatcher("FormsExistence/indexExistence.jsp").forward(req, resp);
        break;
    
        case "registerExistence":
            req.getRequestDispatcher("FormsExistence/registerExistence.jsp").forward(req, resp);
        break;

        case "registerProduct":
            req.getRequestDispatcher("FormsProduct/registerProduct.jsp").forward(req, resp);
        break;

        case "supplier":
            req.getRequestDispatcher("FormsSupplier/indexSupplier.jsp").forward(req, resp);
        break;

        case "vent":
            req.getRequestDispatcher("FormsVent/indexVent.jsp").forward(req, resp);
        break;

        case "main":
            req.getRequestDispatcher("main.jsp").forward(req, resp);
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

        //Actualizar Producto
        case "updateProduct":
        // Obtener el user_id del usuario seleccionado desde la URL
        String ProductId = req.getParameter("idProducto");
        int prodId = Integer.parseInt(ProductId);

        try {
            // Obtener el usuario por su id y enviarlo al formulario de actualización
            ProductoVo producto = new ProductoDao().obtenerProductPorId(prodId);

            if (producto != null) {
                req.setAttribute("producto", producto);
                req.getRequestDispatcher("FormsProduct/updateProduct.jsp").forward(req, resp);
            } else {
                // Si no se encuentra el usuario, redirigir a la página de listado con un mensaje de error
                List<ProductoVo> productos = new ProductoDao().listar();
                req.setAttribute("Producto", productos);
                req.setAttribute("mensaje", "El producto seleccionado no existe.");
                req.getRequestDispatcher("FormsProduct/indexProduct.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            // Manejar la excepción SQLException aquí o propagarla hacia arriba según corresponda
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el producto");
        }
        break;

        //Eliminar el producto
        case "deleteProduct":
        String ProdIdStrDelete = req.getParameter("idProducto");
            int ProdIdDelete = Integer.parseInt(ProdIdStrDelete);

            try {
                new ProductoDao().eliminar(ProdIdDelete);
                System.out.println("Producto eliminado correctamente");
                listProdDelete(req, resp);
                
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
    System.out.println("Se entro al metodo DoPost");
    String enviar=req.getParameter("enviar");
    switch(enviar){
        case "registerUser":
            System.out.println("Acabas de entrar al caso 'registerUser, en el metodo registerUser()'");
            registerUserController(req, resp);
        break;

        case "updateUser":
            System.out.println("Se entro al caso de updateUser");
            updateUserController(req,resp);
        break;

        case"index":
        System.out.println("Se entro en el caso index para validar login");
        loginUserController(req, resp);
        break;

        case"registerProduct":
        System.out.println("Acabas de entrar al caso 'registerProduct, en el metodo registerProduct()'");
        registerProductController(req,resp);
        break;

        case "updateProduct":
        System.out.println("Se entro al caso de updateProduct");
        updateProdController(req, resp);
        break;


}

}

//Validacion y metodo para login
private void loginUserController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    String userName=req.getParameter("inputUserName");
    String password=req.getParameter("inputPassword");
    
    if(userName != null && !userName.isEmpty() && password != null && !password.isEmpty()){
        try {


            if (UsuDao.validarLogin(userName, password)) {
                System.out.println("La validación ha sido exitosa!");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            } else {
                req.setAttribute("mensaje", "Usuario o contraseña incorrectos.");
                System.out.println("Usuario y contraseña no encontrados!");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al intentar iniciar sesión");
        }
    }else {
        req.setAttribute("mensaje", "Por favor, ingrese un nombre de usuario y contraseña válidos.");
        System.out.println("No has ingresado ningun dato");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
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


    //PRODUCTOS CRUD

//REGISTRAR PRODUCTOS
private void registerProductController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    if(req.getParameter("numSerial")!=null){
        String numSerial=req.getParameter("numSerial");
        int numSeSerialParsed=Integer.parseInt(numSerial);
        ProdVo.setNumSerial(numSeSerialParsed);
    }
    if(req.getParameter("nameProduct")!=null){
        ProdVo.setNombreProducto(req.getParameter("nameProduct"));
    }
    if(req.getParameter("precioProd")!=null){
        String PrecioProd=req.getParameter("precioProd");
        int Precio=Integer.parseInt(PrecioProd);
        ProdVo.setPrecioProducto(Precio);
    }
    if(req.getParameter("descripcion")!=null){
        ProdVo.setDescripcion(req.getParameter("descripcion"));
    }
    if(req.getParameter("categoria")!=null){
        String categoria=req.getParameter("categoria");
        int Categoria=Integer.parseInt(categoria);
        ProdVo.setIdCategoria(Categoria);
    }
    if(req.getParameter("existencia")!=null){
        String existencia=req.getParameter("existencia");
        int Existencia=Integer.parseInt(existencia);
        ProdVo.setIdExistencia(Existencia);;
    }
    else{
        System.out.println("Ha habido un error al tratar de registrar los datos del producto en el metodo registerProductController");
    }
    try {
        ProdDao.registerProduct(ProdVo);
        System.out.println("Registro insertado correctamente en controllerInLine");
        //Redireccionamiento
        req.getRequestDispatcher("FormsProduct/registerProduct.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Error al registrar los datos del usaurio en ControllerInline en el metodo registerUserController");
    }
}

    //Actualizar Producto
private void updateProdController(HttpServletRequest req, HttpServletResponse resp) {

    if(req.getParameter("idProducto")!=null){
            String idProdStr=req.getParameter("idProducto");
            int idProd=Integer.parseInt(idProdStr);
            ProdVo.setIdProducto(idProd);
    }
    if(req.getParameter("UpdateNumSerial")!=null){
        String UpdateNumSerial=req.getParameter("UpdateNumSerial");
        int UpdateNumSerialParsed=Integer.parseInt(UpdateNumSerial);
        ProdVo.setPrecioProducto(UpdateNumSerialParsed);
    }
    if(req.getParameter("UpdateNameProduct")!=null){
        ProdVo.setNombreProducto(req.getParameter("UpdateNameProduct"));
    }
    if(req.getParameter("UpdatePrecioProd")!=null){
        String PrecioProd=req.getParameter("UpdatePrecioProd");
        int Precio=Integer.parseInt(PrecioProd);
        ProdVo.setPrecioProducto(Precio);
    }
    if(req.getParameter("UpdateDescripcion")!=null){
        ProdVo.setDescripcion(req.getParameter("UpdateDescripcion"));
    }
    if(req.getParameter("UpdateCategoria")!=null){
        String categoria=req.getParameter("UpdateCategoria");
        int Categoria=Integer.parseInt(categoria);
        ProdVo.setIdCategoria(Categoria);
    }
    if(req.getParameter("UpdateExistencia")!=null){
        String existencia=req.getParameter("UpdateExistencia");
        int Existencia=Integer.parseInt(existencia);
        ProdVo.setIdExistencia(Existencia);;
    }
        
        try {
            ProdDao.actualizar(ProdVo);
            System.out.println("Producto actualizado correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("FormsProduct/indexProduct.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del producto "+e.getMessage().toString());
        }
    }
    
    
private void listProdDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<ProductoVo> producto = ProdDao.listar();
            req.setAttribute("Producto", producto);
            req.getRequestDispatcher("FormsProduct/indexProduct.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente despues del producto eliminado");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos en el metodo " + e.getMessage().toString());
        }
    }

    
    //EXISTENCIAS CRUD

//REGISTRAR EXISTENCIA
private void registerExistenceController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    if(req.getParameter("numSerial")!=null){
        String numSerial=req.getParameter("numSerial");
        int numSeSerialParsed=Integer.parseInt(numSerial);
        ExistVo.setNumSerial(numSeSerialParsed);
    }
    if(req.getParameter("idCategoria")!=null){
        String idCategoria=req.getParameter("idCategoria");
        int idCategParsed=Integer.parseInt(idCategoria);
        ExistVo.setIdCategoria(idCategParsed);
    }

    if(req.getParameter("categoria")!=null){
        String categoria=req.getParameter("categoria");
        int Categoria=Integer.parseInt(categoria);
        ProdVo.setIdCategoria(Categoria);
    }
    if(req.getParameter("existencia")!=null){
        String existencia=req.getParameter("existencia");
        int Existencia=Integer.parseInt(existencia);
        ProdVo.setIdExistencia(Existencia);;
    }
    else{
        System.out.println("Ha habido un error al tratar de registrar los datos del producto en el metodo registerProductController");
    }
    try {
        ProdDao.registerProduct(ProdVo);
        System.out.println("Registro insertado correctamente en controllerInLine");
        //Redireccionamiento
        req.getRequestDispatcher("FormsProduct/registerProduct.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Error al registrar los datos del usaurio en ControllerInline en el metodo registerUserController");
    }
}
}
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;


import model.ExistenciaDao;
import model.ExistenciaVo;
import model.ProductoDao;
import model.ProductoVo;
import model.ProveedorDao;
import model.ProveedorVo;
import model.UsuarioDao;
import model.UsuarioVo;
import model.CategoriaDao;
import model.CategoriaVo;
import model.EntradaDao;
import model.EntradaVo;
import model.VentaDao;
import model.VentaVo;





public class ControllerInline extends HttpServlet{

    UsuarioVo UsuVo= new UsuarioVo();
    UsuarioDao UsuDao=new UsuarioDao();
    ProductoVo ProdVo=new ProductoVo();
    ProductoDao ProdDao=new ProductoDao();
    ExistenciaDao ExistDao=new ExistenciaDao();
    ExistenciaVo ExistVo=new ExistenciaVo();
    ProveedorDao ProvDao=new ProveedorDao();
    ProveedorVo ProvVo=new ProveedorVo();
    CategoriaDao CateDao=new CategoriaDao();
    CategoriaVo CateVo=new CategoriaVo();
    EntradaDao  EntraDao=new EntradaDao();
    EntradaVo EntraVo = new EntradaVo();
    VentaVo VentVo=new VentaVo();
    VentaDao VentDao=new VentaDao();
    

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

        case "registerSupplier":
            req.getRequestDispatcher("FormsSupplier/registerSupplier.jsp").forward(req, resp);
        break;

        case "vent":
            req.getRequestDispatcher("FormsVent/indexVent.jsp").forward(req, resp);
        break;

        case "registerVent":
            req.getRequestDispatcher("FormsVent/registerVent.jsp").forward(req, resp);
        break;

        case "main":
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        break;

        case "categoria":
        req.getRequestDispatcher("FormsCategory/indexCategoria.jsp").forward(req, resp);
        break;

        case "registerCategory":
        req.getRequestDispatcher("FormsCategory/registerCategory.jsp").forward(req, resp);
        break;

        case "registerUser":
            req.getRequestDispatcher("FormsUser/registerUser.jsp").forward(req, resp);
        break;

        case "entrada":
            req.getRequestDispatcher("FormsEntradaProd/indexEntradaProd.jsp").forward(req, resp);
        break;

        case "registerEntrada":
            req.getRequestDispatcher("FormsEntradaProd/registerEntradaProd.jsp").forward(req, resp);
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

        
        case"registerCategory":
        System.out.println("Acabas de entrar al caso 'registerCate, en el metodo registerCate()'");
        registerCategoryController(req, resp);
        break;

        case"updateCategory":
        System.out.println("Se entro al caso de updateCategory");
        updateCategoryController(req, resp);
        break;

        //Ventas
        case"registerVent":
        System.out.println("Se entro al caso 'registerVent, en el metodo registerVent()'");
        registerVentController(req, resp);
        break;

        case"updateVent":
        System.out.println("Se entro al caso 'updateVent, en el metodo updateVent()'");
        updateVentController(req, resp);
        break;

        //Existencias
        case"registerExistence":
        System.out.println("Se entro al caso 'registerExistence, en el metodo registerExistence()'");
        registerExistenceController(req, resp);
        break;

        case"updateExistence":
        System.out.println("Se entro al caso 'updateExistence, en el metodo updateExistence()'");
        updateExistenceController(req, resp);
        break;

        //Proveedores
        case"registerSupplier":
        System.out.println("Se entro al caso 'registerExistence, en el metodo registerExistence()'");
        registerSupplierController(req, resp);
        break;

        case"updateSupplier":
        System.out.println("Se entro al caso 'updateExistence, en el metodo updateExistence()'");
        updateSupplierController(req, resp);
        break;

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
                System.out.println("Usuario y/o contraseña no encontrados");
                req.setAttribute("mensaje", "Usuario y/o contraseña no encontrados:(");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al intentar iniciar sesión");
        }
    }else {
        req.setAttribute("mensaje", "Usuario y/o contraseña no encontrados:(");
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
        req.getRequestDispatcher("FormsUser/registerUser.jsp").forward(req, resp);
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

    
    if(req.getParameter("unidadesDisponibles")!=null){
        ProdVo.setUnidadesDisponibles(Integer.parseInt(req.getParameter("unidadesDisponibles")));
    }
    if(req.getParameter("nameProduct")!=null){
        ProdVo.setNombreProducto(req.getParameter("nameProduct"));
    }
    if(req.getParameter("precio")!=null){
        ProdVo.setPrecioVenta(Float.parseFloat(req.getParameter("precio")));
    }
    if(req.getParameter("descripcion")!=null){
        ProdVo.setDescripcion(req.getParameter("descripcion"));
    }
    if(req.getParameter("serial")!=null){
        ProdVo.setSerial(Integer.parseInt(req.getParameter("serial")));
    }
    if(req.getParameter("garantiaEntrada")!=null){
        ProdVo.setGarantiaEntradaMeses(Integer.parseInt(req.getParameter("garantiaEntrada")));
    }
    if(req.getParameter("garantiaVentas")!=null){
        ProdVo.setGarantiaVentaMeses(Integer.parseInt(req.getParameter("garantiaVentas")));
    }
    if(req.getParameter("categoria")!=null){
        ProdVo.setIdCategoria(Integer.parseInt(req.getParameter("categoria")));
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
        System.out.println("entro al casos en dopost");

        if(req.getParameter("idProducto")!=null){
            ProdVo.setIdProducto(Integer.parseInt(req.getParameter("idProducto")));
        }
        if(req.getParameter("UpdateUnidadesDisponibles")!=null){
            ProdVo.setUnidadesDisponibles(Integer.parseInt(req.getParameter("UpdateUnidadesDisponibles")));
        }
        if(req.getParameter("UpdateNameProducto")!=null){
            ProdVo.setNombreProducto(req.getParameter("UpdateNameProducto"));
        }
        if(req.getParameter("UpdatePrecio")!=null){
            ProdVo.setPrecioVenta(Float.parseFloat(req.getParameter("UpdatePrecio")));
        }
        if(req.getParameter("UpdateDescripcion")!=null){
            ProdVo.setDescripcion(req.getParameter("UpdateDescripcion"));
        }
        if(req.getParameter("UpdateSerial")!=null){
            ProdVo.setSerial(Integer.parseInt(req.getParameter("UpdateSerial")));
        }
        if(req.getParameter("UpdateGarantiaEntrada")!=null){
            ProdVo.setGarantiaEntradaMeses(Integer.parseInt(req.getParameter("UpdateGarantiaEntrada")));
        }
        if(req.getParameter("UpdateGarantiaVentas")!=null){
            ProdVo.setGarantiaVentaMeses(Integer.parseInt(req.getParameter("UpdateGarantiaVentas")));
        }
        if(req.getParameter("UpdateCategoria")!=null){
            ProdVo.setIdCategoria(Integer.parseInt(req.getParameter("UpdateCategoria")));
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

//CRUD CATEGORIA
//REGISTRAR categoria

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
        req.getRequestDispatcher("FormsCategory/registerCategory.jsp").forward(req, resp);
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
            req.getRequestDispatcher("FormsCategory/indexCategoria.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del producto "+e.getMessage().toString());
        }
    }
    
    
private void listCateDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<CategoriaVo> categoria = CateDao.listar();
            req.setAttribute("Categoria", categoria);
            req.getRequestDispatcher("FormsCategory/indexCategoria.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente despues del categoria eliminado");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos en el metodo " + e.getMessage().toString());
        }
    }

    //CRUD VENTA
//REGISTRAR venta

private void registerVentController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    if (req.getParameter("dateVent") != null) {
        String fechaDate = req.getParameter("dateVent");
        Date fechaVentaParsedDate = Date.valueOf(fechaDate);
        VentVo.setFechaVenta(fechaVentaParsedDate);
    }
    if(req.getParameter("idUsuario")!=null){
        String idUsuString=req.getParameter("idUsuario");
        int idUsuParsed=Integer.parseInt(idUsuString);
        VentVo.setIdUsuario(idUsuParsed);
    }    
    else{
        System.out.println("Ha habido un error al tratar de registrar los datos de la venta en el metodo registerVentController");
    }
    try {
        VentDao.registerVent(VentVo);
        System.out.println("Registro insertado correctamente en controllerInLine");
        //Redireccionamiento
        req.getRequestDispatcher("FormsVent/registerVent.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Error al registrar los datos del usuario en ControllerInline en el metodo registerVentController");
    }
}

    //Actualizar Venta
private void updateVentController(HttpServletRequest req, HttpServletResponse resp) {

    if (req.getParameter("dateVent") != null) {
        String fechaDate = req.getParameter("dateVent");
        Date fechaVentaParsedDate = Date.valueOf(fechaDate);
        VentVo.setFechaVenta(fechaVentaParsedDate);
    }
    if(req.getParameter("idUsuario")!=null){
        String idUsuString=req.getParameter("idUsuario");
        int idUsuParsed=Integer.parseInt(idUsuString);
        VentVo.setIdUsuario(idUsuParsed);
    }    
        try {
            VentDao.actualizar(VentVo);
            System.out.println("Venta actualizado correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("FormsVent/indexVent.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion de la venta "+e.getMessage().toString());
        }
    }
    
    
private void listVentDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<VentaVo> venta = VentDao.listar();
            req.setAttribute("Venta", venta);
            req.getRequestDispatcher("FormsVent/indexVent.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente despues de la venta eliminada");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos en el metodo listVentdelete" + e.getMessage().toString());
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
        //Redireccionamiento
        req.getRequestDispatcher("FormsExistence/registerExistence.jsp").forward(req, resp);
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
            req.getRequestDispatcher("FormsExistence/indexExistence.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente despues de la existencia eliminada");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos en el metodo " + e.getMessage().toString());
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




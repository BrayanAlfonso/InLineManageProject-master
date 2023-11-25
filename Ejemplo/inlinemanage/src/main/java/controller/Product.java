package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductoDao;
import model.ProductoVo;


public class Product extends HttpServlet {
    ProductoVo ProdVo=new ProductoVo();
    ProductoDao ProdDao=new ProductoDao();

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            case "product":
                req.getRequestDispatcher("FormsProduct/indexProduct.jsp").forward(req, resp);
            break;
            case "registerProduct":
                req.getRequestDispatcher("FormsProduct/registerProduct.jsp").forward(req, resp);
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
        String enviar = req.getParameter("enviar");
        switch (enviar) {
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
        ProdVo.setSerial(req.getParameter("serial"));
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
        //mensaje
            req.setAttribute("mensaje1", "Producto Registrado");
        //Redireccionamiento
        req.getRequestDispatcher("FormsProduct/indexProduct.jsp").forward(req, resp);
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
            ProdVo.setSerial(req.getParameter("UpdateSerial"));
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
                //mensaje
            req.setAttribute("mensaje1", "Producto Actualizado");
    
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
            //mensaje
            req.setAttribute("mensaje1", "Producto Eliminado");
            req.getRequestDispatcher("FormsProduct/indexProduct.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente despues del producto eliminado");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos en el metodo " + e.getMessage().toString());
        }
    }
}

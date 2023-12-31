<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>

<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.UsuarioVo"%>
<%@ page import="model.UsuarioDao"%>
<%@ page import="model.ProductoVo"%>
<%@ page import="model.ProductoDao"%>

<main class="main" id="mainForm">
    <div>
        <a href="Vent?enviar=vent"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div>

    <form action="Vent" method="post" id="formValidVent" novalidate>
        <h1 class="title-table">Registro de Ventas</h1>
        <div class="contentForm">

            <!-- <div class="dateVent">
                <label for="dateVent">Fecha de la venta:</label>
                <input type="date" id="dateVent" name="dateVent" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div> -->

            <!-- Usuario -->
            <!-- <%List <UsuarioVo> usuarios = null;
                try {
                    usuarios = new UsuarioDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                %> -->
    
            <!-- <div class="idUsuario">
                <label for="idUsuario">Usuario:</label>
                <select name="idUsuario" id="idUsuario">
                    <option value="0">Seleccionar...</option>
                    <% for (UsuarioVo usuario : usuarios) { %>
                    <option value=<%=usuario.getIdUsuario()%>><%=usuario.getNombre()%></option>
                    <% }%>
                </select>
                <span class="fbForm">Hola Mundo</span>
            </div> -->
    
            <div class="Producto">

                <label for="idProducto">Producto:</label>

                <!-- Producto -->
                <%List <ProductoVo> productos = null;
                    try {
                        productos = new ProductoDao().listar();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    %>
                
                <!-- Filtra productos por la categoria (idCategoria) -->
                <select name="idProducto" id="idProducto" class="inputForm">
                    <option value="0">Selecciona el producto...</option>
                    <% for (ProductoVo producto : productos) { %>
                    <option value=<%=producto.getIdProducto()%>><%=producto.getNombreProducto()%></option>
                    <% }%>
                </select>
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="precioProducto">
                <label for="precioProducto">Precio:</label>
                <input type="text" id="precioProducto" name="precioProducto" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="Cantidad">
                <label for="Cantidad">Cantidad:</label>
                <input type="text" id="Cantidad" name="Cantidad" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerVent">Registrar</button>
            </div>
        </div>
    </form>
        <% String mensaje1 = (String) request.getAttribute("mensaje1"); %> 

        <!-- Campo para mostrar el mensaje traido desde Java -->
        <% if (mensaje1 == null) {%>
            <div></div>
        <%}else{%>
            <div id="mensaje2"></div>
        <%}%>
</main>

<%@ include file="../plantillas/footer.jsp"%>



<script src="assets/js/JsVent/registerVent1.js">
</script>
<%@ include file="../plantillas/footer2.jsp"%>


<%
}else{
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
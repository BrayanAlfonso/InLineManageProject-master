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
<%@ page import="model.EntradaVo"%>
<%@ page import="model.EntradaDao"%>
<%@ page import="model.ProductoVo"%>
<%@ page import="model.ProductoDao"%>

<main class="main" id="mainForm">
    <div>
        <a href="existence?enviar=existence"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br><br>

    <form action="existence" id="formValiderE" method="post">
        <h1 class="title-table">Registro de Existencias</h1>
        <div class="contentForm">

            <div class="cantidadUnidad" id="divCantidadUnidad">
                <label for="cantidadUnidad">Cantidad:</label>
                <input type="text" id="cantidadUnidad" class="inputForm" name="cantidadUnidad" required>
                <span class="fbForm"></span> 
            </div>
    
            <div class="precioEntrada" id="divPrecioEntrada">
                <label for="precioEntrada">Precio:</label>
                <input type="text" id="precioEntrada" class="inputForm" name="precioEntrada" required>
                <span class="fbForm"></span> 
            </div>

            <% List <ProductoVo> productos = null;
                try {
                    productos = new ProductoDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
    
            <div class="idProducto" id="divIdProducto">
                <label for="idProducto">Id de Producto:</label>
                <select id="idProducto" name="idProducto" class="inputForm">
                    <option value="" disabled selected>-- Seleccione un producto --</option>
                    <% for (ProductoVo producto : productos) { %>
                        <option value="<%= producto.getIdProducto() %>"><%= producto.getNombreProducto() %></option>
                        <% } %>
                </select>
                <span class="fbForm"></span> 
            </div>

            <%List <EntradaVo> entradas = null;
                try {
                 entradas = new EntradaDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
             %>
    
            <div class="idEntradaProd" id="divIdEntradaProd">
                <label for="idEntradaProd">Num. de Entrada del producto:</label>
                <select id="idEntradaProd" name="idEntradaProd" class="inputForm">
                    <option value="" disabled selected>-- Seleccione una entrada--</option>
                    <% for (EntradaVo entrada : entradas) { %>
                        <option value="<%= entrada.getIdEntradaProd() %>"><%= entrada.getIdEntradaProd() %></option>
                        <% } %>
                </select>
                <span class="fbForm"></span> 
            </div>
       
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerExistence">Registrar</button>
            </div>
            <div id="mensaje"></div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>
<% String mensaje = (String) request.getAttribute("mensaje"); %>

<script>
    window.onload = function() {
        var mensajeVE = document.getElementById("mensaje");
        if (mensaje != null) { 
            mensajeVE.textContent = "<%= mensaje %>";
        }
    };
</script>
<script src="assets/js/JsExist/validerExistence.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    request.setAttribute("mensaje", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
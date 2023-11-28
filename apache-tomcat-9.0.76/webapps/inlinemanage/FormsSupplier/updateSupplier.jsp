<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>


<%@ include file="../plantillas/header.jsp"%>

<%-- Importar la clase ProveedorVo y ProveedorDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProveedorVo" %>
<%@ page import="model.ProveedorDao" %>

<main class="mainFrom" id="mainForm">  
    <div>
        <a href="Supplier?enviar=supplier"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br><br>
    <%-- Obtener el id del proveedor seleccionado de la URL --%>
    <% String provId = request.getParameter("idProveedor"); %>
    <% int id = Integer.parseInt(provId); %>
    <% ProveedorVo prov = null;
    try {
        prov = new ProveedorDao().obtenerProveedorPorId(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>

    <%-- Verificar si se encontró el proveedor y mostrar el formulario de actualización --%>
    <% if (prov != null) { %>
    <form action="Supplier" method="post">
        <h1 class="title-table">Actualizacion de proveedores</h1>

        <input type="hidden" name="idProveedor" id="idProveedor" value="<%= prov.getIdProveedor() %>">

        <div class="contentForm">
    
            <div class="divUpdateNameSupplier" id="divUpdateNameSupplier">
                <label for="UpdateNameSupplier">Nombre:</label>
                <input type="text" id="UpdateNameSupplier" class="inputForm" name="UpdateNameSupplier"value="<%= prov.getNombreProveedor() %>">
                <span class="fbForm"></span>  
            </div>
    
            <div class="divUpdateAdressSupplier" id="divUpdateAdressSupplier">
                <label for="UpdateAdressSupplier">Dirección:</label>
                <input type="text" id="UpdateAdressSupplier" class="inputForm" name="UpdateAdressSupplier" value="<%= prov.getDireccionProveedor() %>">
                <span class="fbForm"></span>  
            </div>

            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="updateSupplier">Actualizar</button>
            </div>
        </div>
    </form>
    <% } else { %>
        <p>No se encontró el proveedor.</p>
    <% } %>
</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<!-- Si necesitan un archivo js especifico ira aqui -->
<script src="assets/js/JsProv/updateValiderSupplier.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>


<%
}else{
    request.setAttribute("mensaje", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
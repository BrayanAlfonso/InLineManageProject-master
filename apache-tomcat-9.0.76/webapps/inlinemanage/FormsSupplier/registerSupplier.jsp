<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>


<%@ include file="../plantillas/header.jsp"%>
<main class="mainForm" id="mainForm">
    <div>
        <a href="Supplier?enviar=supplier"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br><br>

    <form action="Supplier" id="formValiderP" method="post">
        <h1 class="title-table">Registro de Proveedores</h1>
        <div class="contentForm">

            <div class="divNombreProveedor" id="divNombreProveedor">
                <label for="nombreProveedor">Nombre:</label>
                <input type="text" id="nombreProveedor" class="inputForm" name="nombreProveedor" required>
                <span class="fbForm"></span>  
            </div>

            <div class="divDireccionProveedor" id="divDireccionProveedor">
                <label for="direccionProveedor">Dirección:</label>
                <input type="text" id="direccionProveedor" class="inputForm" name="direccionProveedor" required>
                <span class="fbForm"></span> 
            </div>
       
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerSupplier">Registrar</button>
            </div>
            <div id="mensaje"></div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>
<% String mensaje = (String) request.getAttribute("mensaje"); %>

<script>
    window.onload = function() {
        var mensajeVP = document.getElementById("mensaje");
        if (mensaje != null) { 
            mensajeVP.textContent = "<%= mensaje %>";
        }
    };
</script>
<script src="assets/js/JsProv/validerSupplier.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    request.setAttribute("mensaje", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
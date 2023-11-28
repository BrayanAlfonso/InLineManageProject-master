
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>

<%@ include file="../plantillas/header.jsp"%>
<%-- Importar la clase UsuarioVo y UsuarioDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.UsuarioVo" %>
<%@ page import="model.UsuarioDao" %>



<main class="main" id="mainForm">  
    <div>
        <a href="User?enviar=user"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div>
    <%-- Obtener el id del usuario seleccionado de la URL --%>
    <% String userId = request.getParameter("idUsuario"); %>
    <% int id = Integer.parseInt(userId); %>
    <% UsuarioVo user = null;
    try {
        user = new UsuarioDao().obtenerUsuarioPorId(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>

    <%-- Verificar si se encontró el usuario y mostrar el formulario de actualización --%>
    <% if (user != null) { %>
    <form action="User" method="post" class="formUpdate">
        <h1 class="title-table">Actualizacion de usuarios</h1>

        <input type="hidden" name="idUsuario" id="idUsuario" value="<%= user.getIdUsuario() %>">

        <div class="contentForm">
            <div class="divDocumentType">
                <label for="UpdateDocumentType">Tipo de documento:</label><br>
                <select name="UpdateDocumentType" id="UpdateDocumentType" class="inputForm">
                    <option value="CC" <%= (user.getTipoDoc().equals("CC")) ? "selected" : "" %>>CC</option>
                    <option value="TI" <%= (user.getTipoDoc().equals("TI")) ? "selected" : "" %>>TI</option>
                </select>
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divNoDocument">
                <label for="UpdateNoDocument">Numero de documento:</label>
                <input type="text" id="UpdateNoDocument" name="UpdateNoDocument" value="<%= user.getNumeroDoc() %>" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divName">
                <label for="name">Nombre:</label>
                <input type="text" id="UpdateName" name="UpdateName"value="<%= user.getNombre() %>" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divLastName">
                <label for="UpdateLastName">Apellido:</label>
                <input type="text" id="UpdateLastName" name="UpdateLastName" value="<%= user.getApellido() %>" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divEmail">
                <label for="UpdateEmail">Correo:</label>
                <input type="email" id="UpdateEmail" name="UpdateEmail" value="<%= user.getCorreo() %>" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="divCEmail">
                <label for="cEmail">Confirma tu correo electronico:</label>
                <input type="email" id="cEmail" name="cEmail" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divPassword">
                <label for="UpdatePassword">Contraseña:</label>
                <input type="password" id="UpdatePassword" name="UpdatePassword" value="<%= user.getContraseña() %>" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            
            <div class="divCPassword">
                <label for="cPassword">Confirma tu contraseña:</label>
                <input type="password" id="cPassword" name="cPassword" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divRol">
                <label for="UpdateRol">Rol</label><br>
                <select name="UpdateRol" id="UpdateRol" class="inputForm">
                    <option value="1" <%= (user.getIdRol() == 1) ? "selected" : "" %>>Administrador</option>
                    <option value="2" <%= (user.getIdRol() == 2) ? "selected" : "" %>>Empleado</option>
                </select>
                <span class="fbForm">Hola Mundo</span>
            </div>
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="updateUser">Actualizar</button>
            </div>
        </div>
    </form>
    <% } else { %>
        <p>No se encontró el usuario.</p>
    <% } %>
</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<script src="assets/js/JsUser/updateUser.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
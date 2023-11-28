<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>


<%@ include file="../plantillas/header.jsp"%>
<main class="main"  id="mainForm">
    <div>
        <a href="User?enviar=user"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br><br>

    <form action="User" method="post" id="formRegisterUser">
        <h1 class="title-table">Registro de usuarios</h1>
        <div class="contentForm">
            <div class="divDocumentType">
                <label for="documentType">Tipo de documento:</label><br>
                <select name="documentType" id="documentType" class="inputForm">
                    <option value="CC">CC</option>
                    <option value="TI">TI</option>
                </select>
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divNoDocument">
                <label for="noDocument">Numero de documento:</label>
                <input type="text" id="noDocument" name="noDocument" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
            
            <div class="divName">
                <label for="name">Nombre:</label>
                <input type="text" id="name" name="name" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divLastName">
                <label for="lastName">Apellido:</label>
                <input type="text" id="lastName" name="lastName" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divEmail">
                <label for="email">Correo:</label>
                <input type="email" id="email" name="email" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="divCEmail">
                <label for="cEmail">Confirma tu correo electronico:</label>
                <input type="email" id="cEmail" name="cEmail" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divPassword">
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="divCPassword">
                <label for="cPassword">Confirma tu contraseña:</label>
                <input type="password" id="cPassword" name="cPassword" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="divRol">
                <label for="rol">Rol</label><br>
                <select name="rol" id="rol" class="inputForm">
                    <option value="1">Administrador</option>
                    <option value="2">Empleado</option>
                </select>
                <span class="fbForm">Hola Mundo</span>
            </div>
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerUser">Registrar</button>
            </div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>
<script src="assets/js/JsUser/registerUser1.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
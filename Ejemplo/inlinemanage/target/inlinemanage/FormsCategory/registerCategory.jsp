<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>

<%@ include file="../plantillas/header.jsp"%>
<main class="main" id="mainForm">
    <div>
        <a href="category?enviar=categoria"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br>

    <form action="category" method="post" id="formValidacion">
        <h1 class="title-table">Registro de Categoria</h1>
        <div class="contentForm">
            <div class="divNameCategory">
                <label for="nameCategory">Nombre de categoria:</label>
                <input type="text" id="nameCategory" name="nameCategory" class="inputForm">
                <span class="fbForm"></span>
            </div>
    
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerCategory">Registrar</button>
            </div>
        </div>

    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>
    <script src="assets/js/JsCate/registerCate.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    request.setAttribute("mensaje", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
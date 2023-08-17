<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<main class="main">
    <div class="backlog">
        <a href="ControllerInline?enviar=categoria"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
    </div><br>

    <form action="ControllerInline" method="post">
        <h1 class="title-table">Registro de Categoria</h1>
        <div class="contentForm">
            <div class="nameCategory">
                <label for="nameCategory">Nombre de categoria:</label>
                <input type="text" id="nameCategory" name="nameCategory" class="inputForm">
            </div>
    
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerCategory" >Registrar</button>
            </div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>
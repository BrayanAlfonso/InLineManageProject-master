<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<main class="main" id="mainForm">
    <div>
        <a href="ControllerInline?enviar=categoria"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br>

    <form action="ControllerInline" method="post" id="formValidacion">
        <h1 class="title-table">Registro de Categoria</h1>
        <div class="contentForm">
            <div class="divNameCategory">
                <label for="nameCategory">Nombre de categoria:</label>
                <input type="text" id="nameCategory" name="nameCategory" class="inputForm">
                <span class="fbForm"></span>
            </div>
    
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerCategory" >Registrar</button>
            </div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>
<script src="assets/js/JsCate/registerCate.js"></script>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="plantillas/header.jsp"%>

<main>
    <div class="welcome">
        <h2>Bienvenido a</h2>
        <h1>Interline Comunicaciones.</h1>
    </div>
    <div class="login-container">
        <div class="login">
            
                <h1 class="nameLogin">INICIO DE SESIÓN</h1>
                <form action="ControllerInline" method="post" id="formLogin" novalidate>
                    <div class="inputs" id="divName">
                        <label for="inputUserName"><b>Nombre de usuario:</b></label><br><br>
                        <input type="text" id="inputUserName" name="inputUserName" class="inputForm">
                        <div class="feedback"><p>sadasd</p></div> 
                    </div>
                    
                    <div class="inputs" id="divPassword">
                        <label for="inputPassword"><b>Contraseña:</b></label><br><br>
                        <input type="text" id="inputPassword" name="inputPassword" class="inputForm">
                        <div class="feedback"><p>dadsa</p></div> 
                    </div>
                    

                    <button name="enviar" id="btnLogin"value="index">INICIAR SESIÓN</button>    

                    <div id="mensaje"></div>
                </form>
                
        </div>
    </div>
</main>
</div>
    
<%@ include file="../plantillas/footer.jsp"%>




<script>
    let btnLogin=document.getElementById("btnLogin")
    btnLogin.addEventListener("click", (e)=>{
        e.preventDefault()
        var mensajeLogin = document.getElementById("mensaje");
        if (mensaje != null) { 
            mensajeLogin.style.visibility="visible"
            mensajeLogin.style.opacity="1"
            mensajeLogin.style.transition="visibility 0s, opacity 0.5s"
            mensajeLogin.textContent = "<%= mensaje %>";
        }
    });
</script>
<script src="assets/js/index1.js"></script>


<%@ include file="../plantillas/footer2.jsp"%>
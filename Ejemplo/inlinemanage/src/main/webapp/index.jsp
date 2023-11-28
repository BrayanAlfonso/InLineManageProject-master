
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InLineManage</title>
    <link rel="stylesheet" href="assets/css/index1.css">
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/StylesBarCode1.css">
    <link rel="stylesheet" href="assets/css/indexModule1.css">
    <link rel="stylesheet" href="assets/css/modalReports1.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="icon" href="./LogoInterline.ico" type="image/x-icon">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <script src="https://kit.fontawesome.com/8232721784.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Caveat&family=Concert+One&family=Oxygen&family=Playfair:ital,wght@0,300;1,500&family=Wix+Madefor+Display:wght@800&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
    <header>
        <img src="assets/img/LogoInterline.PNG" alt="LogoInterline" class="logo">
        <h1 class="nameInterline">INTERLINE COMUNICACIONES</h1>
    </header>

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
                        <label for="inputUserName"><b>Ingreso tu correo electronico:</b></label><br><br>
                        <input type="text" id="inputUserName" name="inputUserName" class="inputForm">
                        <span class="fbForm"></span> 
                    </div>
                    
                    <div class="inputs" id="divPassword">
                        <label for="inputPassword"><b>Contraseña:</b></label><br><br>
                        <input type="password" id="inputPassword" name="inputPassword" class="inputForm">
                        <span class="fbForm"></span> 
                    </div>

                    <div class="inputs" id="divRol">
                        <label for="inputRol"><b>Rol:</b></label><br><br>
                        <select id="inputRol" name="inputRol" class="inputForm">
                            <option value="1">Administrador</option>
                            <option value="2">Empleado</option>
                        </select>
                        <span class="fbForm"></span> 
                    </div>
                    

                    <button name="enviar" id="btnLogin" value="index">INICIAR SESIÓN</button>    

                        <!-- Declaración de la variable mensaje que se trae desde el controlador "ControllerInline"-->
                        <% String mensaje = (String) request.getAttribute("mensaje"); %> 
    
                        <!-- Campo para mostrar el mensaje traido desde Java -->
                        <% if (mensaje == null) {%>
                            <div></div>
                        <%}else{%>
                            <div id="mensaje"></div>
                        <%}%>
                </form>
                
        </div>
    </div>
</main>
</div>
    
<%@ include file="../plantillas/footer.jsp"%>


<script>
    let mensajeJS="<%= mensaje %>"
    let mensajeLogin = document.getElementById("mensaje");
    if(mensajeJS==" " || mensajeJS==null ){

        console.log(mensajeJS+"es nulo")
    }else{
        console.log(mensajeLogin)
        if(mensajeLogin!=null){
            mensajeLogin.style.visibility="visible"
            mensajeLogin.style.opacity="1"
            mensajeLogin.style.transition="visibility 0s, opacity 0.5s"
            mensajeLogin.textContent=mensajeJS
        }
    }
</script>
<script src="assets/js/index.js"></script>


<%@ include file="../plantillas/footer2.jsp"%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
    <script>
        function toggleMenu() {
            var menu = document.querySelector('.menuUser');
            menu.classList.toggle('active');
        }
    </script>
    <link href="https://fonts.googleapis.com/css2?family=Caveat&family=Concert+One&family=Oxygen&family=Playfair:ital,wght@0,300;1,500&family=Wix+Madefor+Display:wght@800&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
    <header>
        <img src="assets/img/LogoInterline.PNG" alt="LogoInterline" class="logo">
        <h1 class="nameInterline">INTERLINE COMUNICACIONES</h1>
        <div class="menuUser" onclick="toggleMenu()">
            <div id="iconUser">
                <i class="fa-solid fa-user" style="color: #000000;" ></i>
            </div>  
            <div class="userOptions">
                <h3>Bienvenido</h3>
                <a href="ControllerInline?enviar=closeSession" class="linkMenu">Cerrar sesión</a>
            </div>
        </div>
    </header>

    
    


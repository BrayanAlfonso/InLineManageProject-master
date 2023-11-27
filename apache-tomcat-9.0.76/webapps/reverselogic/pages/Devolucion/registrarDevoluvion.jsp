<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/usuario.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/registrarEmple.css">

    <title>Registrar Devolucion</title>
</head>
<body>
    <body>
        <div class="cont2"></div>
        <div class="all">
            <header>
                <img src="img/logo-removebg-preview.png">
            <div class="menu">
                <ul>
                    <li class="submenu">
                        <a href="#"><img class="imgbtn" src="img/usuario-de-perfil.png" ></a>
                        <ul>
                            <li><a href="#"><button>Perfil</button></a></li>
                            <li><a href="index.jsp"><button>Menú</button> </a></li>
                            <li> 
                                <form action="CerrarSesion" method="post">
                                    <input type="submit" class="btnSalir" value="Salir">
                                </form>
                            </li> 
                        </ul>
                    </li>
                </ul>
            </div>
            </header>
            <h1>Registrar Devolucion</h1>
            <div class="cont12">
           
    <form action="Devolucion" method="post">
        <br>
        <div class="contlabel">
        <input type="text" name="Devo_Cant_Preducto" id="Devo_Cant_Preducto" required>
        <label for="Devo_Cant_Preducto"> Cantidad del producto</label>
        </div>
        <br>
        <br>
        <div class="contlabel1">
        <input type="text" name="Devo_Razon" id="Devo_Razon" required>
        <label for="Devo_Razon">Razon de Devolucion</label>
        </div>
        <br><br>
        <div class="contlabel2">
        <input type="Date" name="Devo_Fecha" id="Devo_Fecha" required>
        <label for="Devo_Fecha"> Fecha</label>
        </div>
        <br><br>
        <div class="contlabel3">
        <input type="text" name="Emple_id" id="Devo_Emple_id" required>
        <label for="Devo_Emple_id">Id Empleado</label>
        </div>
        <br>
        <button id="btncal" name="enviar" value="registerDevo">Enviar</button>
    </form>
</body>
</html>
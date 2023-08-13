<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="model.UsuarioVo" %>
<%@ page import="model.UsuarioDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Usuario</title>
</head>
<body>
    <h1>Actualizar Usuario</h1>

    <%-- Obtener el id del usuario seleccionado de la URL --%>
    <% String userId = request.getParameter("user_id"); %>
    <% int id = Integer.parseInt(userId); %>
    <% UsuarioVo usuario = null;
       try {
           usuario = new UsuarioDao().obtenerUsuarioPorId(id);
       } catch (Exception e) {
           e.printStackTrace();
       }
    %>

    <%-- Verificar si se encontró el usuario y mostrar el formulario de actualización --%>
    <% if (usuario != null) { %>
        <form action="JavaWeb" method="post">
            <%-- Agregar un campo oculto para el userId --%>
            <input type="hidden" name="user_id" value="<%= usuario.getUserId() %>">
            <label for="updateUserName">Nombres:</label>
            <input type="text" id="updateUserName" name="updateUserName" value="<%= usuario.getUserFirstName() %>"><br>
            <label for="updateUserLastName">Apellidos:</label>
            <input type="text" id="updateUserLastName" name="updateUserLastName" value="<%= usuario.getUserLastName() %>"><br>
            <label for="updateUserEmail">Correo:</label>
            <input type="email" id="updateUserEmail" name="updateUserEmail" value="<%= usuario.getUserEmail() %>"><br>
            <label for="updateUserPassword">Contraseña:</label>
            <input type="password" id="updateUserPassword" name="updateUserPassword" value="<%= usuario.getUserPassword() %>"><br>
            <button type="submit" name="enviar" value="updateUser">Actualizar</button>
        </form>
    <% } else { %>
        <p>No se encontró el usuario.</p>
    <% } %>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Usuarios</title>
</head>
<body>
    <h1>Listado de Usuarios</h1>
    
    <%-- Importar la clase UsuarioVo y UsuarioDao --%>
    <%@ page import="model.UsuarioVo" %>
    <%@ page import="model.UsuarioDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<UsuarioVo> usuarios = null;
       try {
           usuarios = new UsuarioDao().listar();
       } catch (Exception e) {
           e.printStackTrace();
       }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (usuarios != null && !usuarios.isEmpty()) { %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Contraseña</th>
                <th colspan="2">Acciones</th>
            </tr>
            <%-- Recorrer la lista de usuarios y mostrar sus detalles --%>
            <% for (UsuarioVo usuario : usuarios) { %>
                <tr>
                    <td><%= usuario.getUserId() %></td>
                    <td><%= usuario.getUserFirstName() %></td>
                    <td><%= usuario.getUserLastName() %></td>
                    <td><%= usuario.getUserEmail() %></td>
                    <td><%= usuario.getUserPassword() %></td>
                    <td> <a href="JavaWeb?enviar=updateUser&user_id=<%= usuario.getUserId() %>">Actualizar</a></td>
                    <td><a href="JavaWeb?enviar=deleteUser&user_id=<%= usuario.getUserId() %>">Eliminar</a></td>
                </tr>
            <% } %>

        </table>
    <% } else { %>
        <p>No se encontraron usuarios.</p>
    <% } %>

</body>
</html>

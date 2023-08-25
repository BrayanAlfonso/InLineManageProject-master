
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%-- Importar la clase UsuarioVo y UsuarioDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.UsuarioVo" %>
<%@ page import="model.UsuarioDao" %>
<main class="main">  
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="ControllerInline?enviar=main"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btnMenu" id="btnInsertUser">Agregar</button>
            <input type="text" placeholder="buscar" class="inputSearch">
        </div>
        <div class="content2">

            <%-- Obtener la lista de usuarios desde la base de datos --%>
            <% List<UsuarioVo> users = null;
            try {
                users = new UsuarioDao().listar();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>

            <%-- Verificar si hay usuarios y mostrarlos --%>
            <% if (users != null && !users.isEmpty()) { %>
            <table class="<%=(users.size() > 8) ? "" : "few-rows"%>">
                <tr class="title-table">
                    <th colspan="7">USUARIOS</th>
                </tr>
                <tr>
                    <th rowspan="2">Tipo Documento</th>
                    <th rowspan="2">Nombre</th>
                    <th rowspan="2">Apellido</th>
                    <th rowspan="2">Correo</th>
                    <th rowspan="2">Rol</th>
                    <th colspan="2">Acciones</th>
                </tr>
                <tr>
                    <th>
                        Actualizar
                    </th>
                    <th>
                        Eliminar
                    </th>
                </tr>

                <%-- Recorrer la lista de usuarios y mostrar sus detalles --%>
                <% for (UsuarioVo user : users) { %>
                <tr>
                    <td><%= user.getTipoDoc() %></td>
                    <td><%= user.getNombre() %></td>
                    <td><%= user.getApellido() %></td>
                    <td><%= user.getCorreo() %></td>
                    <td><%= user.getIdRol() %></td>
                    <td class="iconCenter"><a href="ControllerInline?enviar=updateUser&idUsuario=<%= user.getIdUsuario() %>"><img src="https://img.icons8.com/ios/100/000000/refresh--v1.png" alt="refresh--v1" class="iconUpdate"/></a></td>
                    <td class="iconCenter"><a href="ControllerInline?enviar=deleteUser&idUsuario=<%= user.getIdUsuario() %>"><img height="30" src="https://img.icons8.com/ios/100/000000/delete--v1.png" alt="delete--v1" class="iconDelete"/></a></td>
                </tr>
                <% } %>

            </table>
            <% } else { %>
                <p>No se encontraron usuarios.</p>
            <% } %>
    </div>


</div>
<div class="form">
    
</div>
</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<script src="assets/js/insertUser1.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>
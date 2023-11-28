
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>

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
            <button class="btnMenu" id="btnInsertUser"><a href="User?enviar=registerUser">Agregar</a></button>
            <input type="text" placeholder="buscar" class="inputSearch" id="searchInput">
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
        <div class="tabla-scroll">    
            <%-- Verificar si hay usuarios y mostrarlos --%>
            <% if (users != null && !users.isEmpty()) { %>
            <table>
                <tr class="title-table">
                    <th colspan="7">USUARIOS</th>
                </tr>
                <tr class="encabezados-tabla">
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
                    <td class="iconCenter"><a href="User?enviar=updateUser&idUsuario=<%= user.getIdUsuario() %>"><i class="fa-solid fa-repeat" style="color: #54AC9C;" alt="refresh--v1" class="iconUpdate"></i></a></td>
                    <td class="iconCenter"><a href="User?enviar=deleteUser&idUsuario=<%= user.getIdUsuario() %>"><i class="fa-solid fa-trash" style="color: #ff0000;" alt="delete--v1" class="iconDelete"></i></a></td>
                </tr>
                <% } %>

            </table>
            <% } else { %>
                <p>No se encontraron usuarios.</p>
            <% } %>
        </div>
    </div>


</div>
<% String mensaje1 = (String) request.getAttribute("mensaje1"); %> 
    
                        <!-- Campo para mostrar el mensaje traido desde Java -->
                        <% if (mensaje1 == null) {%>
                            <div></div>
                        <%}else{%>
                            <div id="mensaje1"></div>
                        <%}%>
</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<script>
    const mensajeJS="<%= mensaje1 %>"

    let mensajeU = document.getElementById("mensaje1");
    if(mensajeJS==" " || mensajeJS==null){

        console.log(mensajeJS+"es nulo")
    }else{
        mensajeU.textContent=mensajeJS
        mensajeU.style.opacity = "1"
        
        setTimeout(function() {
        mensajeU.style.opacity = "0";
        }, 3000);
    }
</script>
<script src="assets/js/searchUser1.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    request.setAttribute("mensaje3", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
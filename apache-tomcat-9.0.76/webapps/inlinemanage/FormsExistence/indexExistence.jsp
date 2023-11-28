<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>

<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ExistenciaVo"%>
<%@ page import="model.ExistenciaDao"%>

<main class="main">  
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="Product?enviar=product"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btn" ><a href="existence?enviar=registerExistence">Agregar</a></button>
            <input type="text" placeholder="buscar" class="inputSearch">
        </div>
        <div class="content2">


        
            <%List <ExistenciaVo> existencias = null;
            try {
                existencias = new ExistenciaDao().listarExist();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        <div class="tabla-scroll">
            <%-- Verificar si hay existencias y mostrarlos --%>
            <%if (existencias != null && !existencias.isEmpty()) {%>
                <table>
                    <tr class="title-table">
                        <th colspan="7">EXISTENCIAS</th>
                    </tr>
                    <tr>
                        <th rowspan="2">CantidadUnidad</th>
                        <th rowspan="2">PrecioEntrada</th>
                        <th rowspan="2">IdProducto</th>
                        <th rowspan="2">EntradaProductos</th>
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
                    <%-- Recorrer la lista de existencia y mostrar sus detalles --%>
                    <% for (ExistenciaVo existencia : existencias) { %>
                        <tr>
                            <td><%=existencia.getCantidadUnidad()%></td>
                            <td><%=existencia.getPrecioEntrada()%></td>
                            <td><%=existencia.getIdProducto()%></td>
                            <td><%=existencia.getIdEntradaProd()%></td>
                            <td class="iconCenter"><a href="existence?enviar=updateExistence&idExistencia=<%= existencia.getIdExistencia() %>"><i class="fa-solid fa-repeat" style="color: #54AC9C;" alt="refresh--v1" class="iconUpdate"></i></a></td>
                            <td class="iconCenter"><a href="existence?enviar=deleteExistence&idExistencia=<%= existencia.getIdExistencia() %>"><i class="fa-solid fa-trash" style="color: #ff0000;" alt="delete--v1" class="iconDelete"></i></a></td>
                        </tr>
                    <%}%>
                </table>
            <%} else{%>
                <p>No se encontraron Existencias.</p>
            <%}%>
        </div>       
    </div>
</div>
<!-- Declaración de la variable mensaje que se trae desde el controlador "ControllerInline"-->
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
    let mensajeJS="<%= mensaje1 %>"
</script>
<script src="assets/js/JsExist/indexEx.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    request.setAttribute("mensaje", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
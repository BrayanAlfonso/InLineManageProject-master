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
<%@ page import="model.EntradaVo"%>
<%@ page import="model.EntradaDao"%>
<%@ page import="model.ProveedorVo" %>
<%@ page import="model.ProveedorDao" %>

<main class="main">  
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="Supplier?enviar=supplier"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btnMenu" ><a href="entrada?enviar=registerEntrada">Agregar</a></button>
            <br>
            <input type="text" placeholder="buscar" class="inputSearch" id="searchInput">
        </div>
        <div class="content2">
        
            <%List <EntradaVo> entradas = null;
               try {
                entradas = new EntradaDao().listar();
               } catch (Exception e) {
                   e.printStackTrace();
               }
            %>

            <% List<ProveedorVo> provs = null;
                try {
                    provs = new ProveedorDao().listarProv();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        <div class="tabla-scroll">
            <%-- Verificar si hay entrada de productos y mostrarlos --%>
            <%if (entradas != null && !entradas.isEmpty()) {%>
                <table>
                    <tr class="title-table">
                        <th colspan="7" class="title-table">ENTRADAS</th>
                    </tr>
                    <tr>
                        <th rowspan="2">N_entrada</th>
                        <th rowspan="2">Fecha</th>
                        <th rowspan="2">Proveedor</th>
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
                    <%-- Recorrer la lista de entradas y mostrar sus detalles --%>
                    <% for (EntradaVo entrada : entradas) { %>
                        <tr>
                            <td><%=entrada.getIdEntradaProd()%></td>
                            <td><%=entrada.getFechaIngreso()%></td>
                        <% for (ProveedorVo proveedor : provs) { %>
                            <% if(proveedor.getIdProveedor() == entrada.getIdProveedor()){ %>
                            <td><%= proveedor.getNombreProveedor()%></td>
                            <% }%>
                        <% } %>

                            <td class="iconCenter"><a href="entrada?enviar=updateEntrada&idEntradaProd=<%=entrada.getIdEntradaProd()%>"><i class="fa-solid fa-repeat" style="color: #54AC9C;" alt="refresh--v1" class="iconUpdate"></i></a></td>
                            <td class="iconCenter"><a href="entrada?enviar=deleteEntrada&idEntradaProd=<%=entrada.getIdEntradaProd()%>"><i class="fa-solid fa-trash" style="color: #ff0000;" alt="delete--v1" class="iconDelete"></i></a></td>
                        </tr>
                    <%}%>
                </table>
            <%} else{%>
                <p>No se encontraron Productos.</p>
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
<script src="assets/js/JsEntrada/indexE.js"></script>

<%
}else{
    request.setAttribute("mensaje", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
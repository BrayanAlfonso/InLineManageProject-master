
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
<%@ page import="model.UsuarioVo" %>
<%@ page import="model.UsuarioDao" %>
<%@ page import="model.VentaVo" %>
<%@ page import="model.VentaDao" %>
<%@ page import="model.DetalleVentVo" %>
<%@ page import="model.DetalleVentDao" %>

<main class="main">
    <div class="content1">
        <div class="options">

            <button class="btnMenu"><a href="Vent?enviar=registerVent">Agregar</a></button>
            <button class="btnMenu" id="abrirModalReportes">Generar reporte</button>

            <input type="text" placeholder="buscar" class="inputSearch">
        </div>
        <div class="content2">

            <div class="modal" id="modalReportes">
                <div class="modalBody">
                    <div class="modalHeader">
                        <h1>Reportes</h1>
                        <span class="cerrarModal" id="cerrarModal">&times;</span>
                    </div>
                    <div class="modalContent">
                        
                        <form action="Reports" class="formReports">
                            <div class="divReports">
                                <div class="divContent">
                                    <button class="btnReport"><a href="Reports?enviar=DeVent">Reporte completo</a></button>
                                </div>

                                <div class="divContent2">
                                    <h1>Reporte filtrado</h1>

                                    <input type="date" name="dateFilter" id="dateFilter">
                                    <button name="enviar" value="DeVentFilter">Generar reporte filtrado</button>
                                </div>    

                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
            <% List<VentaVo> ventas = null;
                try {
                    ventas = new VentaDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                %>
            
                
            <% List<DetalleVentVo> dtventas = null;
                try {
                    dtventas = new DetalleVentDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                %>

            <% List<UsuarioVo> usuarios = null;
                try {
                    usuarios = new UsuarioDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                %>
        <div class="tabla-scroll">                    
            <%-- Verificar si hay usuarios y mostrarlos --%>
            <% if (usuarios != null && !usuarios.isEmpty()) { %>
            <% if (ventas != null && !ventas.isEmpty()) { %>
            <table>
                <tr class="title-table">
                    <th colspan="4">VENTAS</th>
                </tr>
                <tr>
                    <th>N#</th>
                    <th>fecha de venta</th>
                    <th>Nombre de vendedor</th>
                    <th>Acciones</th>
                </tr>
                <%-- Recorrer la lista de usuarios y mostrar sus detalles --%>
                <% for (VentaVo venta : ventas) { %>
                    <tr>
                        <td><%= venta.getIdVenta() %></td>
                        <td><%= venta.getFechaVenta() %></td>
                        <% for (UsuarioVo usuario : usuarios) { %>
                            <% if (usuario.getIdUsuario() == venta.getIdUsuario()) { %>
                                <td><%= usuario.getNombre() %></td>
                            <% } %>
                        <% } %>

                        <td class="iconCenter">
                            <button style="color: #0eb1de;">
                                <a href="Vent?enviar=consultsVentEp&idVenta=<%= venta.getIdVenta() %>">Más Info.</a>
                            </button>
                        </td>
                    </tr>
                <% } %>                
                <% } %>
            </table>
            <% } else { %>
                <p>No se encontraron ventas.</p>
            <% } %>
        </div>
    </div>
            <!-- Declaración de la variable mensaje que se trae desde el controlador "Vent"-->
            <% String mensajeInventario = (String) request.getAttribute("mensajeInventario"); %> 
            <% if (mensajeInventario == null) {%>
                <div></div>
            <%}else{%>
                <div class="mensajeInventario" id="mensajeInventario"></div>
            <%}%>



            <!-- Declaración de la variable mensaje que se trae desde el controlador "ControllerInline"-->
            <% String mensaje1 = (String) request.getAttribute("mensaje1"); %> 

            <!-- Campo para mostrar el mensaje traido desde Java -->
            <% if (mensaje1 == null) {%>
                <div></div>
            <%}else{%>
                <div id="mensaje1"></div>
            <%}%>
</div>

</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<script>
    let mensajeJS="<%= mensaje1 %>"
    let mensajeInventario="<%= mensajeInventario %>"


let mensajeInvent = document.getElementById("mensajeInventario");
if(mensajeInventario==" " || mensajeInventario==null || mensajeInventario=="null"){

    console.log(mensajeInventario+"es nulo")
}else{
    if(mensajeInvent!=null){
        mensajeInvent.style.opacity="1"
        mensajeInvent.textContent=mensajeInventario

        setTimeout(()=>{
            mensajeInvent.style.opacity="0"
            mensajeInvent.textContent=""
        }, 5000)
    }
}

let mensajeVenta = document.getElementById("mensaje1");
if(mensajeJS==" " || mensajeJS==null){

    console.log(mensajeJS+"es nulo")
}else{
    if(mensajeVenta!=null){
        mensajeVenta.style.visibility="visible"
        mensajeVenta.style.opacity="1"
        mensajeVenta.textContent=mensajeJS

        setTimeout(()=>{
            
            mensajeVenta.style.visibility="hidden"
            mensajeVenta.style.opacity="0"
            mensajeVenta.textContent=""
        },3000)
    }

}
</script>
<script src="assets/js/JsVent/indexVent.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    request.setAttribute("mensaje3", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
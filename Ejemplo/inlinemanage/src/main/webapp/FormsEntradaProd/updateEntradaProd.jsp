<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>

<%-- Importar la clase UsuarioVo y UsuarioDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.EntradaVo"%>
<%@ page import="model.EntradaDao"%>
<%@ page import="model.ProveedorVo" %>
<%@ page import="model.ProveedorDao" %>

<main class="main" id="mainForm">  
    <div>
        <a href="ControllerInline?enviar=entrada"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br>
    
    <%-- Obtener el id del producto seleccionado de la URL --%>
    <% String entradaId = request.getParameter("idEntradaProd"); %>
    <% int id = Integer.parseInt(entradaId); %>
    <% EntradaVo entrada = null;
    try {
        entrada = new EntradaDao().obtenerEntradaPorId(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>

    <%-- Verificar si se encontró el usuario y mostrar el formulario de actualización --%>
    <% if (entrada != null) { %>
    <form action="ControllerInline" method="post" id="formValidacion">
        <h1 class="title-table">Actualizacion de entrada de producto</h1>

        <input type="hidden" name="idEntradaProd" id="idEntradaProd" value="<%= entrada.getIdEntradaProd() %>">

        <div class="contentForm">
    
            <div class="divFechaIngreso">
                <label for="UpdateFecha">Fecha de Ingreso:</label>
                <input
                  type="date"
                  id="UpdateFecha"
                  name="UpdateFecha"
                  class="inputForm"
                  value="<%= entrada.getFechaIngreso().toLocalDate() %>"
                />
                <span class="fbForm"></span>
              </div>

              <% List<ProveedorVo> provs = null;
                try {
                    provs = new ProveedorDao().listarProv();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>

            <div class="divProveedor">
                <label for="UpdateIdProveedor">Proveedor:</label>
                <select id="UpdateIdProveedor" name="UpdateIdProveedor" class="inputForm">
                    <option value="" disabled selected><%= entrada.getIdProveedor() %></option>
                    <% for (ProveedorVo proveedor : provs) { %>
                        <option value="<%= proveedor.getIdProveedor() %>"><%= proveedor.getNombreProveedor() %></option>
                        <% } %>
                </select>
                <span class="fbForm"></span>
            </div>

    
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="updateEntrada">Actualizar</button>
            </div>
        </div>
    </form>
    <% } else { %>
        <p>No se encontró el usuario.</p>
    <% } %>
</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<script src=""></script>

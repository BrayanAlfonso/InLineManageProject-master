<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %> <%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProveedorVo" %>
<%@ page import="model.ProveedorDao" %>


<main class="main" id="mainForm">
  <div>
    <a href="entrada?enviar=entrada"
      ><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"
    /></a>
  </div>
  <br />

  <form action="entrada" method="post" id="formValidacion">
    <h1 class="title-table">Registro de entrada</h1>
    <div class="contentForm">

      <div class="divFechaIngreso">
        <label for="fechaIngreso">Fecha de Ingreso:</label>
        <input
          type="date"
          id="fechaIngreso"
          name="fechaIngreso"
          class="inputForm"
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
        <label for="proveedor">Proveedor:</label>
        <select id="idProveedor" name="idProveedor" class="inputForm">
            <option value="" disabled selected>-- Seleccione un proveedor --</option>
            <% for (ProveedorVo proveedor : provs) { %>
                <option value="<%= proveedor.getIdProveedor() %>"><%= proveedor.getNombreProveedor() %></option>
                <% } %>
        </select>
        <span class="fbForm"></span>
    </div>


      <div class="divBtnForm">
        <button class="btnForm" name="enviar" value="registerEntrada">
          Registrar
        </button>
      </div>

    </div>
  </form>
</main>
<%@ include file="../plantillas/footer.jsp"%>
<script src="assets/js/JsCate/registerCate.js"></script>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ExistenciaVo"%>
<%@ page import="model.ExistenciaDao"%>

<main class="main">  
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="ControllerInline?enviar=main"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btnMenu" ><a href="ControllerInline?enviar=registerExistence">Agregar</a></button>
            <button class="btnMenu" ><a href="">Categoria</a></button>
            <input type="text" placeholder="buscar" class="inputSearch">
        </div>
        <div class="content2">

            <h1>Listado de existencias</h1>
        
            <%List <ExistenciaVo> existencias = null;
            try {
                existencias = new ExistenciaDao().listarExist();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        
            <%-- Verificar si hay existencias y mostrarlos --%>
            <%if (existencias != null && !existencias.isEmpty()) {%>
                <table class="<%=(existencias.size() > 7) ? "" : "few-rows"%>">
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
                            <td class="iconCenter"><a href="ControllerInline?enviar=updateExistence&idExistencia=<%= existencia.getIdExistencia() %>"><img src="https://img.icons8.com/ios/100/000000/refresh--v1.png" alt="refresh--v1" class="iconUpdate"/></a></td>
                            <td class="iconCenter"><a href="ControllerInline?enviar=deleteExistence&idExistencia=<%= existencia.getIdExistencia() %>"><img height="30" src="https://img.icons8.com/ios/100/000000/delete--v1.png" alt="delete--v1" class="iconDelete"/></a></td>
                        </tr>
                    <%}%>
                </table>
            <%} else{%>
                <p>No se encontraron Existencias.</p>
            <%}%>
    </div>


</div>
<div class="form">
    
</div>
</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>

<%@ include file="../plantillas/footer2.jsp"%>
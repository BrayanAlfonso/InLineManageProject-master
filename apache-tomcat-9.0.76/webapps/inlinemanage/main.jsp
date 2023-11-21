
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ include file="plantillas/header.jsp"%>

<main>

<div class="buttons">
    <div class="row-buttons">
        
        <div class="Button">
            <a href="User?enviar=user">
            <h1 style="color: black;">Usuarios</h1>
            <i class="fa-solid fa-users" style="font-size: 100px; margin-top: 10px; color: #2d8c94;"></i>
            </a>
        </div>

        <div class="Button">
            <a href="Product?enviar=product">
            <h1 style="color: black;">Productos</h1>
            <i class="fa-solid fa-boxes-stacked" style="font-size: 100px; margin-top: 10px; color: #2d8c94;"></i>
            </a>
        </div>
    </div>

    <div class="row-buttons">
        <div class="Button">
            <a href="Supplier?enviar=supplier">
            <h1 style="color: black;">Proveedores</h1>
            <i class="fa-solid fa-user-tie" style="font-size: 100px; margin-top: 10px; color: #2d8c94;"></i>
            </a>
        </div>

        <div class="Button">
            <a href="Vent?enviar=vent">
            <h1 style="color: black;">Ventas</h1>
            <i class="fa-solid fa-cash-register" style="font-size: 100px; margin-top: 10px; color: #2d8c94;"></i>
            </a>
        </div>
    </div>
</div>
<div class="container-table">
    <table>
        <tr class="title-table">
            <th colspan="3">Ultimas acciones</th>
        </tr>
        <tr>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Accion realizada</th>
        </tr>
        <tr>
            <td>Fecha</td>
            <td>Hora</td>
            <td>Accion realizada</td>
        </tr>

        <tr>
            <td>Fecha</td>
            <td>Hora</td>
            <td>Accion realizada</td>
        </tr>

        <tr>
            <td>Fecha</td>
            <td>Hora</td>
            <td>Accion realizada</td>
        </tr>

        <tr>
            <td>Fecha</td>
            <td>Hora</td>
            <td>Accion realizada</td>
        </tr>

        <tr>
            <td>Fecha</td>
            <td>Hora</td>
            <td>Accion realizada</td>
        </tr>
    </table>

</div>
</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<!-- Si necesitan un archivo js especifico ira aqui -->
<%@ include file="../plantillas/footer2.jsp"%>
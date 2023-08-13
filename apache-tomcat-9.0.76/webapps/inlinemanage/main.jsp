
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%@ include file="plantillas/header.jsp"%>

<main>

<div class="buttons">
    <div class="row-buttons">
        
        <div class="Button">
            <a href="ControllerInline?enviar=user">
            <h1>Usuarios</h1>
            <img width="122" height="122" src="https://img.icons8.com/ios/50/user--v1.png" alt="user--v1"/></a>
            <div>
                <a  href="https://icons8.com/icon/23264/usuario">Usuario</a> icon by <a href="https://icons8.com">Icons8</a>
            </div>
        </div>

        <div class="Button">
            <a href="ControllerInline?enviar=product">
            <h1>Productos</h1>
            <img width="122" height="122" src="https://img.icons8.com/ios/50/product--v1.png" alt="product--v1"/></a>
            <div>
                <a  href="https://icons8.com/icon/12091/producto">Producto</a> icon by <a href="https://icons8.com">Icons8</a>
            </div>
        </div>
    </div>

    <div class="row-buttons">
        <div class="Button">
            <a href="ControllerInline?enviar=supplier">
            <h1>Proveedores</h1>
            <img width="122" height="122" src="https://img.icons8.com/ios/50/supplier.png" alt="supplier"/></a>
            <div>
                <a  href="https://icons8.com/icon/61849/proveedor">Proveedor</a> icon by <a href="https://icons8.com">Icons8</a>
            </div>
        </div>

        <div class="Button">
            <a href="ControllerInline?enviar=vent">
            <h1>Ventas</h1>
            <img width="122" height="122" src="https://img.icons8.com/ios/50/total-sales-1.png" alt="total-sales-1"/></a>
            <div>
                <a  href="https://icons8.com/icon/70641/ventas">Ventas</a> icon by <a href="https://icons8.com">Icons8</a>
            </div>
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
//Eventos paraaccionar el formulario de registro de usuarios
let form= document.querySelector(".form")
let btnInsertUser=document.getElementById("btnInsertUser");

btnInsertUser.addEventListener("click", ()=>{
    form.innerHTML=`<form action="ControllerInline" method="post">
    <h1 class="title-table">Registro de usuarios</h1>
    <div class="contentForm">
        <div class="divDocumentType">
            <label for="documentType">Tipo de documento:</label><br>
            <select name="documentType" id="documentType">
                <option value="CC">CC</option>
                <option value="TI">TI</option>
            </select>
        </div>

        <div class="divNoDocument">
            <label for="noDocument">Numero de documento:</label>
            <input type="text" id="noDocument" name="noDocument" class="inputForm">
        </div>

        <div class="divName">
            <label for="name">Nombre:</label>
            <input type="text" id="name" name="name" class="inputForm">
        </div>

        <div class="divLastName">
            <label for="lastName">Apellido:</label>
            <input type="text" id="lastName" name="lastName" class="inputForm">
        </div>

        <div class="divEmail">
            <label for="email">Correo:</label>
            <input type="email" id="email" name="email" class="inputForm">
        </div>

        <div class="divPassword">
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" class="inputForm">
        </div>

        <div class="divRol">
            <label for="rol">Rol</label><br>
            <select name="rol" id="rol">
                <option value="1">Administrador</option>
                <option value="2">Empleado</option>
            </select>
        </div>
        <div class="divBtnForm">
            <button class="btnForm" name="enviar" value="registerUser">Registrar</button>
        </div>
    </div>
</form>`

    form.style.border = "1px solid black";
})





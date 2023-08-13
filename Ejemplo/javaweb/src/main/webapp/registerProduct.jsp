<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de productos</title>
</head>
<body>
    <form action="JavaWeb" method="post">
        
        <h4 class="text-secondary">BrTechnology</h4>
        <h1 class="h5 mb-3 fw-normal">Registro de productos</h1>
        <div class="form-floating">
        <label for="name_product">Nombre de producto:</label>
        <input type="text" class="form-control" id="floatingInput" id="name_product" name="name_product" placeholder="Ingrese los nombres de los productos" required autofocus>
        </div>

        <div class="form-floating">

        <label for="value_product">Precio del producto:</label>
        <input type="text" class="form-control" id="value_product" name="value_product" placeholder="Ingrese el precio del producto" required >
        </div>

        <div class="form-floating">

        <label for="id_categoria">Id Categoria:</label>
        <input type="text" class="form-control"  id="id_category" name="id_category" placeholder="Ingrese la categoria" required>
        </div>

        <button class="btn btn-primary" type="submit" name="enviar" value="registerProduct">Enviar</button>

    </form>
</body>
</html>
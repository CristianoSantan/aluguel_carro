<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!doctype html>
<html lang="pt-br">

<head>
    <title>Booki | Cadastro autor</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.0-beta1 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    <link rel="stylesheet" href="./css/style.css">
</head>

<body>


    <div class="main">
        <nav class="navbar navbar-expand-md navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="../../index.html">
                    Booki
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a href="../autores/index.html" class="nav-link text-dark ">
                                Autores
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../editoras/index.html" class="nav-link text-dark">
                                Editoras
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../livros/index.html" class="nav-link text-dark">
                                Livros
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="tag">
            <h1 class="container">Cadastrar autor</h1>
        </header>

        <div class="container py-3">
            <form action="./clientes-update" >
                <fieldset>
                    <legend>
                        <h2 class="text-center">Criar</h2>
                    </legend>
                    <div class="form-group mb-3">
                        <label for="nome" class="form-label">
                            Nome
                        </label>
                        <input type="text" id="nome" name="nome" class="form-control" placeholder="nome" 
                        value="<%=request.getAttribute("nome") %>" />
                    </div>
                    <div class="form-group mb-3">
                        <label for="cidade" class="form-label">
                            cidade
                        </label>
                        <input type="text" id="cidade" name="cidade" class="form-control" placeholder="cidade" 
                        value="<%=request.getAttribute("cidade") %>" />
                    </div>
                    <div class="form-group mb-3">
                        <label for="cpf" class="form-label">
                            cpf
                        </label>
                        <input type="text" id="cpf" name="cpf" class="form-control" placeholder="cpf" 
                        value="<%=request.getAttribute("cpf") %>" />
                    </div>

                    <button type="submit" class="btn btn-primary">
                        Enviar
                    </button>
                    <a href="./clientes" class="btn btn-danger" style="margin-left: 10px">
                        Cancelar
                    </a>
                </fieldset>
            </form>
        </div>


        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
            integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
            integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
            crossorigin="anonymous"></script>
</body>

</html>
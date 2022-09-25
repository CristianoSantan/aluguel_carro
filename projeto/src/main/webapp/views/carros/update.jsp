<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!doctype html>
<html lang="pt-br">

<head>
    <title>Atualizar carro</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.0-beta1 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">

    <link rel="stylesheet" href="./css/style.css">
</head>

<body>


    <div class="main">
        <nav class="navbar navbar-expand-md navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="../../index.jsp">
                    Aluguel Carro
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                             <a href="./clientes" class="nav-link text-dark ">
	                            clientes
	                        </a>
	                    </li>
	                    <li class="nav-item">
	                        <a href="./carros" class="nav-link text-dark">
	                            Carros
	                        </a>
	                    </li>
	                    <li class="nav-item">
	                        <a href="./aluga" class="nav-link text-dark">
	                            Aluguel
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="tag">
            <h1 class="container">Atualizar carro</h1>
        </header>

        <div class="container py-3">
            <form action="./carros-update" >
                <fieldset>
                    <legend>Criar
                    </legend>
                    <div class="form-group mb-3">
                        <label for="id" class="form-label">
                            Id
                        </label>
                        <input type="text" id="id" name="id" class="form-control" placeholder="id" 
                        value="<%=request.getAttribute("id") %>" readonly />
                    </div>
                    <div class="form-group mb-3">
                        <label for="modelo" class="form-label">
                            Modelo
                        </label>
                        <input type="text" id="modelo" name="modelo" class="form-control" placeholder="modelo" 
                        value="<%=request.getAttribute("modelo") %>" />
                    </div>
                    <div class="form-group mb-3">
                        <label for="placa" class="form-label">
                            Placa
                        </label>
                        <input type="text" id="placa" name="placa" class="form-control" placeholder="placa" 
                        value="<%=request.getAttribute("placa") %>" />
                    </div>
                    <div class="form-group mb-3">
                        <label for="valor" class="form-label">
                            Valor Aluguel
                        </label>
                        <input type="text" id="valor" name="valor" class="form-control" placeholder="valor" 
                        value="<%=request.getAttribute("valor") %>" />
                    </div>

                    <button type="submit" class="btn btn-primary">
                        Enviar
                    </button>
                    <a href="./carros" class="btn btn-danger" style="margin-left: 10px">
                        Cancelar
                    </a>
                </fieldset>
            </form>
        </div>
</div>

        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"></script>
</body>

</html>
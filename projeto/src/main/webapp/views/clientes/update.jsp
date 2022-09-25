<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!doctype html>
<html lang="pt-br">

<head>
    <title>Atualizar cliente</title>
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
            <h1 class="container">Atualizar cliente</h1>
        </header>

        <div class="container py-3">
            <form action="./clientes-update" >
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
</div>

        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"></script>
</body>

</html>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.Cliente"
    import="model.Carro"
    import="java.util.List"
%>

<%

@SuppressWarnings("unchecked")
List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");

@SuppressWarnings("unchecked")
List<Carro> carros = (List<Carro>) request.getAttribute("carros");

%>

<!doctype html>
<html lang="pt-br">

<head>
    <title>Alugar um carro</title>
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
                <a class="navbar-brand" href="./index.jsp">
                    Aluguel de carro
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
            <h1 class="container">Cadastrar autor</h1>
        </header>

        <div class="container py-3">
            <form action="./aluga-create">
                <fieldset>
                    <legend>Criar
                    </legend>
                    <div class="form-group mb-3">
                        <label for="retirada" class="form-label">
                            Dia da retirada
                        </label>
                        <input type="text" id="retirada" name="retirada" class="form-control" placeholder="retirada" value="" />
                    </div>
                    <div class="form-group mb-3">
                        <label for="devolucao" class="form-label">
                            Dia de devolução
                        </label>
                        <input type="text" id="devolucao" name="devolucao" class="form-control" placeholder="devolucao" value="" />
                    </div>
                     <div class="form-group mb-3">
	                    <label for="cliente" class="form-label">
	                        Cliente
	                    </label>
	                    <select id="cliente" name="cliente" class="form-select">
	                        <option value="DEFAULT">Escolha um cliente</option>
	                        <% for (Cliente c: clientes) { %>
	                        <option value="<%=c.getId() %>"><%=c.getNome() %></option>
	                        <% } %>
                        </select>
                	</div>
                	
                	<div class="form-group mb-3">
	                    <label for="carro" class="form-label">
	                        Carro
	                    </label>
	                    <select id="carro" name="carro" class="form-select">
	                        <option value="DEFAULT">Escolha um carro</option>
	                        <% for (Carro c: carros) { %>
	                        <option value="<%=c.getId() %>"><%=c.getModelo() %></option>
	                        <% } %>
                        </select>
                	</div>

                    <button type="submit" class="btn btn-primary">
                        Enviar
                    </button>
                    <a href="./aluga" class="btn btn-danger" style="margin-left: 10px">
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
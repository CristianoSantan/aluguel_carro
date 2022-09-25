<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.Carro"
    import="java.util.List"
%>

<%

@SuppressWarnings("unchecked")
List<Carro> carros = (List<Carro>) request.getAttribute("carros");

%>


<!doctype html>
<html lang="pt-br">
  <head>
    <title>Carros</title>
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
	                aluguel carro
	            </a>
	            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
	                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	            <div class="collapse navbar-collapse" id="navbarNav">
	                <ul class="navbar-nav">
	                    <li class="nav-item">
	                        <a href="./clientes" class="nav-link text-dark ">
	                            Clientes
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
	        <h1 class="container">Carros</h1>
	    </header>
	
	    <div class="container py-3">
	        <a href="./views/carros/create.html" class="btn btn-primary mb-2">
	            Criar carro
	        </a>
	        <div class="table-responsive">
	            <table class="table">
	                <thead>
	                    <tr>
	                        <th>Id</th>
	                        <th>Modelo</th>
	                        <th>Placa</th>
	                        <th>Valor aluguel</th>
	                        <th>Ações</th>
	                    </tr>
	                </thead>
	                <tbody>
	   
	                <% for (Carro c: carros) { %>
	                    <tr>
	                        <td><%=c.getId() %></td>
	                        <td><%=c.getModelo() %></td>
	                        <td><%=c.getPlaca() %></td>
	                        <td><%=c.getValor() %></td>
	                        <td class="d-flex">
	                            <a href="./carros-edit?id=<%=c.getId() %>" class="btn btn-info">
	                                Editar
	                            </a>
	                            <a href="./carros-delet?id=<%=c.getId() %>" class="btn btn-danger" style="margin-left: 10px;">
	                                Deletar
	                            </a>
	                        </td>
	                    </tr>
	                  <% } %>
	                  
	                  </tbody>
	            </table>
	        </div>
	    </div>
	</div>

    
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"></script>
  </body>
</html>
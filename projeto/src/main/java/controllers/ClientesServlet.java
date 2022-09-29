package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet(urlPatterns = { "/clientes", "/clientes-create", "/clientes-edit", "/clientes-update", "/clientes-delet" })
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClienteDAO clienteDAO = new ClienteDAO();
	Cliente cliente = new Cliente();

	public ClientesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/clientes":
			read(request, response);
			break;
		case "/clientes-create":
			create(request, response);
			break;
		case "/clientes-edit":
			edit(request, response);
			break;
		case "/clientes-update":
			update(request, response);
			break;
		case "/clientes-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> lista;
		
		String filtro = request.getParameter("filtro");
		String busca = request.getParameter("busca");
		
		if ((filtro == null || busca == null) || filtro.equals("DEFAULT")) {
			 lista = clienteDAO.getCliente();
		} else {
			lista = clienteDAO.getFiltro(filtro, busca);
		}
		request.setAttribute("clientes", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/clientes/index.jsp");
		rd.forward(request, response);
	}


	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		cliente.setNome(request.getParameter("nome"));
		cliente.setCidade(request.getParameter("cidade"));
		cliente.setCpf(request.getParameter("cpf"));

		clienteDAO.save(cliente);
		response.sendRedirect("clientes");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		cliente = clienteDAO.getClienteById(id);

		request.setAttribute("id", cliente.getId());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("cidade", cliente.getCidade());
		request.setAttribute("cpf", cliente.getCpf());

		RequestDispatcher rd = request.getRequestDispatcher("./views/clientes/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente.setId(Integer.parseInt(request.getParameter("id")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCidade(request.getParameter("cidade"));
		cliente.setCpf(request.getParameter("cpf"));

		clienteDAO.update(cliente);
		response.sendRedirect("clientes");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		clienteDAO.deleteById(id);
		response.sendRedirect("clientes");
	}

}

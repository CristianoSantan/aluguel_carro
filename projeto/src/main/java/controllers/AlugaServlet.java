package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlugaDAO;
import dao.CarrosDAO;
import dao.ClienteDAO;
import model.Aluga;
import model.Carro;
import model.Cliente;

@WebServlet(urlPatterns = { "/aluga", "/aluga-create", "/pag-create", "/aluga-edit", "/aluga-update", "/aluga-delet" })
public class AlugaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AlugaDAO alugaDAO = new AlugaDAO();
	ClienteDAO clienteDAO = new ClienteDAO();
	CarrosDAO carroDAO = new CarrosDAO();
	Aluga aluga = new Aluga();

	public AlugaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/aluga":
			read(request, response);
			break;
		case "/aluga-create":
			create(request, response);
			break;
		case "/pag-create":
			pagCreate(request, response);
			break;
			/*
		case "/aluga-edit":
			edit(request, response);
			break;
		case "/aluga-update":
			update(request, response);
			break;
			*/
		case "/aluga-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Aluga> lista = alugaDAO.getAluga();

		request.setAttribute("alugueis", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/aluga/index.jsp");
		rd.forward(request, response);
	}
	
	protected void pagCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> clientes = clienteDAO.getCliente();
		request.setAttribute("clientes", clientes);
		
		List<Carro> carros = carroDAO.getCarros();
		request.setAttribute("carros", carros);

		RequestDispatcher rd = request.getRequestDispatcher("./views/aluga/create.jsp");
		rd.forward(request, response);
	}
	
	
	

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente cliente = clienteDAO.getClienteById(Integer.parseInt(request.getParameter("cliente")));
		Carro carro = carroDAO.getCarroById(Integer.parseInt(request.getParameter("carro")));
		 
		String retirada = request.getParameter("retirada");
		String devolucao = request.getParameter("devolucao");
		
		aluga = new Aluga(retirada, devolucao, cliente, carro);
		
		alugaDAO.save(aluga);
		response.sendRedirect("aluga");
	}

	/*
	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		aluga = alugaDAO.getAlugaById(id);

		request.setAttribute("id", aluga.getId());
		request.setAttribute("modelo", aluga.getModelo());
		request.setAttribute("placa", aluga.getPlaca());
		request.setAttribute("valor", aluga.getValor());

		RequestDispatcher rd = request.getRequestDispatcher("./views/aluga/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aluga.setId(Integer.parseInt(request.getParameter("id")));
		aluga.setModelo(request.getParameter("modelo"));
		aluga.setPlaca(request.getParameter("placa"));
		aluga.setValor(Double.parseDouble(request.getParameter("valor")));

		alugaDAO.update(aluga);
		response.sendRedirect("aluga");
	}
	*/
	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		alugaDAO.deleteById(id);
		response.sendRedirect("aluga");
	}

}

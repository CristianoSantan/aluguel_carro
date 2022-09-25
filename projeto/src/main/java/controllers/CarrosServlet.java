package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarrosDAO;
import model.Carro;

@WebServlet(urlPatterns = { "/carros", "/carros-create", "/carros-edit", "/carros-update", "/carros-delet" })
public class CarrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CarrosDAO carrosDAO = new CarrosDAO();
	Carro carro = new Carro();

	public CarrosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/carros":
			read(request, response);
			break;
		case "/carros-create":
			create(request, response);
			break;
		case "/carros-edit":
			edit(request, response);
			break;
		case "/carros-update":
			update(request, response);
			break;
		case "/carros-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Carro> lista = carrosDAO.getCarros();

		request.setAttribute("carros", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/carros/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		carro.setModelo(request.getParameter("modelo"));
		carro.setPlaca(request.getParameter("placa"));
		carro.setValor(Double.parseDouble(request.getParameter("valor")));

		carrosDAO.save(carro);
		response.sendRedirect("carros");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		carro = carrosDAO.getCarroById(id);

		request.setAttribute("id", carro.getId());
		request.setAttribute("modelo", carro.getModelo());
		request.setAttribute("placa", carro.getPlaca());
		request.setAttribute("valor", carro.getValor());

		RequestDispatcher rd = request.getRequestDispatcher("./views/carros/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		carro.setId(Integer.parseInt(request.getParameter("id")));
		carro.setModelo(request.getParameter("modelo"));
		carro.setPlaca(request.getParameter("placa"));
		carro.setValor(Double.parseDouble(request.getParameter("valor")));

		carrosDAO.update(carro);
		response.sendRedirect("carros");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		carrosDAO.deleteById(id);
		response.sendRedirect("carros");
	}

}

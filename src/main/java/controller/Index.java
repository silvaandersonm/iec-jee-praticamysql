package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CategoriaService;
import model.Categoria;

@WebServlet("/")
public class Index extends HttpServlet{

	@EJB
    private CategoriaService service;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listaCategoria(request, response);					
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

    private void listaCategoria(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Categoria> listaCategoria = service.listar();
		request.setAttribute("listaCategoria", listaCategoria);
		RequestDispatcher dispatcher = request.getRequestDispatcher("inicial.jsp");
		dispatcher.forward(request, response);
	}

}

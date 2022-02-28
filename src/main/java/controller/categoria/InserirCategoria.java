package controller.categoria;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CategoriaService;
import model.Categoria;

@WebServlet("/categoria/inserir")
public class InserirCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private CategoriaService service;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {

		String nome = request.getParameter("nome");

		Categoria categoria = new Categoria();		
		categoria.setNome(nome);		

		try {
			service.inserir(categoria);
			response.sendRedirect("/praticamysql");
		} catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Não foi possível inserir a categoria!</h2>");
			out.print("<br>");
			out.print("<a href = '/praticamysql'>Voltar</a>");
			out.print("</html>");
		}			
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			response.sendRedirect(request.getContextPath() + "/categoria/inserir-categoria.jsp");
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}
	
}

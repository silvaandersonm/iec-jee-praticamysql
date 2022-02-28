package controller.categoria;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CategoriaService;
import model.Categoria;

@WebServlet(urlPatterns = "/categoria/editar")
public class EditarCategoria extends HttpServlet {

    @EJB
    private CategoriaService categoriaService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Integer codigo = Integer.parseInt(request.getParameter("codigo"));
            Categoria categoria = categoriaService.obterPorCodigo(codigo);
            if (categoria == null) {
                PrintWriter out = response.getWriter();
                out.print("<html>");
                out.print("<h2> Não foi possível localizar a categoria de código " + codigo + ".</h2>");
                out.print("<br>");
                out.print("<a href   = '/praticamysql'>Voltar</a>");
                out.print("</html>");
            } else {
                request.setAttribute("categoria", categoria);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editar-categoria.jsp");
                dispatcher.forward(request, response);
            }
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        try {
            Categoria categoria = new Categoria();
            categoria.setCodigo(codigo);
            categoria.setNome(nome);
            categoriaService.editar(categoria);
            response.sendRedirect("/praticamysql");
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    } 

}

package controller.produto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CategoriaService;
import business.ProdutoService;
import model.Categoria;
import model.Produto;

@WebServlet("/produto/inserir")
public class InserirProduto extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ProdutoService produtoService;

	@EJB
    private CategoriaService categoriaService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String nome = request.getParameter("nome");
            Float preco = Float.valueOf(request.getParameter("preco"));
            Integer codigoCategoria = Integer.valueOf(request.getParameter("categoria"));
            Categoria categoria = categoriaService.obterPorCodigo(codigoCategoria);

            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setCategoria(categoria);

			produtoService.inserir(produto);

			response.sendRedirect("/praticamysql");

		} catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Não foi possível inserir o produto!</h2>");
			out.print("<br>");
			out.print("<a href = '/praticamysql'>Voltar</a>");
			out.print("</html>");
		}			
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			List<Categoria> categorias = categoriaService.listar();
			request.setAttribute("categorias", categorias);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/produto/inserir-produto.jsp");
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}
	
}

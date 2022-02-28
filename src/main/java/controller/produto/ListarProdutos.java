package controller.produto;

import java.io.IOException;
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
import model.Produto;

@WebServlet("/produto/listar")
public class ListarProdutos extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@EJB
	private ProdutoService produtoService;

	@EJB
    private CategoriaService categoriaService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String nome = request.getParameter("nome");
            List<Produto> produtos = produtoService.listarPorNome(nome);
			request.setAttribute("produtos", produtos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listar-produtos.jsp");
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}			
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Integer codigoCategoria = Integer.parseInt(request.getParameter("categoria"));
            List<Produto> produtos = produtoService.listarPorCategoria(codigoCategoria);
			request.setAttribute("produtos", produtos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/produto/listar-produtos.jsp");
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

}

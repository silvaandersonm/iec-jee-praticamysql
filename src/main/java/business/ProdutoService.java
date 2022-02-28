package business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import model.Produto;
import repository.ProdutoRepository;
import repository.RepositorySession;

@Stateless
public class ProdutoService {

    @EJB
    private RepositorySession repository;
    private ProdutoRepository produtoRepository;

    @PostConstruct
    public void initialize() {
        produtoRepository = repository.getProdutoRepository();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void inserir(Produto produto) {
        produtoRepository.inserir(produto);
    }

    public List<Produto> listarPorCategoria(Integer codigoCategoria) {
        return produtoRepository.listarPorCategoria(codigoCategoria);
    }

    public List<Produto> listarPorNome(String nome) {
        return produtoRepository.listarPorNome(nome);
    }
 
}

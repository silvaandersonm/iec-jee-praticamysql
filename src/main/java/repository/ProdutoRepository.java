package repository;

import java.util.List;
import model.Produto;

public interface ProdutoRepository {

    void inserir(Produto produto);

    List<Produto> listarPorCategoria(Integer codigoCategoria);

    List<Produto> listarPorNome(String nome);

}

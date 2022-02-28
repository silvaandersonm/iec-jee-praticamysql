package repository;

import java.util.List;

import model.Categoria;

public interface CategoriaRepository {

    void inserir(Categoria categoria);

    void editar(Categoria categoria) throws Exception;

    void excluir(Integer codigo) throws Exception;

    Categoria obterPorCodigo(Integer codigo) throws Exception;

    List<Categoria> listar();

}

package business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import model.Categoria;
import repository.CategoriaRepository;
import repository.RepositorySession;

@Stateless
public class CategoriaService {

    @EJB
    private RepositorySession repository;
    private CategoriaRepository categoriaRepository;

    @PostConstruct
    public void initialize() {
        categoriaRepository = repository.getCategoriaRepository();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void inserir(Categoria categoria) {
        categoriaRepository.inserir(categoria);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(Categoria categoria) throws Exception {
        categoriaRepository.editar(categoria);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void excluir(Integer codigo) throws Exception {
        categoriaRepository.excluir(codigo);
    }

    public Categoria obterPorCodigo(Integer codigo) throws Exception {
        return categoriaRepository.obterPorCodigo(codigo);
    }

    public List<Categoria> listar() {
        return categoriaRepository.listar();
    }

}

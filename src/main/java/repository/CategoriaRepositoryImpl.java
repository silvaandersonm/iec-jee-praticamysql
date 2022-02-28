package repository;

import java.util.List;
import javax.persistence.EntityManager;
import model.Categoria;

public class CategoriaRepositoryImpl implements CategoriaRepository {

    private EntityManager em;

    public CategoriaRepository setEntityManager(EntityManager em) {
        this.em = em;
        return this;
    }

    @Override
    public void inserir(Categoria categoria) {
        em.persist(categoria);
    }

    @Override
    public void editar(Categoria categoria) throws Exception {
        em.merge(categoria);
    }

    @Override
    public void excluir(Integer codigo) throws Exception {
        var categoria = em.find(Categoria.class, codigo);
        em.remove(categoria);
    }

    @Override
    public Categoria obterPorCodigo(Integer codigo) throws Exception {
        return em.find(Categoria.class, codigo);
    }

    @Override
    public List<Categoria> listar() {
        return em.createQuery("select c from Categoria c order by c.nome", Categoria.class)
            .getResultList();
    }

}

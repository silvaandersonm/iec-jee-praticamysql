package repository;

import java.util.List;
import javax.persistence.EntityManager;

import model.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository {

    private EntityManager em;

    public ProdutoRepository setEntityManager(EntityManager em) {
        this.em = em;
        return this;
    }

    @Override
    public void inserir(Produto produto) {
        em.persist(produto);
    }

    @Override
    public List<Produto> listarPorCategoria(Integer codigoCategoria) {
        return em.createQuery("select p from Produto p " +
                              "where p.categoria.codigo = :codigoCategoria", Produto.class)
                 .setParameter("codigoCategoria", codigoCategoria)
                 .getResultList();
    }

    @Override
    public List<Produto> listarPorNome(String nome) {
        return em.createQuery("select p from Produto p " +
                              "where lower(p.nome) like :nome", Produto.class)
                 .setParameter("nome", nome.toLowerCase() + "%")
                 .getResultList();
    }

}

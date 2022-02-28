package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import java.lang.Float;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;

	@Column(length = 100, nullable=false)
	private String nome;

    @Column(precision=10, scale=2, nullable=false)
    private Float preco;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria", nullable=false)
    private Categoria categoria;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

    public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}

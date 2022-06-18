package br.com.loja.modelo;

import java.util.List;
import java.util.ArrayList;

public class Categoria {
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public Integer getId() {
		return id;
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}
}

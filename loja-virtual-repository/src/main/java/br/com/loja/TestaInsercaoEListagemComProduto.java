package br.com.loja;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelo.Produto;

public class TestaInsercaoEListagemComProduto {
	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("C�moda", "C�moda vertical");
		
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
}
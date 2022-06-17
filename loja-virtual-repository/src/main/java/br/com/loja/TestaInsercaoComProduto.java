package br.com.loja;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelo.Produto;

public class TestaInsercaoComProduto {
	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Cômoda", "Cômoda vertical");
		
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
//			List lista = persistenciaProduto.listar();
		}
	}
}

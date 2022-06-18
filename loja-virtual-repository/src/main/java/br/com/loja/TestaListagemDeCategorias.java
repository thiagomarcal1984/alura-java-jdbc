package br.com.loja;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;

public class TestaListagemDeCategorias {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategoria = categoriaDAO.listarComProdutos();
			listaDeCategoria.stream().forEach(ct -> {
				System.out.println("Categoria:" + ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println("\t" + ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}
}

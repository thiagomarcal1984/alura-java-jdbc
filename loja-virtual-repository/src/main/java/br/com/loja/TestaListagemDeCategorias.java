package br.com.loja;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.modelo.Categoria;

public class TestaListagemDeCategorias {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategoria = categoriaDAO.listar();
			listaDeCategoria.stream().forEach(ct -> System.out.println(ct.getNome()));
		}
	}
}

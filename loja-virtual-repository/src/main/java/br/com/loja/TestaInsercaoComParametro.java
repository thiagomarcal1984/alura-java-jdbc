package br.com.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	
	public static void main(String[] args) throws SQLException {
		String nome = "Mouse'"; 
			// Note que a aspa simples deveria quebrar o SQL.
		String descricao = "Mouse sem fio); delete from Produto;"; 
			// Note o SQL Injection para deletar o que está na tabela Produto.
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement(
				"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?);"
				, Statement.RETURN_GENERATED_KEYS
		);
		
		stm.setString(1, nome); // Primeiro parâmetro da PreparedStatement.
		stm.setString(2, descricao); // Segundo parâmetro da PreparedStatement.
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();

		System.out.println("Número de colunas do ResultSet: " + rst.getMetaData().getColumnCount());
		
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
		
		connection.close();
	}

}

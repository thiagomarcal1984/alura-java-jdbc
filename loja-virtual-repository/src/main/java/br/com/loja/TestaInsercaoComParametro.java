package br.com.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		connection.setAutoCommit(false); // Evita o commit autom�tico das transa��es.

		try {
			PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?);"
					, Statement.RETURN_GENERATED_KEYS
			);
			
			adicionarVariavel("SmartTV", "45 polegadas", stm);
			adicionarVariavel("R�dio", "R�dio de bateria", stm);
			
			connection.commit();
			
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO.");
			connection.rollback();
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm)
			throws SQLException {
		stm.setString(1, nome); // Primeiro par�metro da PreparedStatement.
		stm.setString(2, descricao); // Segundo par�metro da PreparedStatement.
		//*
		if (nome.equals("R�dio")) {
			throw new RuntimeException("N�o foi poss�vel adicionar o produto");
		} //*/
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();

		System.out.println("N�mero de colunas do ResultSet: " + rst.getMetaData().getColumnCount());
		
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
	}

}

package br.com.loja;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute(
				"INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio');"
				, Statement.RETURN_GENERATED_KEYS);
		ResultSet rst = stm.getGeneratedKeys();

		 System.out.println("Número de colunas do ResultSet: " + rst.getMetaData().getColumnCount());
		
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
		
		connection.close();
	}

}

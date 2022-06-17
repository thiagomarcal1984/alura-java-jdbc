package br.com.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args)throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
			/*
			 *  Futuramente a String do SQL poderia ser:
			 *  	"SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE nome = ?"
			 *  
			 *  E poderíamos colocar o parâmetro para filtro:
			 *  	stm.setString(1, "NOTEBOOK");
			 */
		
		stm.execute();
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println(id);
			String nome = rst.getString("nome");
			System.out.println(nome);
			String descricao = rst.getString("descricao");
			System.out.println(descricao);
			System.out.println();
		}
		
		con.close();
	}
}

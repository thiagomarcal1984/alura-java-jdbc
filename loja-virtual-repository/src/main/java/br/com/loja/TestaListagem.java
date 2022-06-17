package br.com.loja;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args)throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexao();
		
		Statement stm = con.createStatement();
		
		boolean resultado = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		System.out.println("O resultado é uma lista (select)? " + resultado);
		
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

package br.com.loja;

import java.sql.SQLException;

public class TestePoolConexoes {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de número: " + i);
			/* O número de conexões será no máximo o configurado no pool em 
			 * ConnectionFactory. Por isso, apenas 15 conexões serão criadas.
			 * Problema: toda vez que o main de TestePoolConexoes, o MySQL vai 
			 * criar 15 novas conexões, além daquelas que já existirem. Tem que
			 * haver um jeito de matar essas conexões depois e reaproveitá-las.
			 * Pra isso, é importante consultar a documentação do C3P0: 
			 * 		https://www.mchange.com/projects/c3p0/ 
			 */
		}
	}
}

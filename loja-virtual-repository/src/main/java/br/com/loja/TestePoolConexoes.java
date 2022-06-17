package br.com.loja;

import java.sql.SQLException;

public class TestePoolConexoes {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conex�o de n�mero: " + i);
			/* O n�mero de conex�es ser� no m�ximo o configurado no pool em 
			 * ConnectionFactory. Por isso, apenas 15 conex�es ser�o criadas.
			 * Problema: toda vez que o main de TestePoolConexoes, o MySQL vai 
			 * criar 15 novas conex�es, al�m daquelas que j� existirem. Tem que
			 * haver um jeito de matar essas conex�es depois e reaproveit�-las.
			 * Pra isso, � importante consultar a documenta��o do C3P0: 
			 * 		https://www.mchange.com/projects/c3p0/ 
			 */
		}
	}
}

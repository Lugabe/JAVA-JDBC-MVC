package javaVirtualRepository;

import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {

		
		ConnectionFactory conexao = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			
		conexao.recupararConexao();
		System.out.println("Conexao de numero: " +i);
		
		}
		
	}

}

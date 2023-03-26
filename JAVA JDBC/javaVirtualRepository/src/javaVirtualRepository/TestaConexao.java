package javaVirtualRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory CriaConexao = new ConnectionFactory();
		Connection connectionFactory= CriaConexao.recupararConexao();
		
		
		System.out.println("Fechando conexão "+ CriaConexao);
		
		connectionFactory.close();
		
		
		
	}

}

package javaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory CriaConexao = new ConnectionFactory();
		Connection connectionFactory = CriaConexao.recupararConexao();

		PreparedStatement stm = connectionFactory.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO ");

		stm.execute();
		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("id");
			System.out.println(id);

			String nome = rst.getString("nome");
			System.out.println(nome);

			String descricao = rst.getString("descricao");
			System.out.println(descricao);

		}

		connectionFactory.close();
		stm.close();

	}

}

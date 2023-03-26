package javaVirtualRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recupararConexao();

		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO(nome,descricao)VALUES('SSD','SSD KINGSTON 2TB')",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet rst = stm.getGeneratedKeys(); // Mostra os ids gerados após inserir os dados

		while (rst.next()) {

			Integer id = rst.getInt(1);
			System.out.println(id);

		}

		connection.close();
	}

}

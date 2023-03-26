package javaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recupararConexao()) {

			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement
					("INSERT INTO PRODUTO(nome,descricao)VALUES(?,?)",Statement.RETURN_GENERATED_KEYS)) {
				AdicionarVariavel("PS5 pro ", "Com 20 jogos", stm);
				AdicionarVariavel("Pc Gamer", "Ryzen 9, Rtx 4090 super, 32GB RAM", stm);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback(); //os 2 produtos precisam ser adicionados ou então acontecerá um rollback
			}
		}

	}

	private static void AdicionarVariavel(String name, String description, PreparedStatement stm) throws SQLException {
		stm.setString(1, name);
		stm.setString(2, description);

		if (name.equals("Smart Tv")) { // passando condiçao da logica de negocios da empresa
			throw new RuntimeException("Não foi possivel adicionar o produto");
		}
		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) { // Mostra os ids gerados após inserir os dados

			while (rst.next()) {

				Integer id = rst.getInt(1);
				System.out.println("Produto adicionado, id: " + id);

			}
		}
	}
}

package javaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connection = new ConnectionFactory();
		Connection delete = connection.recupararConexao();

		PreparedStatement stm = delete.prepareStatement("DELETE FROM PRODUTO WHERE id = ?");
		stm.setInt(1, 2);
		stm.execute();

		Integer linhasModificadas = stm.getUpdateCount(); // mostra as linhas modificadas
		System.out.println("Quantidades de linhas modificadas " + linhasModificadas);

		delete.close();
		stm.close();
	}

}

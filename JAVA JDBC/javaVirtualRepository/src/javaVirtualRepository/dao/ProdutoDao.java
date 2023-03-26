package javaVirtualRepository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaVirtualRepository.modelo.Categoria;
import javaVirtualRepository.modelo.Produto;

public class ProdutoDao {

	private Connection connection;

	public ProdutoDao(Connection connection) {
		this.connection = connection;

	}

	public void salvar(Produto produto) throws SQLException {

		String sql = "INSERT INTO PRODUTO(NAME, DESCRIPTION)VALUES(?,?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getName());
			pstm.setString(2, produto.getDescription());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {

		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT ID, NAME, DESCRIPTION FROM PRODUTO";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getString(3), rst.getString(2), rst.getInt(1));
					produtos.add(produto);
				}

			}
		}
		return produtos;

	}

	public List<Produto> buscar(Categoria ct) throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT ID, NAME, DESCRIPTION FROM PRODUTO WHERE CATEGORIA_ID =?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, ct.getId());
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getString(3), rst.getString(2), rst.getInt(1));
					produtos.add(produto);
				}

			}
		}
		return produtos;

	}
}

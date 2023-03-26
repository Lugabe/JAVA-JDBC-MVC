package javaVirtualRepository.categorias;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javaVirtualRepository.ConnectionFactory;
import javaVirtualRepository.dao.CategoriaDAO;
import javaVirtualRepository.dao.ProdutoDao;
import javaVirtualRepository.modelo.Categoria;
import javaVirtualRepository.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try(Connection connection = new ConnectionFactory().recupararConexao()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria>listaDeCategoria = categoriaDAO.listar();
		
			listaDeCategoria.stream().forEach(ct -> {
				
			System.out.println(ct.getName());
			
			try {
				for (Produto produto : new ProdutoDao(connection).buscar(ct)) {
					System.out.println(ct.getName()+ " - " + produto.getName());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			});
		}
	}

}

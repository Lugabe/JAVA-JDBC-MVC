package javaVirtualRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javaVirtualRepository.dao.ProdutoDao;
import javaVirtualRepository.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Comoda", "Comoda vertical");
		
		try(Connection connection = new ConnectionFactory().recupararConexao()){
			
			ProdutoDao produtoDao = new ProdutoDao(connection);
			produtoDao.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
			
		}
	}

}

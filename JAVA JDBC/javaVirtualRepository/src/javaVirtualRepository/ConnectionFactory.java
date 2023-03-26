package javaVirtualRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory implements AutoCloseable{


	/**
	 * Classe para recuperar conexão com o banco de dados usando login e senha
	 * 
	 */
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("luis4487");
		
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDataSource;
	}
	
	
	public Connection recupararConexao() throws SQLException {
		 return dataSource.getConnection();
		 
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
}

package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	//nome do ususario do MySql
	private static final String USERNAME = "root";
	//senha do banco
	private static final String PASSWORD = "";
	//caminho do banco de dados, porta
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lojas";
	
	/*
	 * *Conexão com o banco de dados
	 */
	
	public static Connection createConnectionToMySQL() throws Exception {
		//fazer com que a classe se carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		//recuperar uma conexão com o banco de dados
		Connection con  = createConnectionToMySQL();
		
		//testar se a conexão e nula
		if (con!=null) {
			System.out.println("Conexão realizada com sucesso!");
			con.close();
		}
	}
}

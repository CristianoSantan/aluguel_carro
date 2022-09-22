package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	
	private static String URL = "jdbc:mysql://localhost:3306/aluguel_carro";
	private static String USUARIO = "root";
	private static String SENHA = "Cris@admin88";

	public static Connection createConnectionMySQL() throws Exception {
		// Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Cria conexão com banco de dados ---------- com senha
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);

		return connection;
	}

}

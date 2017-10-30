package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

private static Connection con;
	
	static{
		open();
	}
	
	private static void open(){
		String url = "jdbc:mysql://localhost:3306/Trabalho";
		String username = "root";
		String password = "jack1405";
		// Vai até o banco de dados e cria uma conexão.
		try {
			con = DriverManager.getConnection(url,
					username, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getCon() {
		try {
			if(con.isClosed()){
				open();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

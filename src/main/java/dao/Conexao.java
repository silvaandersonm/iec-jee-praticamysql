package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {	
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String URL	=  "jdbc:mysql://localhost:3306/IEC_CRUD?useTimezone=true&serverTimezone=UTC";
	private String USER = "user_iec_crud";
	private String SENHA = "user_iec_crud";
	private Connection conn;
	
	public Conexao() {
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}
	
	public void fecharConexao() {
		try {
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

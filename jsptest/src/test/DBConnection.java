package test;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private final String URL="jdbc:oracle:oci:@mesdbtest";
	private final String USER="sajet";
	private final String PASSWORD="study";
	
	private Connection conn=null;
	
	public DBConnection() {
		try {
			Class.forName(DRIVER);
			this.conn = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("�ƾڳs�����\");

		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("�[���X�ʥ���");
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public void close() {
		if(this.conn!=null) {
			try {
				this.conn.close();
			}catch(SQLException e) {
				System.out.println("�ƾڮw�s����������");
			}
		}
	}
}

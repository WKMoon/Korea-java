package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//JDBC: java database connectivity
public class DBConnecter {
	public static Connection getConnection() {
		Connection conn = null;
		//url,id,pw

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "hr";
			String pw = "hr";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 접속 실패");
		}catch(Exception e) {
			System.out.println("getConnection() 알 수 없는 오류");
		}
		return conn;
		
	}

}

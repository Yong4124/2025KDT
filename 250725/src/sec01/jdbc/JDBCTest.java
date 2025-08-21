package sec01.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String id="root";
		String pw="1234";
		String url="jdbc:mysql://localhost:3305/spring5fs";
		Connection con = null;
		String sql = "select * from emp";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("클래스 있다");
		
		con = DriverManager.getConnection(url, id, pw);
		System.out.println("접속 성공!");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		
		System.out.println("사번\t이름\t직무");
		System.out.println("------------------------");
		while (rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			System.out.printf("%d\t%s\t%s\n", empno, ename, job);
		}
		rs.close();
		stmt.close();
		con.close();
		
		
//		try {
//		Class.forName("com.mysql.cj.jdbc.Driver");	
//			System.out.println("클래스 있다");
//		} catch (ClassNotFoundException e) {
//			System.out.println("클래스 없다");
//		}
//		
	}
}

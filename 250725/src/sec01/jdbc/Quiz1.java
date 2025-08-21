package sec01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("sql문 입력> ");
		String sql = scan.nextLine();
		
		String id="root";
		String pw="1234";
		String url="jdbc:mysql://localhost:3305/spring5fs";
		Connection con = null;
		
		String sql1 = "select * from emp";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, id, pw);
		
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql1);
		
		
		
		while (rs.next()) {
			String str1 = rs.getString(1);
			String str2 = rs.getString(2);
			String str3 = rs.getString(3);
			System.out.printf("%-10s\t%-10s\t%s\n", str1, str2, str3);
		}
		rs.close();
		stmt.close();
		con.close();
	}
}

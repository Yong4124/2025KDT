package test1;

import java.util.Properties;

public class PropertiesEx1 {
	
	public static void main(String[] args) {
		// 1. Properties 객체 생성
		Properties props = new Properties();
		
		// 2. 키-값 쌍으로 데이터 설정
		props.setProperty("db.driver", "com.mysql.cj.jdbc.Driver");
		props.setProperty("db.url", "jdbc:mysql://localhost:3306/mydb");
		props.setProperty("db.username", "user");
		props.setProperty("db.password", "password");
		props.setProperty("aaa", "1000");
		
		System.out.println("aaa");
		// 3. 설정된 값 읽어오기
		String driver = props.getProperty("db.diver");
		String url = props.getProperty("db.url");
		
		System.out.println("DB Driver: " + driver);
		System.out.println("DB URL: " + url);
	}

}

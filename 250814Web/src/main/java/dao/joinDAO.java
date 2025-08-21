package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.joinDTO;

public class joinDAO {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	public List<joinDTO> selectList() {  // tiny 테이블의 모든 자료를 가져옴
		List<joinDTO> list = new ArrayList<joinDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM emp natural join dept order by deptno");
		    while (rs.next()) {
		        int empno = rs.getInt("empno");
		        String ename = rs.getString("ename");
		        String job = rs.getString("job");
		        int mgr = rs.getInt("mgr");
		        String hiredate = rs.getString("hiredate");
		        int sal = rs.getInt("sal");
		        int comm = rs.getInt("comm");
		        int deptno = rs.getInt("deptno");
		        String dname =rs.getString("dname");
		        String loc = rs.getString("loc");
		        
		        list.add(new joinDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname, loc));
		    }
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (rs != null) rs.close();
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
		return list;
	}
}

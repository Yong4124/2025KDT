package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.deptDTO;

public class deptDAO {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	public List<deptDTO> selectList() {  // tiny 테이블의 모든 자료를 가져옴
		List<deptDTO> list = new ArrayList<deptDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM dept");
		    while (rs.next()) {
		        int deptno = rs.getInt("deptno");
		        String dname = rs.getString("dname");
		        String loc = rs.getString("loc");
		        list.add(new deptDTO(deptno, dname, loc));
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
	
	public void insertOne(deptDTO dto) {
		Connection conn = null;
		Statement stmt = null;

		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    stmt.executeUpdate(String.format("insert into dept(deptno, dname, loc) values ('%s', '%s', '%s')", dto.getDeptno(), dto.getDname(), dto.getLoc()));
		  
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
	}
	
	public void deleteOne(String deptno) {
		Connection conn = null;
		Statement stmt = null;

		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    stmt.executeUpdate(String.format("delete from dept where deptno = %s", deptno));
		  
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
	}
	
	public deptDTO selectOne(String deptno) {
		deptDTO dto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM dept where deptno = " + deptno);
		    if (rs.next()) {
		        int deptno1 = rs.getInt("deptno");
		        String dname = rs.getString("dname");
		        String loc = rs.getString("loc");
		        dto = new deptDTO(deptno1, dname, loc);
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
		return dto;
	}
	
	public void updateOne(deptDTO dto) {
		Connection conn = null;
		Statement stmt = null;

		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    stmt.executeUpdate(String.format("update dept set dname = '%s', loc = '%s' where deptno = %d", dto.getDname(), dto.getLoc(), dto.getDeptno()));
		  
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
	}
}

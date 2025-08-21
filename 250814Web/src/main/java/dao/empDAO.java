package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.empDTO;

public class empDAO {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	public List<empDTO> selectList() {  // tiny 테이블의 모든 자료를 가져옴
		List<empDTO> list = new ArrayList<empDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM emp");
		    while (rs.next()) {
		        int empno = rs.getInt("empno");
		        String ename = rs.getString("ename");
		        String job = rs.getString("job");
		        int mgr = rs.getInt("mgr");
		        String hiredate = rs.getString("hiredate");
		        int sal = rs.getInt("sal");
		        int comm = rs.getInt("comm");
		        int deptno = rs.getInt("deptno");
		        
		        list.add(new empDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno));
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
	
	public void insertOne(empDTO dto) {
		Connection conn = null;
		Statement stmt = null;

		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    stmt.executeUpdate(String.format("insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno ) values ('%s', '%s', '%s', '%d', '%s', '%d', '%d', '%d')", 
		    		dto.getEmpno(), dto.getEname(), dto.getJob(), dto.getMgr(), dto.getHiredate(), dto.getSal(), dto.getComm(), dto.getDeptno()));
		  
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
	
	public void deleteOne(String empno) {
		Connection conn = null;
		Statement stmt = null;

		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    stmt.executeUpdate(String.format("delete from emp where empno = %s", empno));
		  
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
	
	public empDTO selectOne(String empno) {
		empDTO dto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT empno, ename, job, mgr, to_char(hiredate, 'YYYY-MM-DD') as hiredate, sal, comm, deptno FROM emp where empno = " + empno);
		    if (rs.next()) {
		        int empno1 = rs.getInt("empno");
		        String ename = rs.getString("ename");
		        String job = rs.getString("job");
		        int mgr = rs.getInt("mgr");
		        String hiredate = rs.getString("hiredate");
		        int sal = rs.getInt("sal");
		        int comm = rs.getInt("comm");
		        int deptno = rs.getInt("deptno");
		        dto = new empDTO(empno1, ename, job, mgr, hiredate, sal, comm, deptno);
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
	
	public void updateOne(empDTO dto) {
		Connection conn = null;
		Statement stmt = null;

		try {
		    conn = getConnection();
		    stmt = conn.createStatement();
		    stmt.executeUpdate(String.format("update emp set ename = '%s', job = '%s', mgr = '%d', hiredate = '%s', sal = '%d', comm = '%d', deptno ='%d' where empno = %d",
		    		dto.getEname(), dto.getJob(), dto.getMgr(), dto.getHiredate(), dto.getSal(), dto.getComm(), dto.getDeptno(), dto.getEmpno()));
		  
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

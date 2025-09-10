package quiz;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeptDao {

    private JdbcTemplate jdbcTemplate;

    public DeptDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Dept dept) {
        jdbcTemplate.update(
            "INSERT INTO dept (DEPTNO, DNAME, LOC) VALUES (?, ?, ?)",
            dept.getDeptno(), dept.getDname(), dept.getLoc()
        );
    }

    public List<Dept> selectAll() {
        return jdbcTemplate.query(
            "SELECT * FROM dept",
            (rs, rowNum) -> {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("DEPTNO"));
                dept.setDname(rs.getString("DNAME"));
                dept.setLoc(rs.getString("LOC"));
                return dept;
            }
        );
    }

    public Dept selectByDeptno(int deptno) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM dept WHERE DEPTNO = ?",
            (rs, rowNum) -> {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("DEPTNO"));
                dept.setDname(rs.getString("DNAME"));
                dept.setLoc(rs.getString("LOC"));
                return dept;
            },
            deptno
        );
    }
    
    public void update(Dept dept) {
        jdbcTemplate.update(
            "UPDATE dept SET DNAME = ?, LOC = ? WHERE DEPTNO = ?",
            dept.getDname(), dept.getLoc(), dept.getDeptno()
        );
    }

    public void delete(int deptno) {
        jdbcTemplate.update(
            "DELETE FROM dept WHERE DEPTNO = ?",
            deptno
        );
    }
}




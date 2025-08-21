package dto;

public class deptDTO {
	private int deptno;
	private String dname;
	private String loc;
	
	public deptDTO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}
	
	public String getDname() {
		return dname;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "deptDTO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

	
}
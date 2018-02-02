package si.mp.le.emp;

public class Emp {
	
	private int empNo;
	private String empname;
	private int empSal;

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empname=" + empname + ", empSal=" + empSal + "]";
	}
	
}

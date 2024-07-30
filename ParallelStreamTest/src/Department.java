
public class Department {

	private String deptName;
	private String deptBlock;
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptBlock() {
		return deptBlock;
	}
	public void setDeptBlock(String deptBlock) {
		this.deptBlock = deptBlock;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptBlock=" + deptBlock + "]";
	}
	
}

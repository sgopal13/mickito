import java.util.List;

public class Employee {

	private String name;
	private String addr;
	private List<Department> dept;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public List<Department> getDept() {
		return dept;
	}
	public void setDept(List<Department> dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", addr=" + addr + ", dept=" + dept + "]";
	}


}

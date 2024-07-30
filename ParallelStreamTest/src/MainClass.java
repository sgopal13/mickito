import java.util.ArrayList;
import java.util.List;

public class MainClass {
	
	public static void main(String[] args) {
		
		List<Employee> listEmployee= new ArrayList<>();
		
		Employee employee1=new Employee();
		employee1.setAddr("Mumbai");
		employee1.setName("Raja");
		
		List<Department> dept= new ArrayList<>();
		
		Department department2= new Department();
		department2.setDeptName("IT");
		department2.setDeptBlock("111");
		dept.add(department2);
		
		Department department3= new Department();
		department3.setDeptName("Finance");
		department3.setDeptBlock("222");
		dept.add(department3);
		employee1.setDept(dept);
		
		
		Employee employee11=new Employee();
		employee11.setAddr("Panvel");
		employee11.setName("Rao");
		
		List<Department> dept11= new ArrayList<>();
		
		Department department22= new Department();
		department22.setDeptName("worker");
		department22.setDeptBlock("333");
		dept11.add(department22);
		
		Department department33= new Department();
		department33.setDeptName("plumber");
		department33.setDeptBlock("444");
		dept11.add(department33);
		
		employee11.setDept(dept11);
		
		Employee employee111=new Employee();
		employee111.setAddr("Rabale");
		employee111.setName("Vivek");
		
		List<Department> dept22= new ArrayList<>();
		
		Department department222= new Department();
		department222.setDeptName("electrician");
		department222.setDeptBlock("555");
		dept22.add(department222);
		Department department333= new Department();
		department333.setDeptName("repair");
		department333.setDeptBlock("666");
		dept22.add(department333);
		employee111.setDept(dept22);
		
		
		listEmployee.add(employee111);
		listEmployee.add(employee11);
		listEmployee.add(employee1);
		
		listEmployee.parallelStream().forEach(System.out::println);
		
		System.out.println("=================================================================================");
		
		listEmployee.parallelStream().forEach(e->{
				e.getDept().parallelStream().forEach(d->{
					d.setDeptName(e.getName()+".."+d.getDeptName());
				});
		});
		
		listEmployee.parallelStream().forEach(System.out::println);
	}
}

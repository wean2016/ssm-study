package main.cn.wean2016.crud.entitis;

public class Department {

	private Integer id;
	private String departmentName;

	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(int i, String string) {
		this.id = i;
		this.departmentName = string;
	}

	public Integer getId() {
		return id;
	}

	public Department setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public Department setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
		return this;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName
				+ "]";
	}
	
}

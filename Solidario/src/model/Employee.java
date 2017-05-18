package model;

public class Employee{
	
	private int id;
	private String name;
	private Employee_role role;
	private String pass;
	
	public Employee(int id, String name, Employee_role role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee_role getRole() {
		return role;
	}

	public void setRole(Employee_role role) {
		this.role = role;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
}

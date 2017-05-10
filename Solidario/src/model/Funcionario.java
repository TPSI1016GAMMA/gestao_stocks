package model;

public class Funcionario {
	
	private int id;
	private String name;
	
	public Funcionario(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Funcionario() {
		super();
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
	
	
	

}

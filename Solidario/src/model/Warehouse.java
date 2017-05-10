package model;

public class Warehouse {
	
	private int id;
	private String name;
	private Funcionario responsavel;
	private Estado estado;
	private Products inventory;
	
	public Warehouse(int id, String name, Funcionario responsavel, Estado estado, Products inventory) {
		super();
		this.id = id;
		this.name = name;
		this.responsavel = responsavel;
		this.estado = estado;
		this.inventory = inventory;
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

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Products getInventory() {
		return inventory;
	}

	public void setInventory(Products inventory) {
		this.inventory = inventory;
	}
	
	

}

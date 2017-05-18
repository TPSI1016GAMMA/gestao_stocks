package model;

import java.util.ArrayList;

public class Warehouse {
	
	private int id;
	private String name;
	private Employee responsavel;
	private State state;
	private ArrayList<Products> inventory=new ArrayList<>();
	
	public Warehouse(int id, String name, Employee responsavel, State state, ArrayList<Products> inventory) {
		super();
		this.id = id;
		this.name = name;
		this.responsavel = responsavel;
		this.state = state;
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

	public Employee getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Employee responsavel) {
		this.responsavel = responsavel;
	}

	public State getEstado() {
		return state;
	}

	public void setEstado(State state) {
		this.state = state;
	}

	public ArrayList<Products> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Products> inventory) {
		this.inventory = inventory;
	}
	
	

}

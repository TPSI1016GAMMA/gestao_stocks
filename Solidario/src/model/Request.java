package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Request extends Transaction {
	
	private Warehouse warehouse;
	private ArrayList<Products> products=new ArrayList<>();
	
	public Request(int id, Funcionario funcionario, LocalDate date, Estado estado, Warehouse warehouse,
			ArrayList<Products> products) {
		super(id, funcionario, date, estado);
		this.warehouse = warehouse;
		this.products = products;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public ArrayList<Products> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Products> products) {
		this.products = products;
	}
	
}

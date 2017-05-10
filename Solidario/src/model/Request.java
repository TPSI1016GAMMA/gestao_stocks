package model;

import java.time.LocalDate;

public class Request extends Transaction {
	
	private Warehouse warehouse;
	private Products products;
	
	public Request(int id, Funcionario funcionario, LocalDate date, Estado estado, Warehouse warehouse,
			Products products) {
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

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
}

package model;

import java.time.LocalDate;

public class Supply extends Transaction{
	
	private Request request;
	private Products products;
	
	public Supply(int id, Funcionario funcionario, LocalDate date, Estado estado, Request request, Products products) {
		super(id, funcionario, date, estado);
		this.request = request;
		this.products = products;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
	
	
	
	
	
	
	

}

package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Supply extends Transaction{
	
	private Request request;
	private ArrayList<Products> products=new ArrayList<>();
	
	public Supply(int id, Funcionario funcionario, LocalDate date, Estado estado, Request request, ArrayList<Products> products) {
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

	public ArrayList<Products> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Products> products) {
		this.products = products;
	}
	
	
	
	
	
	
	
	

}

package model;

import java.time.LocalDate;

public class Products {
	
	private Product product;
	private double qtd;
	private LocalDate date;	
	
	
	public Products(Product product, double qtd, LocalDate date) {
		super();
		this.product = product;
		this.qtd = qtd;
		this.date = date;
	}
	
	public Products(Product product, double qtd) {
		super();
		this.product = product;
		this.qtd = qtd;
		this.date = null;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getQtd() {
		return qtd;
	}

	public void setQtd(double qtd) {
		this.qtd = qtd;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}

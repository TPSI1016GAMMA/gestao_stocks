package model;

public class ProductCategory extends BD {
	
	//private int id;
	private String name;
	private ProductCategory parentCat;
	
	public ProductCategory(int id, String name, ProductCategory parentCat) {
		super();
		this.id = id;
		this.name = name;
		this.parentCat = parentCat;
	}
	
	public ProductCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.parentCat = null;
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

	public ProductCategory getParentCat() {
		return parentCat;
	}

	public void setParentCat(ProductCategory parentCat) {
		this.parentCat = parentCat;
	}
	
	
	
}

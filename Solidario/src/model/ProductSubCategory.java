package model;

public class ProductSubCategory extends ProductCategory{

	private int id;
	private String name;
	
	
	public ProductSubCategory(int id, String name, int subId, String subName) {
		super(id, name);
		id = subId;
		name = subName;
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

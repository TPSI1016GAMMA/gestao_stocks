package model;

public class Product extends BD {
		    
	    
	    protected String nome;
	    protected ProductCategory subCat;
	    protected State state;
	    protected BarCode barcode;
	    protected double stock_minimo;
	    
	    public Product(String nome, ProductCategory subCat, State state, BarCode barcode,
				double stock_minimo) {
			super();
			this.nome = nome;
			this.subCat = subCat;
			this.state = state;
			this.barcode = barcode;
			this.stock_minimo = stock_minimo;
		}
	    
	    public Product(int id, String nome) {
			super();
			this.id = id;
			this.nome = nome;
			this.subCat = null;
			this.state = null;
			this.barcode = null;
			this.stock_minimo = 0;
		}
	    
	    public Product() {
			super();		
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public ProductCategory getSubCat() {
			return subCat;
		}

		public void setSubCat(ProductCategory subCat) {
			this.subCat = subCat;
		}

		public State getEstado() {
			return state;
		}

		public void setEstado(State state) {
			this.state = state;
		}

		public BarCode getBarcode() {
			return barcode;
		}

		public void setBarcode(BarCode barcode) {
			this.barcode = barcode;
		}

		public double getStock_minimo() {
			return stock_minimo;
		}

		public void setStock_minimo(double stock_minimo) {
			this.stock_minimo = stock_minimo;
		}
		
		
		/*public String insert(){
			
			String s="INSERT INTO Product VALUES (";
			s+="'"+nome+"', ";
			s+="'"+state.toString()+"', ";
//TODO CATEGORIA PRODUTO
			s+="'"+Double.toString(stock_minimo)+"');";			
			return s;
		}
		
		public String delete(){
			String s="DELETE FROM Product WHERE id='"+id+"';";
			return s;
		}*/
		
	    
	}
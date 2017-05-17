package model;

public class Product {
		    
	    private int id_produto;
	    private String nome;
	    private ProductCategory subCat;
	    private Estado estado;
	    private BarCode barcode;
	    private double stock_minimo;
	    
	    public Product(String nome, ProductCategory subCat, Estado estado, BarCode barcode,
				double stock_minimo) {
			super();
			this.nome = nome;
			this.subCat = subCat;
			this.estado = estado;
			this.barcode = barcode;
			this.stock_minimo = stock_minimo;
		}
	    
	    public Product(int id_produto, String nome) {
			super();
			this.id_produto = id_produto;
			this.nome = nome;
			this.subCat = null;
			this.estado = null;
			this.barcode = null;
			this.stock_minimo = 0;
		}

		public int getId_produto() {
			return id_produto;
		}

		public void setId_produto(int id_produto) {
			this.id_produto = id_produto;
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

		public Estado getEstado() {
			return estado;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
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
	    
	}
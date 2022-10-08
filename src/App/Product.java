package App;

public class Product {
	private String productId;
	private String productName;
	private String productBrand;
	private int productQuantity;
	private double productPricePerUnit;
	private double productPriceTotal;
	private String supplierName;
	
	public String getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public double getProductPricePerUnit() {
		return productPricePerUnit;
	}
	public double getProductPriceTotal() {
		return productPriceTotal;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public void setProductPricePerUnit(double productPricePerUnit) {
		this.productPricePerUnit = productPricePerUnit;
	}
	public void setProductPriceTotal(double productPriceTotal) {
		this.productPriceTotal = productPriceTotal;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
}

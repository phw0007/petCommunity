package com.care.project.shop;

public class CartDTO {
/*
CREATE TABLE project_cart(
no number,
id VARCHAR2(100),
product VARCHAR2(100),
company VARCHAR2(100),
pay number,
image_file VARCHAR2(80),
productId number,
quantity number,
total number
);
*/		
	private int no;
	private String id;
	private String product;
	private String company;
	private String category;
	private int inventory;
	private int pay;
	private String imageFile;
	private int productId;  // 선택한 상품의 아이디
    private int quantity;   // 선택한 상품의 수량
    private int total;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
    
}
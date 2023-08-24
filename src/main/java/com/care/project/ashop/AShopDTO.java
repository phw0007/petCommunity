package com.care.project.ashop;

public class AShopDTO {
/*
CREATE TABLE project_shop(
no number,
category VARCHAR2(60),
name VARCHAR2(100),
company VARCHAR2(100),
pay VARCHAR2(30),
inventory number,
image_file VARCHAR2(80),
info VARCHAR2(500),
primary key(no)
);
*/		
	private int no;
	private String category;
	private String product;
	private String company;
	private int pay;
	private String shopPay;
	private int inventory;
	private String imageFile;
	private String info;
	private String id;
	private String userName;
	private String address;
	private String mobile;
	private String payType;
	private String payCheck;
	private int orderCount;
	private String writeDate;
	private String shippinName;
	private String shippinAddress;
	private String shippinMobile;
	private String shippinMemo;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getShopPay() {
		return shopPay;
	}
	public void setShopPay(String shopPay) {
		this.shopPay = shopPay;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPayCheck() {
		return payCheck;
	}
	public void setPayCheck(String payCheck) {
		this.payCheck = payCheck;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getShippinName() {
		return shippinName;
	}
	public void setShippinName(String shippinName) {
		this.shippinName = shippinName;
	}
	public String getShippinAddress() {
		return shippinAddress;
	}
	public void setShippinAddress(String shippinAddress) {
		this.shippinAddress = shippinAddress;
	}
	public String getShippinMobile() {
		return shippinMobile;
	}
	public void setShippinMobile(String shippinMobile) {
		this.shippinMobile = shippinMobile;
	}
	public String getShippinMemo() {
		return shippinMemo;
	}
	public void setShippinMemo(String shippinMemo) {
		this.shippinMemo = shippinMemo;
	}
	

}
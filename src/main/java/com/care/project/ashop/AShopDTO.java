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
	private String name;
	private String company;
	private String pay;
	private int inventory;
	private String imageFile;
	private String info;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
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

	
}
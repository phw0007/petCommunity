package com.care.project.member;

/*
 *CREATE TABLE project_register(
id varchar2(20),
pw varchar2(20),
user_name varchar2(21),
address varchar2(200),
mobile varchar2(11),
pet_name varchar2(20),
pet_category varchar2(50),
pet_file varchar2(255),
PRIMARY KEY(id)
);
COMMIT; 
 */

public class MemberDTO {
	private String id;
	private String pw;
	private String userName;
	private String address;
	private String mobile;
	private String petName;
	private String petCategory;
	private String petFile;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetCategory() {
		return petCategory;
	}
	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}
	public String getPetFile() {
		return petFile;
	}
	public void setPetFile(String petFile) {
		this.petFile = petFile;
	}
}
	
	
	


package com.care.project.info;

public class InfoDTO {
   /*
   CREATE TABLE project_info(
   no number,
   category VARCHAR2(60),
   name VARCHAR2(100),
   email VARCHAR2(100),
   address VARCHAR2(500),
   mobile VARCHAR2(30),
   primary key(no)
   );
   */   

      private int no;
      private String category;
      private String name;
      private String address;
      private String homePage;
      private String mobile;
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
      public String getAddress() {
         return address;
      }
      public void setAddress(String address) {
         this.address = address;
      }
      public String getHomePage() {
         return homePage;
      }
      public void setHomePage(String homePage) {
         this.homePage = homePage;
      }
      public String getMobile() {
         return mobile;
      }
      public void setMobile(String mobile) {
         this.mobile = mobile;
      }
}
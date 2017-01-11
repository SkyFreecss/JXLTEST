package com.excel;

/**
 * 建立的表的各项属性
 * @author SkyFreecss
 *
 */
public class Games{
       
	   private Integer id;
	   private String name;
	   private String company;
	   private String summary;
	   private String details;
	   private Integer price;
	   private String picture;
	   private String bigpicture;
	   
	   public Games()
	   {
		   
	   }
	   
	   public Games(Integer id,String name,String company,String summary,String details,Integer price,
	String picture,String bigpicture)
	   {
		   this.id = id;
		   this.name = name;
		   this.company = company;
		   this.summary = summary;
		   this.details = details;
		   this.price = price;
		   this.picture = picture;
		   this.bigpicture = bigpicture;
	   }
	   
	   
	   
	@Override
	public String toString() {
		return "Games [id=" + id + ", name=" + name + ", company=" + company + ", summary=" + summary + ", details="
				+ details + ", price=" + price + ", picture=" + picture + ", bigpicture=" + bigpicture + "]";
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getBigpicture() {
		return bigpicture;
	}
	public void setBigpicture(String bigpicture) {
		this.bigpicture = bigpicture;
	}
}

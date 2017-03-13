package com.gui.dto.withtrip;

public class GuideDTO {
	
	private String name, pw, title, country, city, language, content, listimg;
	private int cost,id;
	
	
	public GuideDTO() {
		super();
	}
	
	public GuideDTO(String name, String pw, String title, String country, String city, String language, String content, int cost, int id, String listimg) {
		this.name = name;
		this.pw = pw;
		this.title = title;
		this.country = country;
		this.city = city;
		this.language = language;
		this.content = content;
		this.cost = cost;
		this.id = id;
		this.listimg = listimg;
	}
	
	public GuideDTO(String name, String pw, String title, String country, String city, String language, String content, int cost, int id) {
		this.name = name;
		this.pw = pw;
		this.title = title;
		this.country = country;
		this.city = city;
		this.language = language;
		this.content = content;
		this.cost = cost;
		this.id = id;
		this.listimg = listimg;
	}

	public String getListimg() {
		return listimg;
	}

	public void setListimg(String listimg) {
		this.listimg = listimg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

package com.mem.dto.withtrip;

public class MemDTO {
 
	private String email,pw,name,country,city,sex,hobby;
 
	public MemDTO() {
		super();
	}

	public MemDTO(String email, String pw, String name, String country, String city, String sex, String hobby) {
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.country = country;
		this.city = city;
		this.sex = sex;
		this.hobby = hobby;
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	
	
	
}

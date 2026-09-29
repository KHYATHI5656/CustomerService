package com.alpha.CustomerService.dto;

public class customerdto {
	private String name;
	private long mobile;
	private String email;
	private String gender;
	public customerdto(String name, long mobile, String email, String gender) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
	}
	public customerdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
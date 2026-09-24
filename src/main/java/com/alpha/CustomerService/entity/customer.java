package com.alpha.CustomerService.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class customer {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String name;
	@Column(unique = true)
	private long mobile;
	private String gender;
	private int otp;
	public customer(String name, long mobile, String gender, int otp) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.gender = gender;
		this.otp = otp;
	}
	public customer() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "customer [id=" + id + ", name=" + name + ", mobile=" + mobile + ", gender=" + gender + ", otp=" + otp
				+ "]";
	}
	
}

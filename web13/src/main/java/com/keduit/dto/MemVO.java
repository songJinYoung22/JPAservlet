package com.keduit.dto;

public class MemVO {
	private String name;
	private String id;
	private String pwd;
	private String lev;
	private String phone;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "MemVO [name=" + name + ", id=" + id + ", pwd=" + pwd + ", lev=" + lev + ", phone=" + phone + ", gender="
				+ gender + "]";
	}
	public MemVO(String name, String id, String pwd, String lev, String phone, String gender) {
		
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.lev = lev;
		this.phone = phone;
		this.gender = gender;
	}
	public MemVO() {
	
	}
	
	
}

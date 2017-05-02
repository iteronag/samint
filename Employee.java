package com.domain;

import java.sql.Date;

public class Employee {
	private int enumber;	
	private String ename;
	private Date dob;
	private String gender;
	private String addr1;
	private String addr2;
	private String pobox;
	private String city;
	private String country;
	private String per_mail_id;
	private String designation;
	private int msalary;
	private int cont_number;
	private int alt_cont_number;
	private String status;


	public Employee(
			int enumber,	
			String ename,
			Date dob,
			String gender,
			String addr1,
			String addr2,
			String pobox,
			String city,
			String country,
			String per_mail_id,
			String designation,
			int msalary,
			int cont_number,
			int alt_cont_number,
			String status
			) {
		this.enumber=enumber;	
		this.ename=ename;
		this.dob=dob;
		this.gender=gender;
		this.addr1=addr1;
		this.addr2=addr2;
		this.pobox=pobox;
		this.city=city;
		this.country=country;
		this.per_mail_id=per_mail_id;
		this.designation=designation;
		this.msalary=msalary;
		this.cont_number=cont_number;
		this.alt_cont_number=alt_cont_number;
		this.status=status;		
	}



	@Override
	public String toString() {
		return "Material [ " 
				+ "enumber=" + enumber 	
				+ "ename=" + ename
				+ "dob=" + dob
				+ "gender=" + gender
				+ "addr1=" + addr1
				+ "addr2=" + addr2
				+ "pobox=" + pobox
				+ "city="	+ city
				+ "country=" + country
				+ "per_mail_id=" + per_mail_id
				+ "designation=" +designation
				+ "msalary=" + msalary
				+ "cont_number=" + cont_number
				+ "alt_cont_number=" +alt_cont_number
				+ "status=" + status
				;
	}



	public int getEnumber() {
		return enumber;
	}



	public void setEnumber(int enumber) {
		this.enumber = enumber;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAddr1() {
		return addr1;
	}



	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}



	public String getAddr2() {
		return addr2;
	}



	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}



	public String getPobox() {
		return pobox;
	}



	public void setPobox(String pobox) {
		this.pobox = pobox;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPer_mail_id() {
		return per_mail_id;
	}



	public void setPer_mail_id(String per_mail_id) {
		this.per_mail_id = per_mail_id;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public int getMsalary() {
		return msalary;
	}



	public void setMsalary(int msalary) {
		this.msalary = msalary;
	}



	public int getCont_number() {
		return cont_number;
	}



	public void setCont_number(int cont_number) {
		this.cont_number = cont_number;
	}



	public int getAlt_cont_number() {
		return alt_cont_number;
	}



	public void setAlt_cont_number(int alt_cont_number) {
		this.alt_cont_number = alt_cont_number;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
}

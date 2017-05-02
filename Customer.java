package com.domain;

public class Customer {
	private int cnumber;	
	private String cname;
	private String oname;
	private String addr1;
	private String addr2;
	private String pobox;
	private String city;
	private String country;
	private String currency;
	private String cont_per_name;
	private String phoneno;
	private String mail_id;

	public Customer(
			int cnumber,
			String cname, 
			String oname,
			String addr1, 
			String addr2,
			String pobox,
			String city,
			String country,
			String currency,
			String cont_per_name,			
			String phoneno,
			String mail_id			
			) {
		this.setCnumber(cnumber);
		this.cname = cname;
		this.oname = oname;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.pobox = pobox;
		this.city = city;
		this.country = country;
		this.currency = currency;
		this.cont_per_name = cont_per_name;
		this.phoneno = phoneno;
		this.mail_id = mail_id;
	}

	public String getCName() {
		return cname;
	}

	public void setCName(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", address=" + addr1 + " "+ addr2 + ", phoneno=" + phoneno + "]";
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCont_per_name() {
		return cont_per_name;
	}

	public void setCont_per_name(String cont_per_name) {
		this.cont_per_name = cont_per_name;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public int getCnumber() {
		return cnumber;
	}

	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
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
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}	
}

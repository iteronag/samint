package com.domain;

import java.sql.Date;

public class BBalance {
	public int getBbnumber() {
		return bbnumber;
	}

	public void setBbnumber(int bbnumber) {
		this.bbnumber = bbnumber;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAnumber() {
		return anumber;
	}

	public void setAnumber(String anumber) {
		this.anumber = anumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public int getBbalance() {
		return bbalance;
	}

	public void setBbalance(int bbalance) {
		this.bbalance = bbalance;
	}

	private int bbnumber;
	private String bname;	
	private String anumber;
	private String currency;
	private Date dateOfEntry;
	private int bbalance;
	
	public BBalance(
			int bbnumber,		
			 String bname,
			 String anumber,
			 String currency,
			 Date dateOfEntry,
			 int bbalance
			) {
		 this.bbnumber = bbnumber;		
		 this.bname = bname;
		 this.anumber = anumber;
		 this.currency = currency;
		 this.dateOfEntry = dateOfEntry;
		 this.bbalance = bbalance;
	}

	@Override
	public String toString() {
		return "Material [ " 
				+ "bbnumber=" + bbnumber
				+ "bname=" + bname
				+ "anumber=" + anumber				
				+ "currency=" + currency
				+ " dateOfEntry= " + dateOfEntry
				+ " bbalance = " + bbalance
				;
	}
}

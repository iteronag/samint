package com.domain;

import java.sql.Date;

public class Quotation {
	private int qnumber;
	public int getQnumber() {
		return qnumber;
	}

	public void setQnumber(int qnumber) {
		this.qnumber = qnumber;
	}

	public int getCnumber() {
		return cnumber;
	}

	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}

	public Date getQdate() {
		return qdate;
	}

	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public Date getDdate() {
		return ddate;
	}

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}

	private int cnumber;
	private Date qdate;
	private String remarks;
	private int totalprice;
	private Date ddate;

	public Quotation(
			int qnumber,
			int cnumber,
			Date qdate,
			String remarks,
			int totalprice,
			Date ddate	
			) {
		this.qnumber=qnumber;
		this.cnumber=cnumber;
		this.qdate=qdate;
		this.remarks=remarks;
		this.totalprice=totalprice;
		this.ddate=ddate;		
	}

	@Override
	public String toString() {
		return "Quotation [ " 
+ "qnumber=" + qnumber
+ "cnumber=" + cnumber
+ "qdate=" + qdate
+ "remarks=" + remarks
+ "totalprice=" + totalprice
+ "ddate=" + ddate
				;
	}
}

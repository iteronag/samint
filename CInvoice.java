package com.domain;

import java.sql.Date;

public class CInvoice {
	private int cinumber;
	public int getCinumber() {
		return cinumber;
	}

	public void setCinumber(int cinumber) {
		this.cinumber = cinumber;
	}

	private Date idate;
	public Date getIdate() {
		return idate;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	public int getCnumber() {
		return cnumber;
	}

	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getQref() {
		return qref;
	}

	public void setQref(String qref) {
		this.qref = qref;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getIamount() {
		return iamount;
	}

	public void setIamount(int iamount) {
		this.iamount = iamount;
	}

	public String getPcurrency() {
		return pcurrency;
	}

	public void setPcurrency(String pcurrency) {
		this.pcurrency = pcurrency;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getErate() {
		return erate;
	}

	public void setErate(int erate) {
		this.erate = erate;
	}

	public String getBaccount() {
		return baccount;
	}

	public void setBaccount(String baccount) {
		this.baccount = baccount;
	}

	private int cnumber;
	private String cname;
	private String qref;
	private String currency;
	private int iamount;
	private String pcurrency;
	private String bname;
	private int erate;
	private String baccount;


	public CInvoice(
			int cinumber,
			Date idate,
			int cnumber,
			String cname,
			String qref,
			String currency,
			int iamt,
			String pcurrency,
			String bname,
			int erate,
			String baccount
			) {

		this.cinumber = cinumber;
		this.idate = idate;
		this.cnumber =cnumber;
		this.cname = cname;
		this.qref = qref;
		this.currency = currency;
		this.iamount = iamt;
		this.pcurrency = pcurrency;
		this.bname = bname;
		this.erate = erate;
		this.baccount = baccount;
	}

	@Override
	public String toString() {
		return "CInvoice ["
				+ "cinumber=" +cinumber
				+ "idate=" +idate
				+ "cnumber=" +cnumber
				+ "cname=" +cname
				+ "qref=" +qref
				+ "currency=" +currency
				+ "iamount=" +iamount
				+ "pcurrency=" +pcurrency
				+ "bname=" +bname
				+ "erate=" +erate
				+ "baccount=" +baccount
				+ "]";
	}
}
package com.domain;

public class QuoMaterial {
	private int qmsnumber;
	private int qnumber;
	private int mnumber;
	private int netprice;
	private int quantity;
	private String remarks;

	public QuoMaterial(
			int qmsnumber,
			int qnumber,
			int mnumber,
			int netprice,
			int quantity,
			String remarks	
			) {
		this.qmsnumber=qmsnumber;
		this.qnumber=qnumber;
		this.mnumber=mnumber;
		this.netprice=netprice;
		this.quantity=quantity;
		this.remarks=remarks;			
	}

	@Override
	public String toString() {
		return "Material [ " 
				+ "qmsnumber=" + qmsnumber
				+ " qnumber= " + qnumber
				+ " mnumber= " + mnumber
				+ " netprice = " + netprice
				+ " quantity= " + quantity
				+ " remarks= " + remarks
				;
	}

	public int getQmsnumber() {
		return qmsnumber;
	}

	public void setQmsnumber(int qmsnumber) {
		this.qmsnumber = qmsnumber;
	}

	public int getQnumber() {
		return qnumber;
	}

	public void setQnumber(int qnumber) {
		this.qnumber = qnumber;
	}

	public int getMnumber() {
		return mnumber;
	}

	public void setMnumber(int mnumber) {
		this.mnumber = mnumber;
	}

	public int getNetprice() {
		return netprice;
	}

	public void setNetprice(int netprice) {
		this.netprice = netprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

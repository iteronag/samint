package com.domain;

public class Material {
	private int mnumber;	
	private String mdesc;
	private String attr;
	private String uom;
	private int dprice;
	private int stockInHand;
	private int price;
	private String currency;


	public Material(
			int mnumber,
			String mdesc,
			String attr,
			String uom,
			int dprice,
			int stockInHand,
			int price,
			String currency		
			) {
		this.mnumber = mnumber;
		this.mdesc = mdesc;
		this.attr = attr;
		this.uom = uom;
		this.dprice = dprice;
		this.stockInHand = stockInHand;
		this.price = price;
		this.currency = currency;			

	}



	@Override
	public String toString() {
		return "Material [ " 
				+ "mnumber=" + mnumber
				+ " mdesc= " + mdesc
				+ " attr= " + attr
				+ " uom = " + uom
				+ " dprice= " + dprice
				+ " stockInHand= " + stockInHand
				+ " price= " + price
				+ " currency= " + currency
				;
	}



	public int getMnumber() {
		return mnumber;
	}



	public void setMnumber(int mnumber) {
		this.mnumber = mnumber;
	}



	public String getMdesc() {
		return mdesc;
	}



	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}



	public String getAttr() {
		return attr;
	}



	public void setAttr(String attr) {
		this.attr = attr;
	}



	public String getUom() {
		return uom;
	}



	public void setUom(String uom) {
		this.uom = uom;
	}



	public int getDprice() {
		return dprice;
	}



	public void setDprice(int dprice) {
		this.dprice = dprice;
	}



	public int getStockInHand() {
		return stockInHand;
	}



	public void setStockInHand(int stockInHand) {
		this.stockInHand = stockInHand;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}
}

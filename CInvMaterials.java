package com.domain;

public class CInvMaterials {
	
	private String mdesc;
	private String uom;
	private int dprice;
	private int quantity;
	private int netprice;
	private String remarks;

	public CInvMaterials(
			String mdesc,
			String uom,
			int dprice,
			int quantity,
			int netprice,
			String remarks
			) {
		this.mdesc=mdesc;
		this.uom=uom;
		this.dprice=dprice;
		this.quantity=quantity;
		this.netprice=netprice;
		this.remarks=remarks;
	}

	@Override
	public String toString() {
		return "Material [ " 
				+ "mdesc=" + mdesc
				+ " uom= " + uom
				+ " dprice= " + dprice
				+ " netprice = " + netprice
				+ " quantity= " + quantity
				+ " remarks= " + remarks
				;
	}

	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
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

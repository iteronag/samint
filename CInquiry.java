package com.domain;

import java.sql.Date;

public class CInquiry {
	
	private int inumber;
	
	public int getInumber() {
		return inumber;
	}

	public void setInumber(int inumber) {
		this.inumber = inumber;
	}

	private int customerid;
	private Date inqdate;
	private String segments;
	private String inqdesc;
	private int mid;
	private String mdesc;
	private int marketersid;
	private String mname;
	private int marketersmid;
	private String mmname;
	private Date nextVDate;
	private String remarks;
	

	public CInquiry(
			 int inumber,
			 int customerid,
			 int mid,
			 String mdesc,	
			 int marketersid,
			 String mname,
			 String mmname,
			 int marketersmid,
			 Date nextVDate,
			 String remarks,
			 String inqdesc,
			 String segments,
			 Date inqdate
			) {
		this.inumber=inumber;
		this.customerid=customerid;
		this.inqdate=inqdate;
		this.segments=segments;
		this.inqdesc=inqdesc;
		this.mid=mid;
		this.mdesc=mdesc;
		this.marketersid=marketersid;
		this.mname=mname;
		this.marketersmid=marketersmid;
		this.mmname=mmname;
		this.nextVDate=nextVDate;
		this.remarks=remarks;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public Date getInqdate() {
		return inqdate;
	}

	public void setInqdate(Date inqdate) {
		this.inqdate = inqdate;
	}

	public String getSegments() {
		return segments;
	}

	public void setSegments(String segments) {
		this.segments = segments;
	}

	public String getInqdesc() {
		return inqdesc;
	}

	public void setInqdesc(String inqdesc) {
		this.inqdesc = inqdesc;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}

	public int getMarketersid() {
		return marketersid;
	}

	public void setMarketersid(int marketersid) {
		this.marketersid = marketersid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMarketersmid() {
		return marketersmid;
	}

	public void setMarketersmid(int marketersmid) {
		this.marketersmid = marketersmid;
	}

	public String getMmname() {
		return mmname;
	}

	public void setMmname(String mmname) {
		this.mmname = mmname;
	}

	public Date getNextVDate() {
		return nextVDate;
	}

	public void setNextVDate(Date nextVDate) {
		this.nextVDate = nextVDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "CInquiry [" 
				+ "customerid=" + customerid
				+ "inqdate=" 	  + inqdate
				+ "segments="	  + segments
				+ "inqdesc="	  + inqdesc
				+ "mid="		  + mid
				+ "mdesc="	  + mdesc
				+ "marketersid=" + marketersid 
				+ "mname="		 + mname
				+ "marketersmid=" + marketersmid
				+ "mmname=" + mmname 
				+ "nextVDate="	+ nextVDate
				+ "remarks="	+ remarks
				+	"]";
	}
}

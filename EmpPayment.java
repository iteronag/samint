package com.domain;

public class EmpPayment {
	private int epnumber;
	private String year;	
	private String month;
	private int empno;
	private int advamt;
	private int expenses;
	private int balamt;
	private String remarks;
	private String ename;
	private int msalary;


	public int getMsalary() {
		return msalary;
	}

	public void setMsalary(int msalary) {
		this.msalary = msalary;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEpnumber() {
		return epnumber;
	}

	public void setEpnumber(int epnumber) {
		this.epnumber = epnumber;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getAdvamt() {
		return advamt;
	}

	public void setAdvamt(int advamt) {
		this.advamt = advamt;
	}

	public int getExpenses() {
		return expenses;
	}

	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}

	public int getBalamt() {
		return balamt;
	}

	public void setBalamt(int balamt) {
		this.balamt = balamt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public EmpPayment(
			int epnumber,
			 int empno,			
			 String year,
			 String month,
			 int advamt,
			 int expenses,
			 int balamt,
			 String remarks
			) {
		 this.epnumber=epnumber;
		 this.year=year;
		 this.month=month;
		 this.empno=empno;
		 this.advamt=advamt;
		 this.expenses=expenses;
		 this.balamt=balamt;
		 this.remarks=remarks;
	}

	@Override
	public String toString() {
		return "Material [ " 
				+ "epnumber=" + epnumber
				+ "ename=" + ename
				+ "empno=" + empno				
				+ "year=" + year
				+ " month= " + month
				+ " empno= " + empno
				+ " advamt = " + advamt
				+ " expenses= " + expenses
				+ " balamt= " + balamt
				+ " remarks= " + remarks
				;
	}
}

package com.sof.revolut.model;

import java.math.BigDecimal;

/**
 * @author Hany.Abdelbaqy
 *
 */
public class Account {
	private String acctNo;
	private String acctName;
	private BigDecimal balance;

	// This default constructor is required if there are other constructors.
	public Account() {

	}

	public Account(String acctNo, String acctName, BigDecimal balance) {
		this.acctNo = acctNo;
		this.acctName = acctName;
		this.balance = balance;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


}
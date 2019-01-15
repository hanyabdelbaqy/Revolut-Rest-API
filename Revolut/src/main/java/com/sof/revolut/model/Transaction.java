/**
 * 
 */
package com.sof.revolut.model;

import java.math.BigDecimal;

/**
 * @author Hany.Abdelbaqy
 *
 */
public class Transaction {
	private String fromAcctNo;
	private String toAcctNo;
	private BigDecimal amount;
	
	public String getFromAcctNo() {
		return fromAcctNo;
	}
	
	public void setFromAcctNo(String fromAcctNo) {
		this.fromAcctNo = fromAcctNo;
	}
	
	public String getToAcctNo() {
		return toAcctNo;
	}
	
	public void setToAcctNo(String toAcctNo) {
		this.toAcctNo = toAcctNo;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}

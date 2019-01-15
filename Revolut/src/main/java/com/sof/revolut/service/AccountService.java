/**
 * 
 */
package com.sof.revolut.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import com.sof.revolut.dao.AccountDAO;
import com.sof.revolut.model.Account;
import com.sof.revolut.model.Transaction;
/**
 * @author Hany.Abdelbaqy
 *
 */
@Path("/accounts")
public class AccountService {
 
    // URI:
    // /contextPath/servletPath/Accounts
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Account> getAccounts_JSON() {
        List<Account> listOfCountries = AccountDAO.getAllAccounts();
        return listOfCountries;
    }

    // URI:
    // /contextPath/servletPath/Accounts/getAcctByNo
    @POST
    @Path("/getAcctByNo")
    @Produces({ MediaType.APPLICATION_JSON})
    public Account getAccount(Account acct) {
        return AccountDAO.getAccount(acct.getAcctNo());
    }
 
    // URI:
    // /contextPath/servletPath/Accounts/addAcct
    @POST
    @Path("/addAcct")
    @Produces({ MediaType.APPLICATION_JSON})
    public Account addAccount(Account acct) {
        return AccountDAO.addAccount(acct);
    } 
    
    @Path("/transaction")
    @POST
    @Produces({ MediaType.APPLICATION_JSON})
    public Response transferFund(Transaction transaction){
    	String result ="";
    	Account fromAcct =  AccountDAO.getAccount(transaction.getFromAcctNo());
    	if(fromAcct == null){
    		result ="Source Account Number's Not found";
    		return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    	}
    	Account toAcct =  AccountDAO.getAccount(transaction.getToAcctNo());
    	if(toAcct == null){
    		result ="Destination Account Number's Not found";
    		return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    	}
    	final BigDecimal zeroAmount = new BigDecimal(0).setScale(4, RoundingMode.HALF_EVEN);
    	if(transaction.getAmount()==null){
    		result ="Transaction Amount should be have value";
    		return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    	}else if(transaction.getAmount()!=null 
    			&& transaction.getAmount().compareTo(zeroAmount)<=0){
    		result ="Transaction Amount should be greater than Zero";
    		return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    	}
    	
    	// check enough fund in source account
		BigDecimal fromAccountLeftOver = fromAcct.getBalance().subtract(transaction.getAmount());
		if (fromAccountLeftOver.compareTo(zeroAmount) < 0) {
			result ="Not enough Fund from source Account";
    		return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
		}else{
			 AccountDAO.transferAccountBalance(fromAcct, toAcct, transaction.getAmount());
			 result ="Transfer transaction success";
	    	 return Response.status(Response.Status.ACCEPTED).entity(result).build();
		}
    }
}

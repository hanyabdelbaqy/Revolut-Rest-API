package com.sof.revolut.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import com.sof.revolut.model.Account;

/**
 * @author Hany.Abdelbaqy
 *
 */
public class AccountDAO {
 
    private static final Map<String, Account> acctMap = new HashMap<String, Account>();
 
    static {
        initAccts();
    }
 
    private static void initAccts() {
        Account acct1 = new Account("Acct01", "HMA Acct", new BigDecimal(1200));
        Account acct2 = new Account("Acct02", "Hany Acct", new BigDecimal(1200));
        Account acct3 = new Account("Acct03", "Mohames Acct", new BigDecimal(1200));
 
        acctMap.put(acct1.getAcctNo(), acct1);
        acctMap.put(acct2.getAcctNo(), acct2);
        acctMap.put(acct3.getAcctNo(), acct3);
    }
 
    public static Account getAccount(String AcctNo) {
        return acctMap.get(AcctNo);
    }
 
    public static Account addAccount(Account acct) {
        acctMap.put(acct.getAcctNo(), acct);
        return acct;
    }
 
    public static Account updateAccount(Account acct) {
        acctMap.put(acct.getAcctNo(), acct);
        return acct;
    }
 
    public static List<Account> getAllAccounts() {
        Collection<Account> c = acctMap.values();
        List<Account> list = new ArrayList<Account>();
        list.addAll(c);
        return list;
    }

    public static void transferAccountBalance(Account fromAcct, Account toAcct, BigDecimal amount) {
    	fromAcct.setBalance(fromAcct.getBalance().subtract(amount));
    	updateAccount(fromAcct);
    	toAcct.setBalance(toAcct.getBalance().add(amount));
    	updateAccount(toAcct);
	}
}
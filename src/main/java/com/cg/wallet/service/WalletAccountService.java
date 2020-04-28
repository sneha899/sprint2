package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransactions;
import com.cg.wallet.exception.WalletAccountException;

public interface WalletAccountService {
	
	

	public WalletAccount createWalletAccount(WalletAccount walletAccount) throws WalletAccountException;
	
	public List<WalletAccount> findAllAccounts() throws WalletAccountException;

	
	
	public WalletAccount  findAccountById(int accountId) throws WalletAccountException; 

	public WalletAccount showbalance(int accountId,double accountBal) throws WalletAccountException;

	
	public WalletAccount deposit(int accountId , double amount) throws WalletAccountException;
	

	public WalletAccount deleteAccount(int accountId) throws WalletAccountException;



	
	
	

	
	
	
	
	
}


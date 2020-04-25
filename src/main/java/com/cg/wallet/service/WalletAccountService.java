package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransactions;
import com.cg.wallet.exception.WalletAccountException;

public interface WalletAccountService {
	
	

	public WalletAccount createWalletAccount(WalletAccount walletAccount) throws WalletAccountException;
	
	//public WalletAccount getWalletAccount(int accountId) throws WalletAccountException;
	
	
	public WalletAccount  find(int accountId) throws WalletAccountException; 

	public WalletAccount showbalance(WalletAccount account) throws WalletAccountException;

	
	public double deposit(int accountId , double amount) throws WalletAccountException;
	

	public WalletAccount deleteAccount(int accountId) throws WalletAccountException;

	
	
	

	
	
	
	
	
}


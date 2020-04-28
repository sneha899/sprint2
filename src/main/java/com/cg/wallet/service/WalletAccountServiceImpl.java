package com.cg.wallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.wallet.dao.WalletAccountDao;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransactions;
import com.cg.wallet.exception.WalletAccountException;

@Service
public class WalletAccountServiceImpl implements WalletAccountService{
	
	@Autowired
	WalletAccountDao accountDao;

	

	@Override
	public WalletAccount showbalance(int accountId,double accountBal) throws WalletAccountException {
       WalletAccount walletAccount=accountDao.getAccountBal(accountBal);
      
		return walletAccount;
	
	}

	@Override
	public WalletAccount deposit(int accountId, double amount) throws WalletAccountException {
		WalletAccount walletAccount=accountDao.findById(accountId).get();
		
		walletAccount.setAccountBal(walletAccount.getAccountBal()+amount);
		   accountDao.saveAndFlush(walletAccount);
		   return walletAccount;

		
	}

	@Override
	public WalletAccount deleteAccount(int accountId) throws WalletAccountException {
		WalletAccount wacc=null;
		if(accountDao.existsById(accountId))
		{
			wacc=accountDao.findById(accountId).get();
			accountDao.deleteById(accountId);
			
		}
		else
		{
			throw new WalletAccountException("Id not found");
		}
		return wacc;
	}

	@Override
	public WalletAccount createWalletAccount(WalletAccount walletAccount) throws WalletAccountException {

		WalletAccount acc=accountDao.saveAndFlush(walletAccount);
		
		return acc;
	}

	@Override
	public WalletAccount findAccountById(int accountId) throws WalletAccountException {
		WalletAccount walletAccount=null;
		boolean flag=accountDao.existsById(accountId);
		
		if(flag)
		{
		
		   walletAccount=accountDao.findById(accountId).get();

		}
		else
		{
			throw new WalletAccountException("id does not found");
		}
		
		
		 return walletAccount;

		
		
	
	}
	

	@Override
	public List<WalletAccount> findAllAccounts() throws WalletAccountException {
        List<WalletAccount> list=accountDao.findAll();
		
		return list;
	}



}
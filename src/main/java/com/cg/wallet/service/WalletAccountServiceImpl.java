package com.cg.wallet.service;

import java.util.List;

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
	public WalletAccount showbalance(WalletAccount account) throws WalletAccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double deposit(int accountId, double amount) throws WalletAccountException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WalletAccount deleteAccount(int accountId) throws WalletAccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WalletAccount createWalletAccount(WalletAccount walletAccount) throws WalletAccountException {

		WalletAccount acc=accountDao.saveAndFlush(walletAccount);
		
		return acc;
	}

	@Override
	public WalletAccount find(int accountId) throws WalletAccountException {
		WalletAccount walletAccount=null;
		boolean flag=accountDao.existsById(accountId);
		if(flag)
		{
		
		   walletAccount=accountDao.getOne(accountId);
//			accountMap.put(accountId, walletAccount);  
		}
		else
		{
			throw new WalletAccountException("id does not found");
		}
		
		
		 return walletAccount;

		
		
	
	}

	/*@Override
	public WalletAccount getWalletAccount(int accountId) throws WalletAccountException {
		
		if(!accountDao.existsById(accountId))
		{
			System.out.println("print accountId"+accountId);
			throw new WalletAccountException("Id not found");
		}
		return accountDao.findById(accountId).get();
	}*/

	/*@Override
	public List<WalletAccount> findAllAccounts() throws WalletAccountException {
        List<WalletAccount> list=accountDao.findAll();
		
		return list;
	}*/



}
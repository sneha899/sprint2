package com.cg.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.exception.WalletAccountException;
import com.cg.wallet.service.WalletAccountService;

@RestController
public class WalletAccountController {
	
	@Autowired
	WalletAccountService walletAccountService;
	
	@PostMapping("walletAccount")
	public ResponseEntity<WalletAccount> createWalletAccount(@RequestBody WalletAccount walletAccount) throws WalletAccountException
	{
		WalletAccount wacc=walletAccountService.createWalletAccount(walletAccount);
		ResponseEntity<WalletAccount>  re = new ResponseEntity<WalletAccount>(wacc,HttpStatus.OK);

		return re;
	
}
	@GetMapping("walletAccount/{id}")
	public ResponseEntity<WalletAccount> findAccountById(@PathVariable("id")int id) throws WalletAccountException
	{
		WalletAccount account=walletAccountService.findAccountById(id);
		ResponseEntity<WalletAccount> wacc=new ResponseEntity<>(account,HttpStatus.OK);
		return wacc;


	}

	@PutMapping("walletAccount/id/{id}/amount/{amount}")
	public ResponseEntity<WalletAccount> deposit(@PathVariable("id")int id, @PathVariable("amount") double amount) throws WalletAccountException
	{
		WalletAccount acc=walletAccountService.deposit(id,amount);
		ResponseEntity<WalletAccount> wacc=new ResponseEntity<>(acc,HttpStatus.OK);
		return wacc;
	}	
	

	
	@GetMapping("walletAccount")
	public ResponseEntity<List<WalletAccount>> findAllAccounts() throws WalletAccountException
	{
		List<WalletAccount> list = walletAccountService.findAllAccounts();
		ResponseEntity<List<WalletAccount>>  rt = new ResponseEntity<List<WalletAccount>>(list,HttpStatus.OK);
		return rt;
	}
	@DeleteMapping("walletAccount/{id}")
	public ResponseEntity<WalletAccount> deleteAccount(@PathVariable ("id") int id) throws WalletAccountException
	{
		WalletAccount acc=walletAccountService.deleteAccount(id);
		ResponseEntity<WalletAccount> wacc=new ResponseEntity<>(acc,HttpStatus.OK);
		return wacc;
		
	}
	/*@GetMapping("walletAccount/{id}")
	public ResponseEntity<WalletAccount> showbalance(@PathVariable("id")int id,@PathVariable("accountBal") double accountBal) throws WalletAccountException
	{
		WalletAccount acc=walletAccountService.showbalance(id,accountBal);
		ResponseEntity<WalletAccount> wacc=new ResponseEntity<>(acc,HttpStatus.OK);
		return wacc;


	}*/
	
}

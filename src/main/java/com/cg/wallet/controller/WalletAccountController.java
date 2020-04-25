package com.cg.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<WalletAccount> find(@PathVariable("id")int id) throws WalletAccountException
	{
		WalletAccount account=walletAccountService.find(id);
		ResponseEntity<WalletAccount> wacc=new ResponseEntity<>(account,HttpStatus.OK);
		return wacc;


	}
	
	
	
	/*@GetMapping("walletAccount/{id}")
	public ResponseEntity<WalletAccount> getWalletAccount(@PathVariable("id") int id) throws WalletAccountException
	{
		WalletAccount account=walletAccountService.getWalletAccount(id);
		ResponseEntity<WalletAccount> wacc=new ResponseEntity<>(account,HttpStatus.OK);
		return wacc;
	}
	
	@GetMapping("walletAccount")
	public ResponseEntity<List<WalletAccount>> findAllTrainees() throws WalletAccountException
	{
		List<WalletAccount> list = walletAccountService.findAllAccounts();
		ResponseEntity<List<WalletAccount>>  rt = new ResponseEntity<List<WalletAccount>>(list,HttpStatus.OK);
		return rt;
			}*/
}

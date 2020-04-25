package com.cg.wallet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransactions;
import com.cg.wallet.service.WalletAccountService;

@Repository
public interface WalletAccountDao extends JpaRepository<WalletAccount,Integer>

{
	
    //@Query("Select e from WalletAccount where e.accountId=:id")
	//public WalletAccount getWalletAccount(@Param("id")int accountId) ;

	

}
 
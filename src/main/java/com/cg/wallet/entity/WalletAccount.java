package com.cg.wallet.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="walletAccount_tbl")
public class WalletAccount {

	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="account_seq",allocationSize=1)
	@Column(name="accountId")
	private int accountId;
	
	@Column(name="accountbal")
	private double accountBal;
	
	@Column(name="status")
	private String status;

	@OneToMany(mappedBy="walletAccount")
	@JsonIgnore
	private List<WalletTransactions> transactions=new ArrayList<>();

	public List<WalletTransactions> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<WalletTransactions> transactions) {
		this.transactions = transactions;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	
	
	public double getAccountBal() {
		return accountBal;
	}

	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	



}

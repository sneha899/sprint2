package com.cg.wallet.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="walletTrans_tbl")
public class WalletTransactions {

	@Id
	@Column(name="tid")
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="transactions_seq",allocationSize=1)

	private  int transactionId;
	
	@Column(name="tdes",length=15)
	private String description;
	
	@Column(name="tdate")
	private LocalDate dateOfTransaction;

	@Column(name="tamount")
	private double amount;
	
	@Column(name="taccountbal")
	private double accountBal;
	
     @ManyToOne
     @JoinColumn(name="accountId",referencedColumnName="accountId")
	private WalletAccount walletAccount;
	
	
	public int getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAccountBal() {
		return accountBal;
	}

	public WalletAccount getWalletAccount() {
		return walletAccount;
	}



	public void setWalletAccount(WalletAccount walletAccount) {
		this.walletAccount = walletAccount;
	}



	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}
	
	
}

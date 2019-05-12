package com.prueba.pojo.response;

import com.prueba.pojo.transaction.CreditCardResponse;
import com.prueba.pojo.transaction.LoanResponse;
import com.prueba.pojo.transaction.SavingAccountResponse;

public class ResponseTransactions {
	private CreditCardResponse creditCard;
	private SavingAccountResponse savingAccount;
	private LoanResponse loan;
	public CreditCardResponse getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCardResponse creditCard) {
		this.creditCard = creditCard;
	}
	public SavingAccountResponse getSavingAccount() {
		return savingAccount;
	}
	public void setSavingAccount(SavingAccountResponse savingAccount) {
		this.savingAccount = savingAccount;
	}
	public LoanResponse getLoan() {
		return loan;
	}
	public void setLoan(LoanResponse loan) {
		this.loan = loan;
	}
	
	
}

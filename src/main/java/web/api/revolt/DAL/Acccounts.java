package web.api.revolt.DAL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web.api.revolt.BLO.Account;
import web.api.revolt.BLO.Dcamount;
import web.api.revolt.BLO.Transaction;
import web.api.revolt.BLO.Transfer;

public class Acccounts {
	
	private static List<Account> accounts = new ArrayList<Account>();

	public Acccounts() {}
	
	public boolean add (Account account){
		if(Acccounts.accounts.add(account)) {
			return true;
		}
		return false;
	}
	
	public List<Account> getAll() {
		return Acccounts.accounts;
	}
	
	public Account get(int client_id) {
		for(Account transaction : Acccounts.accounts) {
			if(transaction.getClient_id() == client_id) {
				return transaction;
			}
		}
		return null;
	}
	
	public boolean delete(int client_id) {
		for(Account account : Acccounts.accounts) {
			if(account.getClient_id()== client_id) {
				if(account.getBalance() <= 0) {
					if(Acccounts.accounts.remove(account)) {
						return true;
					}
				}				
			}
		}
		return false;
	}
	
	public boolean disable(int client_id) {
		int index = this.index_by_client(client_id);
		if(Acccounts.accounts.get(index).isActive()) {
			Acccounts.accounts.get(index).setActive(false);
			return true;
		}
		return false;
	}
	
	public Transaction debit(Dcamount debit) {
		int account_index = this.index_by_account(debit.getAccount_number());
		if(!Acccounts.accounts.get(account_index).isActive()) {
			return null;
		}
		if(Acccounts.accounts.get(account_index).getBalance() < debit.getAmount()) {
			return null;
		}
		
		double balance = Acccounts.accounts.get(account_index).getBalance();
		
		//Debit balance from account
		Acccounts.accounts.get(account_index).setBalance(balance-debit.getAmount());
		
		//add transaction record and return
		return this.record_trns(Acccounts.accounts.get(account_index).getClient_id(), Acccounts.accounts.get(account_index).getClient_id(), debit.getAmount());
				
	}
	
	public Transaction credit(Dcamount credit) {
		
		int account_index = this.index_by_account(credit.getAccount_number());
		if(!Acccounts.accounts.get(account_index).isActive()) {
			return null;
		}
		double balance = Acccounts.accounts.get(account_index).getBalance();
		
		//credit balance from account
		Acccounts.accounts.get(account_index).setBalance(balance+credit.getAmount());
		
		//add transaction record and return
		return this.record_trns(Acccounts.accounts.get(account_index).getClient_id(), Acccounts.accounts.get(account_index).getClient_id(), credit.getAmount());
				
	}
	
	public Transaction transfer(Transfer transfer) {
		//check balance and account active status of sender
		int sender_index = this.index_by_account(transfer.getSender_account());
		if(!Acccounts.accounts.get(sender_index).isActive()) {
			return null;
		}
		if(Acccounts.accounts.get(sender_index).getBalance() < transfer.getAmout()) {
			return null;
		}
		
		//check recipient account's active status 
		int receiver_index = this.index_by_account(transfer.getReceiver_account());
		if(!Acccounts.accounts.get(receiver_index).isActive()) {
			return null;
		}
		
		double sender_balance = Acccounts.accounts.get(sender_index).getBalance();
		double recipient_balance = Acccounts.accounts.get(receiver_index).getBalance();
		
		//make transaction
		Acccounts.accounts.get(sender_index).setBalance(sender_balance-transfer.getAmout());
		Acccounts.accounts.get(receiver_index).setBalance(recipient_balance+transfer.getAmout());
		
		//add transaction record and return
		return this.record_trns(Acccounts.accounts.get(sender_index).getClient_id(), Acccounts.accounts.get(receiver_index).getClient_id(), transfer.getAmout());
		
	}
	
	private Transaction record_trns(int sender_id, int receiver_id, double amount) {
		Transaction transection = new Transaction();
		transection.setSender_id(sender_id);
		transection.setReceiver_id(receiver_id);
		transection.setAmount(amount);
		transection.setDate(new Date());
		transection.setTrns_id(transection.generateTransectionId());
		return transection;
	}
	
	private int index_by_client(int client_id) {
		int index = 0;
		for(Account account : Acccounts.accounts) {
			if(account.getClient_id()== client_id) {
				return index;	
			}
			index ++;
		}
		return 0;
	}
	
	private int index_by_account(String account_id) {
		int index = 0;
		for(Account account : Acccounts.accounts) {
			if(account.getAccount_number().equals(account_id)) {
				return index;	
			}
			index ++;
		}
		return 0;
	}
}

package web.api.revolt.DAL;

import java.util.ArrayList;
import java.util.List;

import web.api.revolt.BLO.Transaction;

public class Transactions {
	
	private static List<Transaction> transactions = new ArrayList<Transaction>();
	
	public Transactions() {}
	
	public boolean add (Transaction trans){
		if(Transactions.transactions.add(trans)) {
			return true;
		}
		return false;
	}
	
	public List<Transaction> getAll() {
		return Transactions.transactions;
	}
	
	public Transaction get(String transactions_id) {
		for(Transaction transaction : Transactions.transactions) {
			if(transaction.getTrns_id() == transactions_id) {
				return transaction;
			}
		}
		return null;
	}
	
	public boolean delete(String trans_id) {
		for(Transaction transaction : Transactions.transactions) {
			if(transaction.getTrns_id()== trans_id) {
				if(Transactions.transactions.remove(transaction)) {
					return true;
				}
			}
		}
		return false;
	}

}

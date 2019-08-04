package web.api.revolt.BLO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
	private String account_number;
	private double balance;
	private boolean active;
	private int client_id = 0;
	
	public Account(){}
	public Account(String account_number, double balance, boolean active, int client_id) {
		super();
		this.account_number = account_number;
		this.balance = balance;
		this.active = active;
		this.client_id = client_id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}	
	
	public String generateAccountNumber() {
		return "ac_id_"+String.valueOf(this.getClient_id());
	}
}

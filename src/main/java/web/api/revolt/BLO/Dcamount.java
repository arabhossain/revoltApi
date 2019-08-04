package web.api.revolt.BLO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dcamount {
	private String account_number;
	private double amount;
	
	public Dcamount() {}
	public Dcamount(String account_number, double amount) {
		this.account_number = account_number;
		this.amount = amount;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}

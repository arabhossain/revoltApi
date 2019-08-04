package web.api.revolt.BLO;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaction {
	private String trns_id;
	private int sender_id;
	private int receiver_id;
	private double amount;
	private Date date;

	
	public Transaction() {}
	public Transaction(String trns_id, int sender_id, int receiver_id, double amount, Date date) {
		this.trns_id = trns_id;
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
		this.amount = amount;
		this.date = date;
	}

	public String getTrns_id() {
		return trns_id;
	}

	public void setTrns_id(String trns_id) {
		this.trns_id = trns_id;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String generateTransectionId() {
		String trns_id = String.valueOf(this.sender_id) + "-"+String.valueOf(this.receiver_id);
		return trns_id;
	}
	
	
}

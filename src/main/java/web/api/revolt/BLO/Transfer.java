package web.api.revolt.BLO;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author arab
 *
 */
@XmlRootElement
public class Transfer {
	private String sender_account;
	private String receiver_account;
	private double amout;

	public Transfer() {
	}

	public Transfer(String sender_account, String receiver_account, double amout) {
		this.sender_account = sender_account;
		this.receiver_account = receiver_account;
		this.amout = amout;
	}

	public String getSender_account() {
		return sender_account;
	}

	public void setSender_account(String sender_account) {
		this.sender_account = sender_account;
	}

	public String getReceiver_account() {
		return receiver_account;
	}

	public void setReceiver_account(String receiver_account) {
		this.receiver_account = receiver_account;
	}

	public double getAmout() {
		return amout;
	}

	public void setAmout(double amout) {
		this.amout = amout;
	}

}

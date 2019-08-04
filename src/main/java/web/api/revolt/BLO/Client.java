package web.api.revolt.BLO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {

	private int id;
	private String username;
	private String name;
	
	public Client() {}
	public Client(int id, String username, String name, double balance) {
	
		this.id = id;
		this.username = username;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

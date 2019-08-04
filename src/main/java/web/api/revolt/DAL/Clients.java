package web.api.revolt.DAL;

import java.util.ArrayList;
import java.util.List;
import web.api.revolt.BLO.Client;

public class Clients {

	private static List<Client> clients = new ArrayList<Client>();
	
	
	public Clients() {}
	
	public boolean add (Client client){
		if(Clients.clients.add(client)) {
			return true;
		}
		return false;
	}
	
	public List<Client> getAll() {
		return Clients.clients;
	}
	
	public Client get(int client_id) {
		for(Client client : Clients.clients) {
			if(client.getId() == client_id) {
				return client;
			}
		}
		return null;
	}
	
	public Client update(Client client) {
		int index = 0;
		for(Client _client : Clients.clients) {
			if(client.getId() == _client.getId()) {
				Clients.clients.get(index).setName(client.getName());
				Clients.clients.get(index).setUsername(client.getUsername());
				return Clients.clients.get(index);
			}
			
			index++;
		}
		
		return null;
	}
	
	
	public boolean delete(int client_id) {
		for(Client client : Clients.clients) {
			if(client.getId() == client_id) {
				if(Clients.clients.remove(client)) {
					return true;
				}
			}
		}
		return false;
	}
}

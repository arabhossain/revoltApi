package web.api.revolt.AppRevolt;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import web.api.revolt.BLO.Account;
import web.api.revolt.BLO.Client;
import web.api.revolt.DAL.Acccounts;
import web.api.revolt.DAL.Clients;

/**
 * @author arab
 *
 */
@Path("users")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class UsersResource {
	private Clients clients;
	private Acccounts accouns;

	public UsersResource() {
		this.clients = new Clients();
		this.accouns = new Acccounts();
	}

	@GET
	public List<Client> get_clients() {
		return this.clients.getAll();
	}

	@GET
	@Path("user/{id}")
	public Client user(@PathParam("id") int Client_id) {

		return this.clients.get(Client_id);
	}

	@POST
	@Path("add")
	public Client add_client(Client client) {
		this.clients.add(client);

		// open a account for the client
		Account account = new Account();
		account.setClient_id(client.getId());
		account.setAccount_number(account.generateAccountNumber());
		account.setBalance(0);
		account.setActive(true);
		this.accouns.add(account);

		return this.user(client.getId());
	}

	@PUT
	@Path("update/{id}")
	public Client update_client(@PathParam("id") int Client_id, Client client) {
		if (Client_id == client.getId()) {
			return this.clients.update(client);
		}
		return null;
	}

	@DELETE
	@Path("delete/{id}")
	public String delete_client(@PathParam("id") int Client_id) {
		this.clients.delete(Client_id);

		return "Added new client " + Client_id;
	}

}

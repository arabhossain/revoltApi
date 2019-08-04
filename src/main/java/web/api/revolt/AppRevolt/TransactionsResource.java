package web.api.revolt.AppRevolt;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import web.api.revolt.BLO.Transaction;
import web.api.revolt.DAL.Transactions;

@Path("transactions")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class TransactionsResource {
	Transactions transactions;

	public TransactionsResource() {
		this.transactions = new Transactions();
	}

	@GET
	public List<Transaction> getAll() {
		return this.transactions.getAll();
	}
	
	@GET
	@Path("transaction/{id}")
	public Transaction transaction(@PathParam("id") String transaction_id) {
		return this.transactions.get(transaction_id);
	}

}

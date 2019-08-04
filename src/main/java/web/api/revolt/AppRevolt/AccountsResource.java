package web.api.revolt.AppRevolt;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import web.api.revolt.BLO.Account;
import web.api.revolt.BLO.Dcamount;
import web.api.revolt.BLO.Transaction;
import web.api.revolt.BLO.Transfer;
import web.api.revolt.DAL.Acccounts;
import web.api.revolt.DAL.Transactions; 

/**
 * @author arab
 *
 */
@Path("accounts")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class AccountsResource {
	private Acccounts accouns;
	private Transactions transactions;

	public AccountsResource() {
		this.accouns = new Acccounts();
		this.transactions = new Transactions();
	}

	
	@GET
	public List<Account> getAll() {
		return accouns.getAll();
	}

	@GET
	@Path("account/{id}")
	public Account user(@PathParam("id") int account_id) {
		return this.accouns.get(account_id);
	}

	@POST
	@Path("transfer")
	public Transaction transfer(Transfer transfer) {
		Transaction trans = this.accouns.transfer(transfer);
		this.transactions.add(trans);
		return trans;
	}

	@POST
	@Path("debit")
	public Transaction debit(Dcamount debit) {
		Transaction trans = this.accouns.debit(debit);
		this.transactions.add(trans);
		return trans;
	}

	@POST
	@Path("credit")
	public Transaction credit(Dcamount credit) {
		Transaction trans = this.accouns.credit(credit);
		this.transactions.add(trans);
		return trans;
	}

}

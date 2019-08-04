package web.api.revolt.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private String userName;
	private String Password;
	private String database;
	private Connection conn;
	
	public Database() {
		this.userName = "root";
		this.Password = "arabrmc148";
		this.database = "revolt_api";
		
		try {
			this.conn_close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Database(String username, String password, String database) {
		this.userName = username;
		this.Password = password;
		this.database = database;
		
		try {
			this.conn_close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected Connection conn_get() {
    	try {
    	    this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+this.database+"?user="+this.userName+"&password="+this.Password+"");
    	} catch (SQLException ex) {
    		System.out.println(ex.getMessage());
    		this.conn = null;
    	}
    	return this.conn;
	}
	
	private void conn_close() throws SQLException {
		if(this.is_connected()) {
			this.conn.close();
		}
	}
	
	private boolean is_connected() throws SQLException {
		if(!this.conn.isClosed()) {
			return true;
		}
		return false;
	}
}


package com.AddressBookSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookServiceMain {

	public static void main(String[] args) throws SQLException {
		AddressBookServiceMain services = new AddressBookServiceMain();
		services.readAddressBookData();
	}

	private void readAddressBookData() throws SQLException {
		Connection conn = MySQLConnection.getConnection();
		String sql = "SELECT * FROM addressbookservice.addressbook";
		Statement query = conn.createStatement();
		ResultSet resultSet = query.executeQuery(sql);
		ResultSetMetaData rsmd = resultSet.getMetaData();
	    int columnsNumber = rsmd.getColumnCount();
		while(resultSet.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
	            if (i > 1) System.out.print(" | ");
	            System.out.print(resultSet.getString(i));
	        }
	        System.out.println("");
		}
		conn.close();	
	}
}

package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgendaController {
	public static void main(String[] args) throws Exception {
		Class.forName("org.sqlite.JDBC");

		Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");

		Statement stat = conn.createStatement();
		stat.executeUpdate("drop table if exists agenda;");
		stat.executeUpdate("drop table if exists COMPANY;");
		// stat.executeUpdate("CREATE TABLE agenda	(Name VARCHAR (30),Adresse VARCHAR (30),"
		// +
		// "Stadt VARCHAR (30), Fax INTEGER,Handy INTEGER,Telefon INTEGER,Email VARCHAR (30), Geburt DATE);");
		// PreparedStatement prep = conn
		// .prepareStatement("insert into agenda values (?, ?,?);");

		// prep.setString(1, "Gandhi");
		// prep.setString(2, "politics");
		// prep.addBatch();

		// prep.setString(1, "Turing");
		// prep.setString(2, "computers");
		// prep.addBatch();
		//
		// prep.setString(1, "Wittgenstein");
		// prep.setString(2, "smartypants");
		// prep.addBatch();

		conn.setAutoCommit(false);
		// prep.executeBatch();
		conn.setAutoCommit(true);

		// ResultSet rs = stat.executeQuery("select * from agenda;");
		// while (rs.next()) {
		// System.out.println("name = " + rs.getString("name"));
		// System.out.println("job = " + rs.getString("occupation"));
		// }
		// rs.close();
		conn.close();
	}
}

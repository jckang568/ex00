package com.jckang.ex00.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		String url = "jdbc:oracle:thin:@test2_medium?TNS_ADMIN=d:/dev/tools/db/Wallet_test2";
		String id = "ADMIN";
		String password ="Oracledatabase!486@";
		try(Connection con = DriverManager.getConnection(url, id, password)){
			log.info(con);
		
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
}

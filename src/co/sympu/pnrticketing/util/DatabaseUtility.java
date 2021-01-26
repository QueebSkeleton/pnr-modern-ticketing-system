package co.sympu.pnrticketing.util;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseUtility {

	public static MysqlDataSource dataSource;
	
	static {
		dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/pnr_db");
		dataSource.setUser("pnr_app");
		dataSource.setPassword("password123");
	}
	
}

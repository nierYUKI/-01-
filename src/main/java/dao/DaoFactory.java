package dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoFactory {
	
	//DB接続のメソッド
	private static DataSource getDataSource() {
		DataSource ds = null;
		
		try {
		InitialContext ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myproject");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public static UserDao createUserDao() {
		return new UserDaoImpl(getDataSource());
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.User;

public class UserDaoImpl implements UserDao{
	private DataSource ds;
	
	public UserDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public void insert(User user) {
		//SQLの準備
		String sql = "insert into user values(null,?,?,?)";
		
		//パスワードのハッシュ化
		String loginPass = user.getPassword();
		String hashed = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
		
		
		
			try(Connection con = ds.getConnection()){;
			//SQLを実行
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, hashed);
			stmt.setObject(3, user.getWorkId());
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("データ取得失敗");
	}
	}

	@Override
	public User findByLoginAndPass(String name, String password) throws Exception {
		
		User user = null;
		//SQL文を用意
		String sql = "select * from user where name = ?";
		try(Connection con = ds.getConnection()) {
			//SQLを実行
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			
			//ログインチェック
			if(rs.next()) {
				if(BCrypt.checkpw(password, rs.getString("password"))) {
					user = mapToUser(rs);
				}
				
			}
		}catch(Exception e) {
			throw e;
		}
		
		return user;
	}
	
	protected User mapToUser(ResultSet rs)throws Exception{
		User user = new User();
		user.setId((Integer)rs.getObject("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		//ログインチェックの時に悪さをしていた文
		//user.setWorkId(rs.getString("workId"));
		return user;
	
	}
}

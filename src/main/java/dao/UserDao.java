package dao;

import java.util.List;

import domain.User;

public interface UserDao {
	
	//ユーザーの登録
	void insert(User user);
	
	//ログイン認証
	//正しいID,Passの場合、Userを返す
	//正しくない場合はNullを返す
	User findByLoginAndPass( String loginId,String loginPass) throws Exception;
	
	//User テーブル内で登録されているユーザー情報を取得。
	public List<User> findAll()
			throws Exception;

}

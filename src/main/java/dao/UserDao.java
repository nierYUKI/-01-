package dao;

import domain.User;

public interface UserDao {
	
	//ユーザーの登録
	void insert(User user);
	
	//ログイン認証
	//正しいID,Passの場合、Userを返す
	//正しくない場合はNullを返す
	User findByLoginAndPass(String loginId,String loginPass) throws Exception;

}

package dao;

import java.util.List;

import domain.ServiceManagment;

public interface ServiceManagmentDao {
	
	//servicemanagementテーブル内のサービス名を取得。
	public List<ServiceManagment>findAll()
		throws Exception;
	
	//指定したIDのサービス情報を取得。
	public ServiceManagment findById(Integer id)
			throws Exception;
	
	//指定したサービス名テーブルを更新する
	public void insert(String ServiceName)
		throws Exception;
	

}

package dao;

import java.util.List;

import domain.IncidentManagement;


public interface IncidentManagementDao {
	
	//incidentmanagement テーブル内の全ての情報を取得する。
	public List<IncidentManagement>findAll() throws Exception;
	
	//指定したid のインシデント情報を取得する。
	public IncidentManagement findById(Integer id)throws Exception;
	
	//ユーザーが指定したインシデント情報をincidentmanagement テーブルに追加する。
	public void insert(IncidentManagement item)throws Exception;
	
	//指定したインシデント情報をincidentmanagement テーブル内で更新する。
	public void update(IncidentManagement item)throws Exception;
	
	//指定したインシデント情報をincidentmanagement テーブルから削除する。
	public void delete(IncidentManagement item)throws Exception;

}

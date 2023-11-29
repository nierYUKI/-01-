package dao;

import java.util.List;

import domain.WorkTable;

public interface WorkTableDao {
	
	//部門追加
	public List<WorkTable>findAll()
	throws Exception;
	
	//指定したIDのサービス情報を取得。
	public WorkTable findById(Integer WorkId)
	throws Exception;

}

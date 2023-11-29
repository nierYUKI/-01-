package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.WorkTable;

public class WorkTableDaoImpl implements WorkTableDao {

	private DataSource ds;
	public WorkTableDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	//新規アカウントを作成する際に所属部門の情報が欲しいため追加11/29
	public List<WorkTable> findAll() throws Exception {

		List<WorkTable>WorkList = new ArrayList<>();
		try(Connection con = ds.getConnection()){
		String sql = " select * from worktable ";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			WorkList.add(mapToWorkTable(rs));
		}
		}catch(Exception e) {

	}
	return WorkList;
	}

	//ResultSetからオブジェクトへの変換
	private WorkTable mapToWorkTable(ResultSet rs) throws Exception {
	Integer WorkId = (Integer)rs.getObject("work_id");
	String WorkName = rs.getString("name");
	return new WorkTable(WorkId,WorkName);
}
	
	@Override
	public WorkTable findById(Integer WorkId) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.IncidentManagement;
import domain.ServiceManagment;

public class IncidentManagementDaoImpl implements IncidentManagementDao {
	private DataSource ds;
	public IncidentManagementDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	//インシデントサービス名を取得
	@Override
	public List<ServiceManagment> findall() throws Exception {
		List<ServiceManagment>ServiceList = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			String sql = "select * from servicemanagement";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ServiceList.add(mapToIncidentService(rs));
		}
			
		}catch(Exception e) {
			throw e;
		}

		return ServiceList;
	}
	//ResultSetからServiceManagmentオブジェクトへの変換
	private ServiceManagment mapToIncidentService(ResultSet rs)throws Exception {
		Integer ServiceId = (Integer)rs.getObject("id");
		String ServiceName = rs.getString("name");
		return new ServiceManagment(ServiceId,ServiceName);
	}

	//インシデントの内容を一覧で取得
	@Override
	public List<IncidentManagement> findAll() throws Exception {
		List<IncidentManagement>IncidentList = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			
			String sql = " select *, user.name AS supported_person_id "
					+ " from incidentmanagement"
					+ " join user on incidentmanagement.supported_person_id = user.id "
					;
			
				//String sql = "select * from incidentManagement";
				
			
//			String sql = " select worktable.name as worktable_name from user"
//					+ " join worktable on user.work_id = worktable.work_id"
//					+ " order by user.id ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				IncidentList.add(mapToIncident(rs));
		}
			
		}catch(Exception e) {
			throw e;
		}
		return IncidentList;
	}

	@Override
	public IncidentManagement findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
	
	//インシデント内容をデータベースに挿入するメソッド
	@Override
	public void insert(IncidentManagement IncidentManagement) throws Exception {
		try(Connection con = ds.getConnection()){
			
			String sql = 
//					"insert into IncidentManagement "
//					+ "(incident_id,incident_name,supported_person_id,incident_content,now(),status)"
//					+ "values(?,?,?,?,now(),?)";
			
			" insert into IncidentManagement ("
                + " incident_id,"
                + " incident_name,"
                + " incident_content,"
                + " supported_person_id,"
                + " creation_time,"
                + " status)"
			 + " values(?,?,?,?,NOW(),?)";
			System.out.println(IncidentManagement.getIncident_id());
			System.out.println(IncidentManagement.getIncident_Name());
			System.out.println(IncidentManagement.getIncident_Content());
			System.out.println(IncidentManagement.getSupported_person_id());
			System.out.println(IncidentManagement.getStatus());
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1,IncidentManagement.getIncident_id());
			stmt.setString(2,IncidentManagement.getIncident_Name());
			stmt.setString(3,IncidentManagement.getIncident_Content());
			stmt.setObject(4,IncidentManagement.getSupported_person_id());
			stmt.setString(5,IncidentManagement.getStatus());
			
			stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public void update(IncidentManagement IncidentManagement) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(IncidentManagement IncidentManagement) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	//ResultSetからIncidentManagementオブジェクトへの変換
	private IncidentManagement mapToIncident(ResultSet rs)throws Exception{
			Integer id = (Integer)rs.getObject("id");
			Integer incident_id = (Integer)rs.getObject("incident_id");
			System.out.println(incident_id);
			String incident_Name = rs.getString("incident_Name");
			String incident_Content = rs.getString("incident_Content");
			Integer supported_person_id = (Integer)rs.getObject("supported_person_id");
			Date Creation_Time = rs.getTimestamp("Creation_Time");
			Date update_time =rs.getTimestamp("update_time");
			String Status = rs.getString("Status");
			String user_name = rs.getString("user.name");
		  
		return new IncidentManagement(id,incident_id,incident_Name,incident_Content,supported_person_id,Creation_Time,update_time,Status,user_name);
		
	}

	
}

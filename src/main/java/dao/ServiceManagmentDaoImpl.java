package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.ServiceManagment;

public class ServiceManagmentDaoImpl implements ServiceManagmentDao{
	
	private DataSource ds;
	public ServiceManagmentDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<ServiceManagment> findAll() throws Exception {
		List<ServiceManagment>ServiceList = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			String sql = "select * from servicemanagement";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ServiceList.add(MapToServiceList(rs));
			}
		}
		return ServiceList;
	}

	@Override
	public ServiceManagment findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(String ServiceName) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
	}
		
		private ServiceManagment MapToServiceList(ResultSet rs)throws Exception{
			Integer ServiceId = (Integer)rs.getObject("id");
			String ServiceName = rs.getString("serviceName");
			
			return new ServiceManagment(ServiceId,ServiceName);
		}
		
	}



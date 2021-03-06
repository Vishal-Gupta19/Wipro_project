package com.vishal.MonitorFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppRepository {

	Connection con= null;
	public AppRepository() {
		
		String url = "jdbc:mysql://localhost:3306/monitor_db?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "pass1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			System.out.println(e);
            e.printStackTrace();
		}
		
	}
	
	public List<App> getApps(){					
		
		List<App> apps=new ArrayList<App>();
		String sql = "select * from app";	
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				App a = new App();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setType(rs.getString(3));
				a.setTimestamp(rs.getString(4));

				apps.add(a);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return apps;
	}
	
	public App getApp(int id) {				
		
		String sql = "select * from app where id= " + id;
		App a=new App();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setType(rs.getString(3));
				a.setTimestamp(rs.getString(4));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return a;
	}
	
	public void create(App a1) {
		
//		int id=a1.getId();
//		
//		App test=new App();
//		String sql1 = "select * from app where id= " + id;
//			try {
//				Statement st1 = con.createStatement();
//				ResultSet rs = st1.executeQuery(sql1);
//				if(rs.next()) {
//				test.setId(rs.getInt(1));
//				}
//			} catch (Exception e1) {
//				System.out.println(e1);
//			}
//			
//		if(test.getId()==0) {
//	
			String sql = "insert into app values(?,?,?,?)";
			try {
				PreparedStatement st = con.prepareStatement(sql);
	
				st.setInt(1, a1.getId());
				st.setString(2, a1.getName());
				st.setString(3, a1.getType());
				st.setString(4, a1.getTimestamp());
				st.executeUpdate();
			}
			catch(Exception e) {
				System.out.println(e);
			}
//		}
//		else {
//			System.out.println("Id already exist");
//		}
	}
	
	public void update(App a1) {
	
			String sql = "update app set type=?, timestamp=? where id=?";
			try {
				PreparedStatement st = con.prepareStatement(sql);
	
				//st.setString(1, a1.getName());
				st.setString(1, a1.getType());
				st.setString(2, a1.getTimestamp());
				st.setInt(3, a1.getId());
				st.executeUpdate();
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}
}

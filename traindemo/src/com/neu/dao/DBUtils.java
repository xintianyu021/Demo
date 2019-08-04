package com.neu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DBUtils {
	private String driverClassname = "com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8";
	private String username ="root";
	private String password ="root";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driverClassname);
		Connection connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
	
	public void closeconnection(Connection connection) throws SQLException {
		connection.close();
	}
	
	public int executeUpdate(String sql,Object... params) throws SQLException, ClassNotFoundException {
		
		Connection connection = getConnection();
		
		java.sql.PreparedStatement statement = connection.prepareStatement(sql);
		
		if(params!=null) {
			//把params中每一个值，赋值给sql语句中的占位符（？）
			for(int i=0;i<params.length;i++) {
				statement.setObject(i+1, params[i]);
			}
		}
		
		int n =statement.executeUpdate();
		statement.close();
		
		closeconnection(connection);
		
		return n;
		
		
		
	}
	
	
	public ResultSet executeQuery(Connection connection,String sql,Object...params) throws SQLException {
		
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		
		if(params!=null) {
			//把params中每一个值，赋值给sql语句中的占位符（？）
			for(int i=0;i<params.length;i++) {
				statement.setObject(i+1, params[i]);
			}
		}
		
		ResultSet rs = statement.executeQuery();
//		statement.close();
	
		return rs;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

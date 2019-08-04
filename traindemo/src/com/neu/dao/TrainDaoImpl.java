package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neu.entity.Train;

public class TrainDaoImpl implements TrainDao {

	@Override
	public List<Train> getAll() throws Exception {
		DBUtils db = new DBUtils();
		Connection connection = db.getConnection();
		String sql = "select * from train_info";
		ResultSet rs = db.executeQuery(connection, sql);
		List<Train> list = new ArrayList<>();
		Train t ;
		String train_no;
		String start_station;
		String arrival_station;
		String start_time;
		String arrival_time;
		String type;
		String runtime;
		double mile;
		while(rs.next()) {
			train_no = rs.getString("train_no");
			start_station = rs.getString("start_station");
			arrival_station = rs.getString("arrival_station");
			start_time = rs.getString("start_time");
			arrival_time = rs.getString("arrival_time");
			type = rs.getString("type");
			runtime = rs.getString("runtime");
			mile =rs.getDouble("mile");
			t = new Train(train_no, start_station, arrival_station, start_time, arrival_time, type, runtime, mile);
			list.add(t);
			
		}
		db.closeconnection(connection);
		return list;
	}

	@Override
	public Train getById(String trainno) throws Exception {
		DBUtils db= new DBUtils();
		String sql = "select * from train_info where train_no = ?";
		Connection connection = db.getConnection();
		ResultSet rs = db.executeQuery(connection, sql, trainno);
		Train train =new Train();
		if(rs.next()) {
			String startstation = rs.getString("start_station");
			String arrivalstation = rs.getString("arrival_station");
			String starttime = rs.getString("start_time");
			String arrivaltime = rs.getString("arrival_time");
			String type = rs.getString("type");
			String runtime = rs.getString("runtime");
			Double mile =rs.getDouble("mile");
			train = new Train(trainno, startstation, arrivalstation, starttime, arrivaltime, type, runtime, mile);
		}
		return train;
	}

	@Override
	public int delete(String trainno) throws Exception {
		DBUtils db = new DBUtils();
		String sql = "delete from train_info where train_no = ?";
		int n = db.executeUpdate(sql, trainno);
		return n;
	}

	@Override
	public List<Train> getPage(int pageSize, int pageNum) throws Exception {
		DBUtils db = new DBUtils();
		Connection connection = db.getConnection();
		String sql = "select * from train_info order by train_no limit ?,?";
		
		ResultSet rs = db.executeQuery(connection, sql,(pageNum-1)*pageSize,pageSize);
		List<Train> list = new ArrayList<>();
		Train t ;
		String train_no;
		String start_station;
		String arrival_station;
		String start_time;
		String arrival_time;
		String type;
		String runtime;
		double mile;
		while(rs.next()) {
			train_no = rs.getString("train_no");
			start_station = rs.getString("start_station");
			arrival_station = rs.getString("arrival_station");
			start_time = rs.getString("start_time");
			arrival_time = rs.getString("arrival_time");
			type = rs.getString("type");
			runtime = rs.getString("runtime");
			mile =rs.getDouble("mile");
			t = new Train(train_no, start_station, arrival_station, start_time, arrival_time, type, runtime, mile);
			list.add(t);
			
		}
		db.closeconnection(connection);
		return list;
	}

	@Override
	public int count() throws Exception {
		DBUtils db = new DBUtils();
		String sql = "select count(*) from train_info";
		Connection connection = db.getConnection();
		ResultSet rs = db.executeQuery(connection, sql);
		int count = 0;
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		return count;
	}

}

package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neu.entity.RoomType;
import com.neu.util.DBUtil;

public class RoomTypeDaoImpl implements RoomTypeDao {
	
	DBUtil u = new DBUtil();
	
	@Override
	public List<RoomType> getAll(int pageSize,int pageNum) throws Exception {
		String sql = "select * from roomtype order by roomtype limit ?,?";
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c,(pageNum-1)*pageSize,pageSize);
		
		if(!r.next()) {
			u.closeConnection(c);
			return null;
		}
		
		List<RoomType> list = new ArrayList<>();
		
		do {
			int id = r.getInt("id");
			String roomtype = r.getString("roomtype");
			String typename = r.getString("typename");
			
			RoomType rt = new RoomType(id, roomtype, typename);
			list.add(rt);
		}
		while(r.next());
		u.closeConnection(c);
		return list;
	}

	@Override
	public RoomType getById(String roomtype) throws Exception {
		String sql = "select * from roomtype where roomtype=?";
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c,roomtype);
		
		if(!r.next()) {
			u.closeConnection(c);
			return null;
		}
		
		RoomType rt =null;
		
		do {
			int id = r.getInt("id");
			String typename = r.getString("typename");
			
			rt = new RoomType(id, roomtype, typename);
			
		}
		while(r.next());
		u.closeConnection(c);
		return rt;
	}

	@Override
	public List<RoomType> getAll() throws Exception {
		String sql = "select * from roomtype order by roomtype ";
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c);
		
		if(!r.next()) {
			u.closeConnection(c);
			return null;
		}
		
		List<RoomType> list = new ArrayList<>();
		
		do {
			int id = r.getInt("id");
			String roomtype = r.getString("roomtype");
			String typename = r.getString("typename");
			
			RoomType rt = new RoomType(id, roomtype, typename);
			list.add(rt);
		}
		while(r.next());
		u.closeConnection(c);
		return list;
	}

	@Override
	public int insert(RoomType roomtype) throws Exception {
		String sql ="insert into roomtype(id,roomtype,typename) values(?,?,?)";
		int n = u.executeUpdate(sql, roomtype.getId(),roomtype.getRoomtype(),roomtype.getTypename());
		
		return n;
	}

	@Override
	public int update(RoomType roomtype) throws Exception {
		String sql="update roomtype set id=?,typename=? where roomtype=?";
		int n = u.executeUpdate(sql, roomtype.getId(),roomtype.getTypename(),roomtype.getRoomtype());
		
		return n;
	}

	@Override
	public int delete(String roomtype) throws Exception {
		String sql="delete from roomtype where roomtype=?";
		int n = u.executeUpdate(sql, roomtype);
		return n;
	}

	@Override
	public int count() throws Exception {
		String sql ="select count(*) from roomtype";
		Connection c = u.getConnection();
		ResultSet re = u.executeQuery(sql, c);
		int count = 0;
		
		if(re.next()) {
			count = re.getInt(1);
		}
		u.closeConnection(c);
		return count;
	}

}

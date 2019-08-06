package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.neu.entity.GuestRoom;
import com.neu.entity.RoomType;
import com.neu.entity.Storey;
import com.neu.util.DBUtil;

public class GuestRoomDaoImpl implements GuestRoomDao {
	DBUtil util = new DBUtil();
	@Override
	public List<GuestRoom> getAll(int pageSize,int pageNum) throws Exception {
		Connection connection = util.getConnection();
		String sql="select * from guestroom order by roomid limit ?,?";
      
      ResultSet rs = util.executeQuery(sql, connection, (pageNum-1)*pageSize,pageSize);
         Integer id;
		 String  roomid;
		
		 RoomTypeDao rDao = new RoomTypeDaoImpl();
		 RoomType roomtype = null;
		
		 StoreyDao sDao = new StoreyDaoImpl();
		 Storey storey =null;
		 
		 Double price;
		 Double dis;
		 Double vipdis;
		 Double svipdis;
		 String roomstate;
		 
		 GuestRoom quset=null;
		 List<GuestRoom> list = new ArrayList<>();
		 
		 while(rs.next()) {
				id=rs.getInt("id");
				roomid=rs.getString("roomid");
				
				roomtype=rDao.getById(rs.getString("roomtype"));
				storey=sDao.getById(rs.getString("storey"));
				
				price=rs.getDouble("price");
				dis=rs.getDouble("dis");
				vipdis=rs.getDouble("vipdis");
				svipdis=rs.getDouble("svipdis");
				roomstate = rs.getString("roomstate");
				quset=new GuestRoom(id, roomid, roomtype, storey, price, dis, vipdis, svipdis, roomstate);
				list.add(quset);
			 
		 }
         util.closeConnection(connection);		
		return list.size()==0?null:list;
	}
    
	@Override
	public int insert(GuestRoom guest) throws Exception {
        String sql="insert into guestroom where id=null,roomid=?,roomtype=?,storey=?";
        
		
		int n =util.executeUpdate(sql,guest.getRoomid(),guest.getRoomid(),guest.getStorey());
		
		return n;
	
	}

	@Override
	public int update(GuestRoom guest) throws Exception {
		String sql="update guestroom set roomstate=? , price=? , dis=?,vipdis=?,svipdis=? where roomid = ? ";
		int n = util.executeUpdate(sql, guest.getRoomstate() , guest.getPrice() ,guest.getDis() , guest.getVipdis(), guest.getSvipdis() , Integer.parseInt(guest.getRoomid()));
		
		return n;
	}

	@Override
	public int delete(GuestRoom guest) throws Exception {
	  String sql="delete from guestroom where roomid=? ";
	  int n = util.executeUpdate(sql,guest.getRoomid() );
	  return n;
	}

	@Override
	public GuestRoom getById(int roomid, int pageSize,int pageNum) throws Exception {
		Connection connection = util.getConnection();
		String sql="select * from guestroom where roomid=?  "
				+ "limit ?,?";
		
		ResultSet rs = util.executeQuery( sql,connection, roomid,(pageNum-1)*pageSize,pageSize);
		GuestRoom quset = null;
		 Integer id;
		
		 RoomTypeDao rDao = new RoomTypeDaoImpl();
		 RoomType roomtype = null;
		
		 StoreyDao sDao = new StoreyDaoImpl();
		 Storey storey =null;
		 
		 
		 
		 Double price;
		 Double dis;
		 Double vipdis;
		 Double svipdis;
		 String roomstate;
		 
		 String roomid1 = Integer.toString(roomid);
		 
		if(rs.next()) {
		id=rs.getInt("id");
		
		roomtype=rDao.getById(rs.getString("roomtype"));
		storey=sDao.getById(rs.getString("storey"));
		
		price=rs.getDouble("price");
		dis=rs.getDouble("dis");
		vipdis=rs.getDouble("vipdis");
		svipdis=rs.getDouble("svipdis");
		roomstate = rs.getString("roomstate");
		quset=new GuestRoom(id, roomid1, roomtype, storey, price, dis, vipdis, svipdis, roomstate);
		}
        util.closeConnection(connection);
		return quset;
	}

	@Override
	public List<GuestRoom> getByType(RoomType roomtype ,int pageSize,int pageNum) throws Exception {
		Connection connection = util.getConnection();
		String sql="select * from guestroom where roomtype=?"
				+ "limit?,?";
		ResultSet rs = util.executeQuery( sql,connection, roomtype,(pageNum-1)*pageSize,pageSize);
		GuestRoom quset = null;
		
		Integer id;
		Integer  roomid;
		 RoomTypeDao rDao = new RoomTypeDaoImpl();
		
		 StoreyDao sDao = new StoreyDaoImpl();
		 Storey storey =null;
		 
		 Double price;
		 Double dis;
		 Double vipdis;
		 Double svipdis;
		 String roomstate;
		 
		 List<GuestRoom> list = new ArrayList<>();
		 while(rs.next()) {
			 id=rs.getInt("id");
			 roomid = rs.getInt("roomid");
			 roomtype=rDao.getById(rs.getString("roomtype"));
			 storey=sDao.getById(rs.getString("storey"));
			 String roomid1 = Integer.toString(roomid);
			 
			price=rs.getDouble("price");
				dis=rs.getDouble("dis");
				vipdis=rs.getDouble("vipdis");
				svipdis=rs.getDouble("svipdis");
				roomstate = rs.getString("roomstate");
				quset=new GuestRoom(id, roomid1, roomtype, storey, price, dis, vipdis, svipdis, roomstate);
			 list.add(quset);
			 
		 }
        util.closeConnection(connection);
		return list.size()==0?null:list;
	}

	@Override
	public List<GuestRoom> getByStorey(Storey storey, int pageSize,int pageNum) throws Exception {
		Connection connection = util.getConnection();
		String sql="select * from guestroom where storey=?"
				+ "limit?,?";
		
		ResultSet rs = util.executeQuery( sql,connection, storey,(pageNum-1)*pageSize,pageSize);
		GuestRoom quset = null;
		
		Integer id;
		Integer  roomid;
		 RoomTypeDao rDao = new RoomTypeDaoImpl();
		 RoomType roomtype = null;
		 StoreyDao sDao = new StoreyDaoImpl();
		 
		 
		 Double price;
		 Double dis;
		 Double vipdis;
		 Double svipdis;
		 String roomstate;
		 
		 List<GuestRoom> list = new ArrayList<>();
		 while(rs.next()) {
			id=rs.getInt("id");
			roomid=rs.getInt("roomid");
			
			String roomid1 = Integer.toString(roomid);
			
			roomtype=rDao.getById(rs.getString("roomtype"));
			storey = sDao.getById(rs.getString("storey"));
			
			price=rs.getDouble("price");
			dis=rs.getDouble("dis");
			vipdis=rs.getDouble("vipdis");
			svipdis=rs.getDouble("svipdis");
			roomstate = rs.getString("roomstate");
			quset=new GuestRoom(id, roomid1, roomtype, storey, price, dis, vipdis, svipdis, roomstate);
			list.add(quset);
			 
		 }
        util.closeConnection(connection);
		return list.size()==0?null:list;
	}

	@Override
	public List<GuestRoom> getRoom(String roomtype, String roomstate, int pageSize, int pageNum) throws Exception {
		Connection connection = util.getConnection();
	      String sql="select * from guestroom where roomtype=? and roomstate=? limit ?,?";
	     
	      ResultSet rs = util.executeQuery(sql, connection,roomtype,roomstate, (pageNum-1)*pageSize,pageSize);
	      Integer id;
	      Integer  roomid;
			
			 RoomTypeDao rDao = new RoomTypeDaoImpl();
			 
			
			 StoreyDao sDao = new StoreyDaoImpl();
			 Storey storey =null;
			 
			 Double price;
			 Double dis;
			 Double vipdis;
			 Double svipdis;
			 
			 
			 GuestRoom quset=null;
			 List<GuestRoom> list = new ArrayList<>();
			 
			 RoomType roomType = new RoomType();
			 
			 while(rs.next()) {
					id=rs.getInt("id");
					roomid=rs.getInt("roomid");
					
					String roomid1 = Integer.toString(roomid);
					
					roomType=rDao.getById(roomtype);
					storey=sDao.getById(rs.getString("storey"));
					
					price=rs.getDouble("price");
					dis=rs.getDouble("dis");
					vipdis=rs.getDouble("vipdis");
					svipdis=rs.getDouble("svipdis");
					roomstate = rs.getString("roomstate");
					quset=new GuestRoom(id, roomid1, roomType, storey, price, dis, vipdis, svipdis, roomstate);
					list.add(quset);
				 
			 }
	         util.closeConnection(connection);		
			return list.size()==0?null:list;
		}
	@Override
	public int count() throws Exception {
		String sql ="select count(*) from guestroom";
		Connection connection = util.getConnection();
		ResultSet rs = util.executeQuery(sql, connection);
		int count =0;
		if(rs.next()) {
			count = rs.getInt(1);
		}
		util.closeConnection(connection);
		return count;
	}



	@Override
	public List<GuestRoom> getEmptyRoom(String roomstate, int pageSize, int pageNum) throws Exception {
		Connection connection = util.getConnection();
	      String sql="select * from guestroom where roomstate = ? limit ?,?";
	      ResultSet rs = util.executeQuery(sql, connection,roomstate,(pageNum-1)*pageSize,pageSize);
	         Integer id;
			 String  roomid;
			 String storey;
			 Double price;
			 Double dis;
			 Double vipdis;
			 Double svipdis;
			 String roomtype;
			 RoomTypeDao rDao = new RoomTypeDaoImpl();	
			 StoreyDao sDao = new StoreyDaoImpl();
			 RoomType roomType = new RoomType();
			 Storey storey1 = new Storey();
			 GuestRoom quset=null;
			 List<GuestRoom> list = new ArrayList<>();
			 while(rs.next()) {
				 id=rs.getInt("id");
				 roomid=rs.getString("roomid");
				 roomtype=rs.getString("roomtype");
				 roomType=rDao.getById(roomtype);
				 storey=rs.getString("storey");
				 storey1 = sDao.getById(storey);
				 price=rs.getDouble("price");
				 dis=rs.getDouble("dis");
				 vipdis=rs.getDouble("vipdis");
				 svipdis=rs.getDouble("svipdis");
				 roomstate = rs.getString("roomstate");
				 quset=new GuestRoom(id, roomid, roomType, storey1, price, dis, vipdis, svipdis, roomstate);
				 list.add(quset);
				 
			 }
	         util.closeConnection(connection);		
			return list.size()==0?null:list;
	}

	@Override
	public int typeCount(String roomtype) throws Exception {
		String sql ="select count(*) from guestroom where roomtype = ? and roomstate = ?";
		Connection connection = util.getConnection();
		String roomstate = "ø’œ–÷–";
		ResultSet rs = util.executeQuery(sql, connection, roomtype,roomstate);
		int count =0;
		if(rs.next()) {
			count = rs.getInt(1);
		}
		util.closeConnection(connection);
		return count;
	}

	@Override
	public int pageCount() throws Exception {
		String sql ="select count(*) from guestroom where roomstate = ?";
		Connection connection = util.getConnection();
		String roomstate = "ø’œ–÷–";
		ResultSet rs = util.executeQuery(sql, connection,roomstate);
		int count =0;
		if(rs.next()) {
			count = rs.getInt(1);
		}
		util.closeConnection(connection);
		
		return count;
	}

	@Override
	public GuestRoom getByRoomId(String roomid) throws Exception {
		Connection connection = util.getConnection();
		String sql="select * from guestroom where roomid=?";
		
		ResultSet rs = util.executeQuery( sql,connection, Integer.parseInt(roomid));
		GuestRoom quset = null;
		 Integer id;
		
		 RoomTypeDao rDao = new RoomTypeDaoImpl();
		 RoomType roomtype = null;
		 StoreyDao sDao = new StoreyDaoImpl();
		 Storey storey =null;
		 Double price;
		 Double dis;
		 Double vipdis;
		 Double svipdis;
		 String roomstate;
		if(rs.next()) {
		id=rs.getInt("id");
		
		roomtype=rDao.getById(rs.getString("roomtype"));
		storey=sDao.getById(rs.getString("storey"));
		
		price=rs.getDouble("price");
		dis=rs.getDouble("dis");
		vipdis=rs.getDouble("vipdis");
		svipdis=rs.getDouble("svipdis");
		roomstate = rs.getString("roomstate");
		quset=new GuestRoom(id, roomid, roomtype, storey, price, dis, vipdis, svipdis, roomstate);
		}
        util.closeConnection(connection);
		return quset;
	}

}

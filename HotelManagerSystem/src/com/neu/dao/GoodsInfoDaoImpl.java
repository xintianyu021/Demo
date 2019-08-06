package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neu.entity.GoodsInfo;
import com.neu.entity.GoodsType;
import com.neu.util.DBUtil;

public class GoodsInfoDaoImpl implements GoodsInfoDao {
	private static DBUtil db = new DBUtil();
	@Override
	public int insert(GoodsInfo goodsinfo) throws Exception {
		String sql = "insert into goodsinfo values(0,?,?,?,?,?,?)";
		Object[] params = {
				goodsinfo.getGoodid(),
				goodsinfo.getGoodname(),
				goodsinfo.getGoodstype()==null?null:goodsinfo.getGoodstype().getGoodtype(),
				goodsinfo.getPrice(),
				goodsinfo.getUnit(),
				goodsinfo.getNotes()
		};
		int n =db.executeUpdate(sql, params);
		return n;
	}

	@Override
	public int update(GoodsInfo goodsinfo) throws Exception {
		String sql = "update goodsinfo set goodname = ?,goodtype = ?,price = ?,unit = ?,notes = ? where goodid = ?";
		Object[] params = {
				goodsinfo.getGoodname(),
				goodsinfo.getGoodstype().getGoodtype(),
				goodsinfo.getPrice(),
				goodsinfo.getUnit(),
				goodsinfo.getNotes(),
				goodsinfo.getGoodid()
		};
		int n =db.executeUpdate(sql, params);
		return n;
	}

	@Override
	public int delete(String goodid) throws Exception {
		String sql = "delete from goodsinfo where goodid = ?";
		int n = db.executeUpdate(sql, goodid);
		return n;
	}

	@Override
	public List<GoodsInfo> getByType(String goodtype,int pageSize,int pageNum) throws Exception {
		String sql = "select * from goodsinfo where goodtype = ? order by goodid limit ?,?";
		Connection connection = db.getConnection();
		ResultSet rs = db.executeQuery(sql, connection, goodtype,(pageNum-1)*pageSize,pageSize);
		GoodsInfo goodsinfo = null;
		List<GoodsInfo> list = new ArrayList<GoodsInfo>();
		GoodsTypeDao dao = new GoodsTypeDaoImpl();
		GoodsType goodstype = null;
		String goodid;
		String goodname;
		double price;
		String unit;
		String notes;
		while(rs.next()) {
			goodid = rs.getString("goodid");
			goodname = rs.getString("goodname");
			price = rs.getDouble("price");
			unit = rs.getString("unit");
			notes = rs.getString("notes");
			goodstype = dao.getById(goodtype);
			goodsinfo = new GoodsInfo(0, goodid, goodname, goodstype, price, unit, notes);
			list.add(goodsinfo);
		}
		db.closeConnection(connection);
		return list.size()==0?null:list;
	}

	@Override
	public List<GoodsInfo> getAll(int pageSize, int pageNum) throws Exception {
		String sql = "select * from goodsinfo order by goodid limit ?,? ";
		Connection connection = db.getConnection();
		ResultSet rs = db.executeQuery(sql, connection, (pageNum-1)*pageSize,pageSize);
		GoodsInfo goodsinfo = null;
		List<GoodsInfo> list = new ArrayList<GoodsInfo>();
		GoodsTypeDao dao = new GoodsTypeDaoImpl();
		GoodsType goodstype = null;
		String goodid;
		String goodname;
		double price;
		String unit;
		String notes;
		while(rs.next()) {
			goodid = rs.getString("goodid");
			goodname = rs.getString("goodname");
			price = rs.getDouble("price");
			unit = rs.getString("unit");
			notes = rs.getString("notes");
			goodstype = dao.getById(rs.getString("goodtype"));
			goodsinfo = new GoodsInfo(0, goodid, goodname, goodstype, price, unit, notes);
			list.add(goodsinfo);
		}
		db.closeConnection(connection);
		return list.size()==0?null:list;
	}

	@Override
	public GoodsInfo getById(String goodid) throws Exception {
		String sql = "select * from goodsinfo where goodid = ?";
		Connection connection = db.getConnection();
		ResultSet rs = db.executeQuery(sql, connection, goodid);
		GoodsType goodstype = null;
		String typename;
		String notes;
		GoodsTypeDao dao = new GoodsTypeDaoImpl();
		GoodsInfo goodsinfo = null;
		if(rs.next()) {
			goodid = rs.getString("goodid");
			String goodname = rs.getString("goodname");
			double price = rs.getDouble("price");
			String unit = rs.getString("unit");
			notes = rs.getString("notes");
			goodstype = dao.getById(rs.getString("goodtype"));
			goodsinfo = new GoodsInfo(0, goodid, goodname, goodstype, price, unit, notes);
		}
		db.closeConnection(connection);
		return goodsinfo;
	}

	@Override
	public int count() throws Exception {
		String sql = "select count(*) from goodsinfo";
		Connection connection = db.getConnection();
		ResultSet rs = db.executeQuery(sql, connection);
		rs.next();
		int pages = rs.getInt(1);
		
		db.closeConnection(connection);
		return pages;
	}

	@Override
	public int countByType(String goodtype) throws Exception {
		String sql = "select count(*) from goodsinfo where goodtype=?";
		Connection connection = db.getConnection();
		ResultSet rs = db.executeQuery(sql, connection , goodtype);
		rs.next();
		int pages = rs.getInt(1);
		
		db.closeConnection(connection);
		return pages;
	}

}

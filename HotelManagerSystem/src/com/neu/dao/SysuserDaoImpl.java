package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.neu.entity.Sysuser;
import com.neu.util.DButils;

public class SysuserDaoImpl implements SysuserDao {
	DButils util = new DButils();
	@Override
	public int update(Sysuser sys) throws Exception {
		String sql="update sysuser set userid=?, usertype=?,username=?,password=?,note=? where id=? ";
		Object[] params= {
			sys.getUserid(),
			sys.getUsertype(),
			sys.getUsername(),
			sys.getPassword(),
			sys.getNote(),
			sys.getId()
		};
		int n = util.executeUpdate(sql, params);
		return n;
	}

	@Override
	public int insert(Sysuser sys) throws Exception {
		String sql ="insert into sysuser(userid,usertype,username,password,note) values(?,?,?,?,?)";
		Object[] params = {
				sys.getUserid(),
				sys.getUsertype(),
				sys.getUsername(),
				sys.getPassword(),
				sys.getNote()
		};
		int n = util.executeUpdate(sql, params);
		return n;
	}

	@Override
	public int delete(int id) throws Exception {
		String sql="delete from sysuser where id=?";
		int n = util.executeUpdate(sql, id);
		return n;
	}

	@Override
	public Sysuser getByidname(String userid, String username) throws Exception {
		String sql="select * from sysuser where userid=? and username=?";
		Connection connection = util.getConnection();
		ResultSet re = util.executeQuery(connection, sql, userid,username);
		Sysuser sys = null;
		if(re.next()) {
			int id = re.getInt("id");
			String usertype = re.getString("usertype");
			String password = re.getString("password");
			String note = re.getString("note");
			sys = new Sysuser(id, userid, usertype, username, password, note);
		}
		util.closeConnection(connection);
		return sys;
	}

	@Override
	public Sysuser getByname(String username) throws Exception {
		String sql="select * from sysuser where username=?";
		Connection connection = util.getConnection();
		ResultSet re = util.executeQuery(connection, sql,username);
		Sysuser sys = null;
		if(re.next()) {
			int id = re.getInt("id");
			String userid = re.getString("userid");
			String usertype = re.getString("usertype");
			String password = re.getString("password");
			String note = re.getString("note");
			sys = new Sysuser(id, userid, usertype, username, password, note);
		}
		util.closeConnection(connection);
		return sys;
	}

	@Override
	public Sysuser getByid(String userid) throws Exception {
		String sql="select * from sysuser where userid=?";
		Connection connection = util.getConnection();
		ResultSet re = util.executeQuery(connection, sql,userid);
		Sysuser sys = null;
		if(re.next()) {
			int id = re.getInt("id");
			String username = re.getString("username");
			String usertype = re.getString("usertype");
			String password = re.getString("password");
			String note = re.getString("note");
			sys = new Sysuser(id, userid, usertype, username, password, note);
		}
		util.closeConnection(connection);
		return sys;
	}

}

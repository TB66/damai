package com.tb.damai.dao;

import java.util.List;
import java.util.Map;

import com.tb.damai.util.DBHelper;

public class OrdersDao {
	public int add(Double total,Integer uid,Integer aid) {
		String sql="insert into dm_orders(total,uid,aid) values(?,?,?)";
		return new DBHelper().update(sql, total,uid,aid);
	}
	public Map<String, Object> query(Double total,Integer uid) {
		String sql="select * from dm_orders where total=? and uid=?";
		return new DBHelper().query(sql, total,uid).get(0);
	}
	public Map<String, Object> queryByid(Integer id) {
		String sql="select a.*,b.addr,b.phone,b.name from dm_orders a join dm_address b on a.aid=b.id where a.id=?";
		return new DBHelper().query(sql, id).get(0);
	}
	public int changeState(Integer id) {
		String sql="update dm_orders set state=1 where id=?";
		return new DBHelper().update(sql, id);
	}
	public List<Map<String, Object>> queryOid(Integer id) {
		String sql="select id,total,state from dm_orders where uid=?";
		return new DBHelper().query(sql, id);
	}
}

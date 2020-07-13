package com.tb.damai.dao;

import java.util.List;
import java.util.Map;


import com.tb.damai.util.DBHelper;

public class CartDao {
	DBHelper db=new DBHelper();
	public int insert(Integer uid,Integer pid,Integer count) {
		String sql="insert into dm_cart(uid,pid,count) values(?,?,?)";
		return db.update(sql, uid,pid,count);
	}
	public int update(Integer uid,Integer pid,Integer count) {
		String sql="update dm_cart set count=count+? where uid=? and pid=?";
		return db.update(sql, count,uid,pid);
	}
	public List<Map<String, Object>> query(Integer uid){
		String sql="select * from dm_cart a join dm_product b on a.pid=b.id where a.uid=?";
		return db.query(sql,uid);
	}
	
	public void del(Integer id) {
		db.update("delete  from dm_cart where id=?", id);
	}
	public void delAll(Integer uid) {
		db.update("delete  from dm_cart where uid=?", uid);
	}
	
}

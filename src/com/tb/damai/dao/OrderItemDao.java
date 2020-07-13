package com.tb.damai.dao;

import java.util.List;
import java.util.Map;

import com.tb.damai.util.DBHelper;

public class OrderItemDao {
	DBHelper db=new DBHelper();
	public int add(Integer count,Double total,Integer pid,Integer oid) {
		String sql="insert into dm_orderitem(count,total,pid,oid) values(?,?,?,?) ";
		return db.update(sql, count,total,pid,oid);
	}
	public List<Map<String, Object>> query(Integer uid){
		String sql="select * from dm_orderitem a join dm_orders b on a.oid=b.id where b.uid=?";
		return db.query(sql,uid);
	}
	public List<Map<String, Object>> queryByOid(Integer oid){
		String sql = "select a.count,b.pname,b.image,b.shop_price,c.total from dm_orderitem a join dm_product b join dm_orders c on a.pid=b.id and a.oid=c.id where oid=?";
		return db.query(sql,oid);
	}
}

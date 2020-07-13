package com.tb.damai.dao;

import java.util.ArrayList;
import java.util.List;

import com.tb.damai.po.DmUser;
import com.tb.damai.util.DBHelper;

public class UserDao {
	DBHelper db = new DBHelper();
	public void reg(String ename, String cname,String password, String email,String phone, String sex) {
		String sql="insert into dm_user(ename,cname,password,email,phone,sex) values(?,?,?,?,?,?) ";
		db.update(sql, ename,cname,password,email,phone,sex);
	}
	public List<DmUser> query(DmUser user){
		String sql = "select * from dm_user where 1=1 ";
		List<Object> params=new ArrayList<Object>();
		if(user.getId()!=null) {
			sql+=" and id=? ";
			params.add(user.getId());
		}
		if(user.getEname()!=null) {
			sql+=" and ename=? ";
			params.add(user.getEname());
		}
		if(user.getCname()!=null) {
			sql+=" and cname=? ";
			params.add(user.getCname());
		}
		if(user.getPassword()!=null) {
			sql+=" and password=? ";
			params.add(user.getPassword());
		}
		if(user.getEmail()!=null) {
			sql+=" and email=? ";
			params.add(user.getEmail());
		}
		if(user.getPhone()!=null) {
			sql+=" and phone=? ";
			params.add(user.getPhone());
		}
		if(user.getSex()!=null) {
			sql+=" and sex=? ";
			params.add(user.getSex());
		}
		if(user.getState()!=null) {
			sql+=" and state=? ";
			params.add(user.getState());
		}
		if(user.getCreatetime()!=null) {
			sql+=" and createtime=? ";
			params.add(user.getCreatetime());
		}
		return db.query(sql, DmUser.class, params.toArray());
	}
}

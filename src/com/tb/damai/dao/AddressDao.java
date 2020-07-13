package com.tb.damai.dao;
import java.util.List;
import java.util.Map;

import com.tb.damai.util.DBHelper;

public class AddressDao {
	public Map<String, Object> query(Integer uid) {
		String sql="select * from dm_address where uid=? and dft=1";
		return new DBHelper().query(sql, uid).get(0);
	}
}

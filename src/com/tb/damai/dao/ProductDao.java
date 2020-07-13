package com.tb.damai.dao;


import java.util.ArrayList;
import java.util.List;

import com.tb.damai.po.DmProduct;
import com.tb.damai.util.DBHelper;



public class ProductDao {
	public List<DmProduct> query(DmProduct product,int start,int end){
		String sql = "select * from dm_product where 1=1 ";
		List<Object> params=new ArrayList<Object>();
		if(product.getId()!=null) {
			sql+=" and id=? ";
			params.add(product.getId());
		}
		if(product.getPname()!=null && product.getPname().trim().isEmpty()==false) {
			sql+=" and pname like ? ";
			params.add("%" + product.getPname() + "%");
		}
		if(product.getMarket_price()!=null) {
			sql+=" and market_price=? ";
			params.add(product.getMarket_price());
		}
		if(product.getShop_price()!=null) {
			sql+=" and shop_price=? ";
			params.add(product.getShop_price());
		}
		if(product.getImage()!=null && product.getImage().trim().isEmpty()==false) {
			sql+=" and image like ? ";
			params.add("%" + product.getImage() + "%");
		}
		if(product.getPdesc()!=null && product.getPdesc().trim().isEmpty()==false) {
			sql+=" and pdesc like ? ";
			params.add("%" + product.getPdesc() + "%");
		}
		if(product.getIs_hot()!=null) {
			sql+=" and is_hot=? ";
			params.add(product.getIs_hot());
		}
		if(product.getCreatetime()!=null) {
			sql+=" and createtime=? ";
			params.add(product.getCreatetime());
		}
		if(product.getCid()!=null) {
			sql+=" and cid=? ";
			params.add(product.getCid());
		}
		sql+=" limit ?,?";
		params.add(start);
		params.add(end);
		return new DBHelper().query(sql, DmProduct.class, params.toArray());
		
	}
	
}

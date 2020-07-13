package com.tb.damai.orders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tb.damai.dao.AddressDao;
import com.tb.damai.dao.CartDao;
import com.tb.damai.dao.OrderItemDao;
import com.tb.damai.dao.OrdersDao;
import com.tb.damai.po.DmUser;
import com.tb.damai.web.BaseServlet;

@WebServlet("/OrdersServlet")
public class OrdersServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderItemDao ordDao = new OrderItemDao();
	private OrdersDao od=new OrdersDao();

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double total = Double.valueOf(request.getParameter("total"));
		if (total == 0) {
			response.getWriter().print("没有商品无法提交");
			return;
		}
		DmUser user = (DmUser) request.getSession().getAttribute("user");
		Integer uid = user.getId();
		Map<String, Object> map1 = new AddressDao().query(uid);
		if(map1==null) {
			response.getWriter().print("请添加默认地址");
			return;
		}
		Integer aid = (Integer) map1.get("id");
		od.add(total, uid, aid);
		List<Map<String, Object>> list = new CartDao().query(uid);
		Map<String, Object> map = od.query(total, uid);
		for (int i = 0; i < list.size(); i++) {
			Integer count = (Integer) list.get(i).get("count");
			Double shop_price = (Double) list.get(i).get("shop_price");
			Double pidtotal = count * shop_price;
			Integer pid = (Integer) list.get(i).get("pid");
			Integer oid = (Integer) map.get("id");
			ordDao.add(count, pidtotal, pid, oid);
		}
		new CartDao().delAll(uid);

	}
	protected void changeState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer oid=Integer.valueOf(request.getParameter("oid"));
		int cnt=new OrdersDao().changeState(oid);
		if(cnt==1) {
			response.getWriter().print("支付成功");
		}else {
			response.getWriter().print("支付失败");
		}
	}
	protected void loadOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DmUser user=(DmUser) request.getSession().getAttribute("user");
		Integer uid=user.getId();
		if(uid==null) {
			response.getWriter().print("请登录");
			return;
		}
		
		List<Map<String, Object>> result=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> idList=od.queryOid(uid);
		for(int i=0;i<idList.size();i++) {
			Map<String, Object> ret=new HashMap<String, Object>();
			Map<String, Object> oidMap=idList.get(i);
			Integer oid=(Integer) oidMap.get("id");
			Double total=(Double) oidMap.get("total");
			Integer state=(Integer) oidMap.get("state");
			List<Map<String, Object>> orderItem=ordDao.queryByOid(oid);
			ret.put("state",state);
			ret.put("oid",oid);
			ret.put("total", total);
			ret.put("orderItem", orderItem);
			result.add(ret);
			
		}
		print(response, result);
		
	}

}
